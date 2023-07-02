package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InserPersonPan {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p = new Person();
		p.setName("Lavanya");
		p.setEmail("lavz@gmail.com");
		p.setPhone(12345678);

		Pan pan = new Pan();
		pan.setPan_no("myself143");
		pan.setAddress("Mysore");

		p.setPan(pan);// for fk

		et.begin();
		em.persist(p);
		em.persist(pan);
		et.commit();
		System.out.println("Inserted Sucessfully");
	}

}
