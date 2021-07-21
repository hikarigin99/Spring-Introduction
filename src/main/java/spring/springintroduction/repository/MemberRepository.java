package spring.springintroduction.repository;

import spring.springintroduction.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);                 // 회원을 저장하고 저장한 회원을 반환
    Optional<Member> findById(Long id);         // ID로 회원을 찾는 기능
    Optional<Member> findByName(String name);   // name으로 회원을 찾는 기능
    List<Member> findAll();                     // 지금까지 저장된 모든 회원리스트을 반환

    // Optional (자바 8에 들어가 있는 기능)
    // 값을 가지올 때 그 값이 null일 수도 있는데 null 값이 반환될 때 Optional로 감싸서 반환하는 방식
    // 요즘 null을 그대로 반환하는 것보다 감싸서 반환하는 방식을 선호
}
