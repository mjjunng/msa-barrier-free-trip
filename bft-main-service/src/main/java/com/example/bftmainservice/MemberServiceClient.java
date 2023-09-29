package com.example.bftmainservice;

import com.example.bftmainservice.member.domain.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "bft-member-service")
public interface MemberServiceClient {
    @GetMapping("/member/{id}")
    Optional<Member> getMember(@PathVariable("id") Long id);

}
