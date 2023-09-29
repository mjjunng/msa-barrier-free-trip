package com.example.bftmainservice.charger.repository;

import com.example.bftmainservice.charger.domain.Charger;
import com.example.bftmainservice.touristfacility.domain.TouristFacility;

import java.util.List;
import java.util.Optional;

public interface ChargerRepository {
    public List<Charger> findByAreaCode(String areaCode);
    public Optional<Charger> findById(Long id);
    public Optional<Charger> findByTitle(String keyword);
    public List<Charger> findNearChargersByPos(Double userX, Double userY, double dis);
}
