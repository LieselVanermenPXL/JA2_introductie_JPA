package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo3Update {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			TypedQuery<Contact> query = entityManager.createQuery("SELECT c FROM Contact c WHERE c.name = :name", Contact.class);  // = geen SQL query maar de eigen query language van Hibernate,
			// bvb 'c' betekent contact selecteren, velden hoeven niet gespecifieerd te worden
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			query.setParameter("name", "Sophie"); // parameters worden aangegeven met ervoor :
			Contact result = query.getSingleResult();
			System.out.println(result);
			result.setPhone(999000);
			tx.commit();
		}
		finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}
}
