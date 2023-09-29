package com.example.bftmainservice.caretrip.repository;


import com.example.bftmainservice.caretrip.domain.CareTrip;

import java.util.List;
import java.util.Optional;

public interface CareTripRepository {
    public List<CareTrip> findAll();

    public Optional<CareTrip> findById(Long id);

    public List<CareTrip> findByAreaName(String sido, String sigungu);
    public Optional<CareTrip> findByTitle(String keyword);

}
