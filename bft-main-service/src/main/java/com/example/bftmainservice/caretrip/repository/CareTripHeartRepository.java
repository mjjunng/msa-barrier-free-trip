package com.example.bftmainservice.caretrip.repository;

import com.example.bftmainservice.caretrip.domain.CareTrip;
import com.example.bftmainservice.caretrip.domain.CareTripHeart;
import com.example.bftmainservice.member.domain.Member;

import java.util.Optional;

public interface CareTripHeartRepository {
    public void save(CareTripHeart careTripHeart);
    public int delete(Long heartId);
    public Optional<CareTripHeart> findByIds(Member member, CareTrip careTrip);

    Optional<CareTripHeart> findByIdsIfLikes(Member member, CareTrip careTrip);
}
