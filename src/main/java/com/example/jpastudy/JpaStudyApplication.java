package com.example.jpastudy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaStudyApplication {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                .setFirstResult(1) // 페이지네이션
                .setMaxResults(5)
                .getResultList();

        for (Member member : resultList) {
            System.out.println("member = " + member.getName());
        }

        tx.commit();
        em.close();
        emf.close();
    }
}
