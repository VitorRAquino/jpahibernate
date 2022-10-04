package bibliotecaDAO;

import biblioteca.Categoria;
import biblioteca.Livro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class LivroDAO {
    private EntityManager em;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();


    public LivroDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Livro livro) {
        this.em.persist(livro);
    }

    public Livro buscarPorId(Long id) {
        return em.find(Livro.class, id);
    }

    public List<Livro> buscarTodos() {
        String jpql = "SELECT l FROM Livro l";
        return em.createQuery(jpql, Livro.class).getResultList();
    }
}
