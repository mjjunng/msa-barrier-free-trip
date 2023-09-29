package com.example.bftmemberservice.review.repository;

import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import com.example.bftmemberservice.review.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository{
    private final EntityManager em;
    @Override
    @Transactional
    public void save(Review review) {
        em.persist(review);
    }

    @Override
    public List<Review> findByContentId(BarrierFreeFacility facility) {
        return em.createQuery("select r.content from Review r where r.facility=:facilities")
                .setParameter("facilities", facility)
                .getResultList();
    }
}
