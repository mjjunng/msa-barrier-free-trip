package com.example.bftmemberservice.review.controller;

import com.example.bftmemberservice.MainServiceClient;
import com.example.bftmemberservice.member.domain.Member;
import com.example.bftmemberservice.member.service.OauthMemberService;
import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import com.example.bftmemberservice.review.domain.Review;
import com.example.bftmemberservice.review.dto.ReviewRequestDto;
import com.example.bftmemberservice.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final OauthMemberService memberService;
    private final MainServiceClient mainServiceClient;
    private final ReviewService reviewService;

    @PostMapping("/review/{memberId}/{contentId}")
    public ResponseEntity writeReview(@PathVariable("memberId") Long memberId,
                                      @PathVariable("contentId") String contentId,
                                      @RequestBody ReviewRequestDto requestData) {
        String result = "fail";
        Optional<Member> member = memberService.findById(memberId);
        if (member.isPresent()) {
            BarrierFreeFacility facility = mainServiceClient.returnFacility(contentId);
            reviewService.createReview(member.get(), facility, requestData.getRating(), requestData.getContent());
            result = "success";
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/review/{contentId}")
    public ResponseEntity getReview(@PathVariable("contentId") String contentId) {
        BarrierFreeFacility facility = mainServiceClient.returnFacility(contentId);
        List<Review> result = reviewService.findByContentId(facility);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
