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

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            MemberNew member = new MemberNew();
            member.setUsername("admin");
            member.setTeam(team);
            em.persist(member);

            em.flush(); // db에 변경사항을 즉시 반영해야 할때.
            em.clear(); // 영속성 컨텍스트에 남아 있는 데이터가 불필요한 경우

            MemberNew findMember = em.find(MemberNew.class, member.getId());

            List<MemberNew> members = findMember.getTeam().getMembers();

            for (MemberNew memberNew : members) {
                System.out.println("memberNew = " + memberNew.getUsername());
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
