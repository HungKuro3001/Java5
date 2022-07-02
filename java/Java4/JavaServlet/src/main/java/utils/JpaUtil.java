package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	public static EntityManagerFactory getEMFactory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaServlet");
		return factory;
	}
	public static EntityManager getEntityManager() {
		EntityManager em = JpaUtil.getEMFactory().createEntityManager();
		return em;
	}
}
