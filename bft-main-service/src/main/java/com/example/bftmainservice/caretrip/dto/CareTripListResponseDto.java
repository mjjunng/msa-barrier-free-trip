package com.example.bftmainservice.caretrip.dto;

import lombok.Data;

@Data
public class CareTripListResponseDto {
    private String title;
    private String addr;
    private String tel;
    int like;
}
