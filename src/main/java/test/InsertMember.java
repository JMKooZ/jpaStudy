package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;
import test.Dto.RoleType;

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
            Member member1 = new Member();
            member1.setUserId("A");
            member1.setUserName("홍길동");
            member1.setMoney(0);
            member1.setRoleType(RoleType.ADMIN);
            Member member2 = new Member();
            member2.setUserId("B");
            member2.setUserName("홍길순");
            member2.setMoney(0);
            member2.setRoleType(RoleType.USER);
            // entity 영속화
            em.persist(member1);
            em.persist(member2);
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