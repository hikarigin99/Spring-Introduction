package spring.springintroduction.repository;

import spring.springintroduction.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;  // build.gradle에서 data-jpa 라이브러리를 받으면 스프링 부트가 알아서 EntityManager 을 생성한다.

    public JpaMemberRepository(EntityManager em) { //스프링부트가 알아서 생성한 EntityManager을 인젝션하면 됨. (EntityManager을 주입받아야함)
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);  //persist는 리턴값이 없음, insert quary와 identity id값을 알아서 만들어줌.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {  // PK
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {  // PK가 아닌 값으로 find할 때는 Query 작성 필요 : JPQL
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny(); // Optional type으로 리턴하기 위해해
    }
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // jpql : 테이블 대상이 아니라 객체 대상으로 sql 쿼리를 보냄
                .getResultList();
    }
}
