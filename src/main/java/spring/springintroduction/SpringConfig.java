package spring.springintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springintroduction.repository.MemberRepository;
import spring.springintroduction.repository.MemoryMemberRepository;
import spring.springintroduction.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean   // 스프링 빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean   // 스프링 빈 등록
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();    // 인터페이스는 new 안됨, 구현체로 생성
    }
}
