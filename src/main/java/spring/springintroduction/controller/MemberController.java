package spring.springintroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.springintroduction.domain.Member;
import spring.springintroduction.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //DI : Dependency Injection, Service와 연결, 의존 관계 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }


}
