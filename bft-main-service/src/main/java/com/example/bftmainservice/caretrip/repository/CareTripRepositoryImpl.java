package com.example.bftmainservice.caretrip.repository;

import com.example.bftmainservice.caretrip.domain.CareTrip;
import com.example.bftmainservice.caretrip.domain.CareTripHeart;
import com.example.bftmainservice.charger.domain.Charger;
import com.example.bftmainservice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CareTripRepositoryImpl implements CareTripRepository{
    private final EntityManager em;
    @Override
    public List<CareTrip> findAll() {
        return em.createQuery("select ct from CareTrip ct")
                .getResultList();
    }

    @Override
    public Optional<CareTrip> findById(Long id) {
        List <CareTrip> careTrips = em.createQuery("select ct from CareTrip ct where ct.id=:ids")
                .setParameter("ids", id)
                .getResultList();

        return careTrips.stream().findAny();
    }

    @Override
    public List<CareTrip> findByAreaName(String sido, String sigungu) {
        return em.createQuery("select ct from CareTrip ct where ct.sido=:sidos and ct.sigungu=:sigungus")
                .setParameter("sidos", sido)
                .setParameter("sigungus", sigungu)
                .getResultList();
    }

    @Override
    public Optional<CareTrip> findByTitle(String keyword) {
        List<CareTrip> careTrips = em.createQuery("select ct from CareTrip ct " +
                        "where ct.title like concat('%',:keywords,'%') ")
                .setParameter("keywords", keyword)
                .getResultList();

        return careTrips.stream().findAny();
    }
}
