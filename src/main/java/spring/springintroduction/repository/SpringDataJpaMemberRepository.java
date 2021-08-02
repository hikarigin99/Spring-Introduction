package spring.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springintroduction.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL : select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); // 인터페이스 이름만으로 개발 끝
}
