package jpa;

import javax.persistence.*;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

public class JpaTest {

	public static void main(String[] args) {
/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();

		GenTestDao dao = new GenTestDao(manager);

		Person p = new Person("Dimas", "Espinasse", "Dimas.Espinasse@email.com");

		Person p1 = new Person("Helen", "Espinasse", "Helen.Espinasse@email.com");

		Home h = new Home(1000, 10, p);

		Home h1 = new Home(70, 4, p1);

		ElectronicDevice d = new ElectronicDevice(400, p1);

		ElectronicDevice d2 = new ElectronicDevice(90, p1);

		ElectronicDevice d3 = new ElectronicDevice(500, p1);

		ElectronicDevice d1 = new ElectronicDevice(500, p);

		Heater he1 = new Heater(h);

		Heater he2 = new Heater(h1);

		tx.begin();

		try {

			dao.create(p);

			dao.create(p1);

			dao.create(h);

			dao.create(h1);

			dao.create(d);

			dao.create(d2);

			dao.create(d3);

			dao.create(d1);

			dao.create(he1);

			dao.create(he2);

		} catch (Exception e) {

			e.printStackTrace();

		}

		// Person pr = (Person)dao.read((long) 1, Person.class);
		//
		// pr.getFriends().add(p1);
		//
		// dao.update(pr);

		tx.commit();

		manager.close();

		factory.close();
*/
	}

}