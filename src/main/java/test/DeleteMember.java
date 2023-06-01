package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class DeleteMember {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Member findMember = em.find(Member.class, 1);
            // remove(object) 는 sql delete 하는 메서드
            em.remove(findMember);
            et.commit();
        }catch (Exception e){
            et.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
