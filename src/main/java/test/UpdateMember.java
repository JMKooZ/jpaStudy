package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class UpdateMember {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Member member1 = new Member(1,"정민규",10000);
            Member member2 = new Member(2,"이정현",30000);
            em.persist(member1);
            em.persist(member2);

            member1.deposit(30000);
            member2.withdraw(30000);

            et.commit();
        }catch (Exception e){
            e.printStackTrace();
            et.rollback();
        }finally {
            em.close();
        }
    }

}
