package com.example.bftmainservice.charger.repository;

import com.example.bftmainservice.charger.domain.Charger;
import com.example.bftmainservice.charger.domain.ChargerHeart;
import com.example.bftmainservice.member.domain.Member;

import java.util.Optional;

public interface ChargerHeartRepository {
    public void save(ChargerHeart chargerHeart);
    public int delete(Long heartId);
    public Optional<ChargerHeart> findByIds(Member member, Charger charger);
    public Optional<ChargerHeart> findByIdsIfLikes(Member member, Charger charger);
}
