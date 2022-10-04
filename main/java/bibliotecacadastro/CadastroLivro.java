package bibliotecacadastro;

import biblioteca.Autor;
import biblioteca.Categoria;
import biblioteca.Livro;
import bibliotecaDAO.AutorDAO;
import bibliotecaDAO.CategoriaDAO;
import bibliotecaDAO.LivroDAO;
import bibliotecaJPAUtil.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroLivro {

    public static void main(String[] args) {
        cadastrarLivro();
        EntityManager em = JPAUtils.getEntityManager();
        LivroDAO livroDao = new LivroDAO(em);

        Livro l = livroDao.buscarPorId(1l);
        List<Livro> todos = livroDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(l.getNome()));
        todos.forEach(p2 -> System.out.println(l.getDescricao()));
        todos.forEach(p2 -> System.out.println(l.getPreco()));
        todos.forEach(p2 -> System.out.println(l.getCategoria()));
        todos.forEach(p2 -> System.out.println(l.getAutor()));
    }
    private static void cadastrarLivro() {
        Categoria categoria = new Categoria("CELULARES");
        Autor autor = new Autor();
        Livro livro = new Livro(
                "Harry Potter e a Pedra Filosofal",
                "Harry Potter...",
                new BigDecimal("800"), categoria, autor
        );


        EntityManager em = JPAUtils.getEntityManager();
        LivroDAO livroDao = new LivroDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);
        AutorDAO autorDao = new AutorDAO(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        autorDao.cadastrar(autor);
        livroDao.cadastrar(livro);

        em.getTransaction().commit();
        em.close();
    }
}

