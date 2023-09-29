package com.example.bftmemberservice.review.service;

import com.example.bftmemberservice.member.domain.Member;
import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import com.example.bftmemberservice.review.domain.Review;

import java.util.List;

public interface ReviewService {
    public void createReview(Member member, BarrierFreeFacility facility,
                             double rating, String content);
    public List<Review> findByContentId(BarrierFreeFacility facility);
}
