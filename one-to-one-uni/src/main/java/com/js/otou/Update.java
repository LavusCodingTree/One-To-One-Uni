package com.js.otou;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("uday");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = em.find(Person.class, 1);
		
		if(p!=null) {
			p.setName("aaa");
			p.setEmail("aaa@gmail.com");
			p.setPhone(1234678);
		
			Pan pan = p.getPan();
			if(pan!=null) {
				pan.setPan_no("AbC123");
				pan.setAddress("Mysore");
				
				et.begin();
				em.persist(p);
				em.persist(pan);
				et.commit();
			}else {
				et.begin();
				em.persist(p);
				et.commit();
				System.out.println("No Pan Avaliable");
			}
		}else {
			System.out.println("No Person with Given Id");
		}
	}
}
