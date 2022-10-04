package bibliotecaDAO;

import biblioteca.Autor;
import biblioteca.Categoria;

import javax.persistence.EntityManager;

public class AutorDAO {

    private EntityManager em;

    public AutorDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Autor autor) {
        this.em.persist(autor);
    }
}
