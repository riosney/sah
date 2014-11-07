package sah.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (Exception e) {
			System.out
					.println("Cria��o inicial do objeto SessionFactory falhou. Erro: "
							+ e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}