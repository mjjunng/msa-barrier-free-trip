package com.example.bftmemberservice.member.controller;

import com.example.bftmemberservice.member.domain.Member;
import com.example.bftmemberservice.member.dto.MemberResponseDto;
import com.example.bftmemberservice.member.service.OauthMemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final OauthMemberService oauthMemberService;

    @GetMapping("/welcome")
    public String healthCheck() {
        return "welcome";
    }


    @GetMapping("/oauth/kakao")
    public ResponseEntity kakaoLoin(@RequestParam("code") String code)
                                        throws JsonProcessingException {
//        log.info("k-code: " + code);
        MemberResponseDto memberResponseDto = oauthMemberService.oauthLogin(code, "kakao");
        return ResponseEntity.status(HttpStatus.OK).body(memberResponseDto);
    }

    @GetMapping("/oauth/naver")
    public ResponseEntity naverLoin(@RequestParam("code") String code)
            throws JsonProcessingException {
        MemberResponseDto memberResponseDto = oauthMemberService.oauthLogin(code, "naver");
        return ResponseEntity.status(HttpStatus.OK).body(memberResponseDto);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity getMember(@PathVariable("id") Long id) {
        Optional<Member> member = oauthMemberService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

}
