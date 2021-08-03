package spring.springintroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springintroduction.aop.TimeTraceAop;
import spring.springintroduction.repository.*;
import spring.springintroduction.service.MemberService;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    //@PersistenceContext 스프링이 알아서 DI 해줌으로 필요 없음
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) { // Injection 받기
        this.memberRepository = memberRepository;
    }


    @Bean   // 스프링 빈 등록
    public MemberService memberService() {
        return new MemberService(memberRepository);
    } // 의존 관계 셋팅

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean   // 스프링 빈 등록
//    public MemberRepository memberRepository() {
//        //return new MemoryMemberRepository();    // 인터페이스는 new 안됨, 구현체로 생성
//        //return new JdbcMemberRepository(dataSource);    // 다형성 사용
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JpaMemberRepository(em);
//    }
}
