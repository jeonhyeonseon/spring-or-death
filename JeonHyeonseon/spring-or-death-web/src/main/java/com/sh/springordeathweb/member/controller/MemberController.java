package com.sh.springordeathweb.member.controller;

import com.sh.springordeathweb.member.model.dto.MemberDto;
import com.sh.springordeathweb.member.model.dto.MemberRegistDto;
import com.sh.springordeathweb.member.model.service.MemberCommandService;
import com.sh.springordeathweb.member.model.service.MemberQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("/regist")
    public void regist(Model model) {
        log.info("GET /member/regist");
    }

    @PostMapping("/checkEmail")
    @ResponseBody
    public int checkDuplicateEmail(@RequestParam("memberEmail") String memberEmail) {
        log.info("POST /member/checkEmail");
        log.debug("memberEmail = {}", memberEmail);
        int result = memberQueryService.checkDuplicateEmail(memberEmail);
        return result; // 중복되지 않으면 0, 중복되면 1
    }

    @PostMapping("/regist")
//    @ResponseBody // 이 핸들러의 반환객체를 직접 http 응답 메시지 본문(body)에 작성
    public String regist(
            @ModelAttribute MemberRegistDto memberRegistDto){
        log.info("POST /member/regist");
        log.debug("memberDto = {}", memberRegistDto);
        MemberDto memberDto = memberRegistDto.toMemeberDto();
        int result = memberCommandService.insertMember(memberDto);
//        return "%s님, 회원가입에 성공하셨습니다".formatted(memberDto.getMemberName());
        return "redirect:/";
    }
}
