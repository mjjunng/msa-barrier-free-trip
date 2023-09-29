package com.example.bftmemberservice.member.service;

import com.example.bftmemberservice.member.domain.Member;
import com.example.bftmemberservice.member.dto.MemberResponseDto;
import com.example.bftmemberservice.member.dto.SocialMemberDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Optional;

public interface OauthMemberService {
    public MemberResponseDto oauthLogin(String code, String type) throws JsonProcessingException;
    public String getAccessToken(String code) throws JsonProcessingException;
    public SocialMemberDto getOauthMemberInfo(String accessToken) throws JsonProcessingException;
    public Member registerOauthMemberIfNeed(SocialMemberDto kakaoMemberDto);

    Optional<Member> findById(Long memberId);
}
