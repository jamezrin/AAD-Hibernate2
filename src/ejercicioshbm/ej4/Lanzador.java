package ejercicioshbm.ej4;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import ejercicioshbm.SessionFactoryUtil;

public class Lanzador {
	public static void main(String[] args) {
		System.out.println("Ejercicio 4");
		File cfgPath = new File("resources/ej4/hibernate.cfg.xml");
		SessionFactory factory = SessionFactoryUtil.initSessionFactory(cfgPath);
		
		Direccion direccion = new Direccion();
		direccion.setCalle("Calle Santa Irene");
		direccion.setNumero(4);
		direccion.setPoblacion("Madrid");
		direccion.setProvincia("Madrid");
		
		Profesor profesor1 = new Profesor();
		profesor1.setNombre("Carlos");
		profesor1.setApe1("Gonzalez");
		profesor1.setApe2("Sanchez");
		profesor1.setDireccion(direccion);
		
		Correo correo1 = new Correo();
		correo1.setDireccion("algo@algo.com");
		correo1.setProveedor("gmail.com");
		List<Correo> correos = new ArrayList<>();
		correos.add(correo1);
		
		Profesor profesor2 = new Profesor();
		profesor2.setNombre("Luis");
		profesor2.setApe1("Izquierdo");
		profesor2.setApe2("Lopez");
		profesor2.setDireccion(direccion);
		profesor2.setCorreos(correos);
		
		System.out.println("\nProbando inserción de profesores");
		probarInsercion(factory, profesor1);
		probarInsercion(factory, profesor2);
		
		Modulo modulo = new Modulo();
		modulo.setCreditos(10f);
		modulo.setNombre("Programación");
		Set<Profesor> profesores = new HashSet<>();
		profesores.add(profesor1);
		profesores.add(profesor2);
		modulo.setProfesores(profesores);
		
		System.out.println("\nProbando lectura de profesores");
		probarLectura(factory, profesor1.getId(), Profesor.class);
		probarLectura(factory, profesor2.getId(), Profesor.class);
		
		System.out.println("\nProbando inserción de un modulo");
		probarInsercion(factory, modulo);
		
		System.out.println("\nProbando lectura de modulo");
		probarLectura(factory, modulo.getId(), Modulo.class);
	}
	
	private static void probarInsercion(SessionFactory factory, Serializable serializable) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(serializable);
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
	
	private static void probarLectura(SessionFactory factory, int id, Class<?> clazz) {
		Session session = factory.openSession();
		Object object = session.load(clazz, id);
		System.out.printf("Lectura correcta, objeto: %s\n", object);
		session.close();
	}
}
