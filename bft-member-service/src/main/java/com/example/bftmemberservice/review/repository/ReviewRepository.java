package com.example.bftmemberservice.review.repository;

import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import com.example.bftmemberservice.review.domain.Review;

import java.util.List;

public interface ReviewRepository {
    public void save(Review review);
    public List<Review> findByContentId(BarrierFreeFacility facility);
}
