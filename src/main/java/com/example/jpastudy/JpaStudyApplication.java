package com.example.jpastudy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaStudyApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member findMember = em.find(Member.class, 2L);
        findMember.setName("tony"); // 가능한 이유: jpa에서 엔티티를 관리

        tx.commit();

        em.close();
        emf.close();
    }

}
