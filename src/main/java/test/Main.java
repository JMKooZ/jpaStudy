package test;

import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        // EntityManager 생성
        EntityManager em = emf.createEntityManager();
        // EntityTransaction 생성
        EntityTransaction ex = em.getTransaction();
        ex.begin();

        try {
            // entity 생성
            Member member = new Member(1, "사쿠라");
            // entity 영속화
            em.persist(member);
            // 커밋 후 insert 쿼리문 전송
            ex.commit();
        } catch (Exception e) {
            e.printStackTrace();
            ex.rollback();
        } finally {
            em.close();
        }
    }
}
