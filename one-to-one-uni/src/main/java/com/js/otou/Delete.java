package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p = em.find(Person.class, 3);

		if (p != null) {

			Pan pan = p.getPan();

			if (pan != null) {

				et.begin();
				em.remove(p);
				em.remove(pan);
				et.commit();

				System.out.println("Deleted");

			} else {
				et.begin();
				em.remove(p);
				et.commit();
				System.out.println("Person has No Pan");
			}
		} else {
			System.out.println("No Person With Given Id");
		}
	}

}
