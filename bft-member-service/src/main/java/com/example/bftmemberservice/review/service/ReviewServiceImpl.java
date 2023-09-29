package com.example.bftmemberservice.review.service;

import com.example.bftmemberservice.member.domain.Member;
import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import com.example.bftmemberservice.review.domain.Review;
import com.example.bftmemberservice.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    @Override
    public void createReview(Member member, BarrierFreeFacility facility,
                             double rating, String content) {
        Review review = new Review(member, facility, rating, content);
        reviewRepository.save(review);

    }

    @Override
    public List<Review> findByContentId(BarrierFreeFacility facility) {
        return reviewRepository.findByContentId(facility);
    }
}
