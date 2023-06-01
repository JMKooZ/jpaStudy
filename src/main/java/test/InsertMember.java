package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class InsertMember {
    public static void main(String[] args) {
        // EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // EntityManager 생성
        EntityManager em = emf.createEntityManager();
        // EntityTransaction 생성
        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
            // entity 생성
//            Member member = new Member(1, "홍길동",10000);
            Member findMember = em.find(Member.class,1);
            System.out.println("member: "+findMember);
            System.out.println("findMember.getId() = " + findMember.getId());
            findMember.setName("홍길순");
            // entity 영속화
            em.persist(findMember);
            // 커밋 후 insert 쿼리문 전송
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            // entityManager 사용하고 꼭 닫아줘야함.
            em.close();
        }
        emf.close();
    }
}