package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMBuilder {

    private final static EntityManagerFactory FACTORY;

    static {
        FACTORY = Persistence.createEntityManagerFactory("labPU");
    }

    public static EntityManager getEM() {
        return FACTORY.createEntityManager();
    }

    public static void closeFactory() {
        FACTORY.close();
    }
}
