package com.example.bftmemberservice.member.repository;

import com.example.bftmemberservice.member.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByEmail(String email);

    Optional<Member> findById(Long memberId);
}
