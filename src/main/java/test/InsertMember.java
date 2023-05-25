package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class InsertMember {
    public static void main(String[] args) {
        // EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        // EntityManager 생성
        EntityManager em = emf.createEntityManager();
        // EntityTransaction 생성
        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            // entity 생성
            Member member = new Member(1, "사쿠라",10000);
            // entity 영속화
            em.persist(member);
            // 커밋 후 insert 쿼리문 전송
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        } finally {
            em.close();
        }
    }
}
