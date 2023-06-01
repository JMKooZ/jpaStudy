package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class UpdateMember {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            // update 경우 변경할 객체를 먼저 찾아와서 알맞게 변경해주면됌.
            // 따로 em.persist(member1) 영속성을 부여할 필요가 없음.
            Member member1 = em.find(Member.class, 1);
            Member member2 = em.find(Member.class, 2);
            //dto 에 deposit / withdraw 메서드 만들어둠
            member1.deposit(30000);
            member2.withdraw(30000);
            // 커밋이 진행될때 sql이 db에 전송된다(flush)
            et.commit();
        }catch (Exception e){
            et.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

}
