package spring.springintroduction.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.springintroduction.domain.Member;
import spring.springintroduction.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    //MemberService memberService = new MemberService();
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // MemoryMemberRepository에서 사용하는 인스턴스와 테스트에서 사용하는 인스턴스가 다름
    // 다른 인스턴스를 사용하고 있어 같은 인스턴스를 사용하도록 MemoryMemberRepository 수정

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach  // 각 테스트를 실행하기 전에 실행됨
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach  // 메서드 실행이 끝날 때마다 동작하도록 하는 어노테이션(calling methods)
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");  //spring이면 오류 발생

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /* try-catch 쓰는게 애매함
        try {
            memberService.join(member2);
            fail(); // 예외가 발생해해야 합니다.
       } catch (IllegalStateException e) {
            // 예외 발생 성공
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}