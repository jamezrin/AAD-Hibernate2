package ejercicioshbm.ej3_2;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import ejercicioshbm.SessionFactoryUtil;

public class Lanzador {
	public static void main(String[] args) {
		System.out.println("Ejercicio 3.2");
		File cfgPath = new File("resources/ej3_2/hibernate.cfg.xml");
		SessionFactory factory = SessionFactoryUtil.initSessionFactory(cfgPath);
		
		Direccion direccion = new Direccion();
		direccion.setCalle("Calle Santa Irene");
		direccion.setNumero(4);
		direccion.setPoblacion("Madrid");
		direccion.setProvincia("Madrid");
		
		Profesor profesor = new Profesor();
		profesor.setNombre("Carlos");
		profesor.setApe1("Gonzalez");
		profesor.setApe2("Sanchez");
		profesor.setDireccion(direccion);
		
		System.out.println("\nProbando inserción");
		probarInsercion(factory, profesor);
		
		System.out.println("\nProbando lectura");
		probarLectura(factory, profesor.getId());
	}
	
	private static void probarInsercion(SessionFactory factory, Profesor profesor) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(profesor);
			tx.commit();
			System.out.println("Inserción correcta");
		} catch (ConstraintViolationException e) {
			if (tx != null) {
				System.err.println("Inserción incorrecta");
				e.printStackTrace();
				tx.rollback();
			}
		}
		
		session.close();
	}
	
	private static void probarLectura(SessionFactory factory, int id) {
		Session session = factory.openSession();
		Profesor profesor = session.load(Profesor.class, id);
		System.out.printf("Lectura correcta, objeto: %s\n", profesor);
		session.close();
	}
}
