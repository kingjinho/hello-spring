package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    private MemoryMemberRepository memberRepository;
    private MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("spring");

        Long savedId = memberService.join(member);


        Member one = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(one.getName());
    }

    @Test
    void 회원가입_중복_예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);

    }

    @Test
    void 모든유저검색() {

    }

    @Test
    void 유저검색() {

    }
}