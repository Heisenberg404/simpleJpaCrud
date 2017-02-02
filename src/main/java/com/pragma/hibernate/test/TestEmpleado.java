package com.pragma.hibernate.test;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.pragma.hibernate.modelo.Empleado;
import com.pragma.hibernate.modelo.EntityManagerUtil;

public class TestEmpleado {
	
//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args){
		
		EntityManager manager = EntityManagerUtil.getEntityManager();	
		manager.getTransaction().begin();
		Empleado e = manager.find(Empleado.class, 8);
		e.setNombre("XXX");
		e.setApellido("XXX");
		manager.getTransaction().commit();
		printAll();
		manager.close();
		
		manager = EntityManagerUtil.getEntityManager();	
		manager.getTransaction().begin();
		e.setNombre("YYYY");
		manager.merge(e);
		manager.getTransaction().commit();
		printAll();
		manager.close();
		
	}

	private static void printAll() {
		EntityManager manager =  EntityManagerUtil.getEntityManager();	
		List<Empleado> list = manager.createQuery("FROM Empleado").getResultList();
		System.out.println("hay en bd: "+list.size());
		
		for (Empleado empleado : list) {
			System.out.println(empleado.getNombre().toString());
		}
		manager.close();
	}
	
	private static void insertData(){
		EntityManager manager =  EntityManagerUtil.getEntityManager();	
		Empleado empleado = new Empleado(null, "Jose", "Perez", new GregorianCalendar(1979,6,6).getTime());
		Empleado empleado1 = new Empleado(null, "Jose", "Perez", new GregorianCalendar(1979,6,6).getTime());
		Empleado empleado2 = new Empleado(null, "Jose", "Perez", new GregorianCalendar(1979,6,6).getTime());
		Empleado empleado3 = new Empleado(null, "Jose", "Perez", new GregorianCalendar(1979,6,6).getTime());
		
		manager.getTransaction().begin();
		manager.persist(empleado);
		manager.persist(empleado1);
		manager.persist(empleado2);
		manager.persist(empleado3);
		manager.getTransaction().commit();
		manager.close();
	}
}
