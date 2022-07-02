package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    public static EntityManagerFactory getEMFactory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Test");
        return factory;
    }
    public static EntityManager getEntityManager() {
        EntityManager em = JpaUtil.getEMFactory().createEntityManager();
        return em;
    }
}
