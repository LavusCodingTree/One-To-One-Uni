package com.js.otou;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllPersons {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();

		String query = "select p from Person p";

		Query q = em.createNamedQuery(query);

		List<Person> persons = q.getResultList();

		if (!persons.isEmpty()) {
			for (Person p : persons) {

				System.out.println("Person Id = " + p.getId());
				System.out.println("Person Name = " + p.getName());
				System.out.println("Person Email = " + p.getEmail());
				System.out.println("Person Phone = " + p.getPhone());

				Pan pan = p.getPan();
				

				if (pan != null) {
					System.out.println("Pan Id = " + pan.getId());
					System.out.println("Pan No = " + pan.getPan_no());
					System.out.println("Pan Address = " + pan.getAddress());
				} else {
					System.out.println("Person has No Pan");
				}
				System.out.println("=============================================");
			}

		} else {
			System.out.println("No Person Avaliable");
		}
	}

}
