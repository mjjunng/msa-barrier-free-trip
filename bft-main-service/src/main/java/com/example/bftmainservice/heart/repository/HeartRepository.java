package com.example.bftmainservice.heart.repository;

import com.example.bftmainservice.heart.domain.Heart;
import com.example.bftmainservice.member.domain.Member;
import com.example.bftmainservice.touristfacility.domain.TouristFacility;

import java.util.Optional;

public interface HeartRepository {
    Heart findByIds(Member member, TouristFacility touristFacility);
    void save(Heart heart);

    int delete(Long hearId);

    Optional<Heart> findByIdsIfLikes(Member member, TouristFacility facility);

}
