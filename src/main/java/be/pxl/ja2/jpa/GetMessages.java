package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.*;
import java.util.List;

public class GetMessages {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
            entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<Message> findAllQuery = entityManager.createQuery("select m from Message m", Message.class);
            List<Message> resultList = findAllQuery.getResultList();
            for (Message m : resultList) {
                System.out.println(m.getId() + " " + m.getText());
            }
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
