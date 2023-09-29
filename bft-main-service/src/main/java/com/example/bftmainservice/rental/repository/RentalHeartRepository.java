package com.example.bftmainservice.rental.repository;

import com.example.bftmainservice.charger.domain.Charger;
import com.example.bftmainservice.charger.domain.ChargerHeart;
import com.example.bftmainservice.member.domain.Member;
import com.example.bftmainservice.rental.domain.Rental;
import com.example.bftmainservice.rental.domain.RentalHeart;

import java.util.Optional;

public interface RentalHeartRepository {
    public void save(RentalHeart rentalHeart);
    public int delete(Long heartId);
    public Optional<RentalHeart> findByIds(Member member, Rental rental);
    public Optional<RentalHeart> findByIdsIfLikes(Member member, Rental rental);
}
