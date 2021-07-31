package spring.springintroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springintroduction.repository.JdbcMemberRepository;
import spring.springintroduction.repository.JdbcTemplateMemberRepository;
import spring.springintroduction.repository.MemberRepository;
import spring.springintroduction.repository.MemoryMemberRepository;
import spring.springintroduction.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean   // 스프링 빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean   // 스프링 빈 등록
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();    // 인터페이스는 new 안됨, 구현체로 생성
        //return new JdbcMemberRepository(dataSource);    // 다형성 사용
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
