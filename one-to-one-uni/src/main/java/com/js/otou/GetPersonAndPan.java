package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetPersonAndPan {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();

		Person p = em.find(Person.class, 3);

		if (p != null) {
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
		} else {
			System.out.println("No Person With Given Id");
		}
	}
}
