package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import test.Dto.Member;

public class Example {

    public static void main(String[] args) {
        //        영속상태와 비영속 준영속 상태의 예시
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        try {
            // 영속을 하기 전 상태는 비영속 상태 ( 갹체를 생성만 해둔 상태 )
            Member member = em.find(Member.class, 1);
            // 영속 상태(em.persist())
            em.persist(member);
            // 만약 여기서 flush 를 하면 flush 기준 위쪽 라인의 쓰기지연 SQL 저장소 에 저장되어있던 sql문을 db에 전송(실행)
            em.flush();
            // 준영속 상태 (영속성 컨텍스트에서의 분리,제거,닫음)
            em.detach(member);
            Member member1 = em.find(Member.class, 1);
            em.persist(member1);
            // flush 가 위에서 진행되면 아래에 있는 영속성에 대해서만 쓰기지연 SQL 저장소 에 저장되어있던 sql문을 db에 전송 없으면 실행 안함.
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
