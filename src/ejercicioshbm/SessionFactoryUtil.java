package ejercicioshbm;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.beans.container.internal.NotYetReadyException;

public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory(File cfgPath) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure(cfgPath);
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		} catch (Throwable e) {
			System.err.println("Falló la creación de la factoría de sesiones inicial." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory initSessionFactory(File cfgPath) {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory(cfgPath);
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			throw new NotYetReadyException(
					new Throwable("Se ha intentado acceder a SessionFactory sin haber sido inicializada antes"));
		
		return sessionFactory;
	}
}
