package br.com.biblioteca.DAO;

import br.com.biblioteca.model.Autor;

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
