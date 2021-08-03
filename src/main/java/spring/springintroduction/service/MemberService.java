package spring.springintroduction.service;

import org.springframework.transaction.annotation.Transactional;
import spring.springintroduction.domain.Member;
import spring.springintroduction.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) { //Dependency Injection (DI), 생성자 주입
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // null이 아니라 값이 있으면 동작을 한다. result가 Optional 타입이기 때문에 가능
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
