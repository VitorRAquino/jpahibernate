package br.com.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("br/com/biblioteca/model");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
