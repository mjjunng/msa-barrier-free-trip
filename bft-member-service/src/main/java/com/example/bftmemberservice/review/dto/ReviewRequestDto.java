package com.example.bftmemberservice.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {
    private double rating;
    private String content;
}
