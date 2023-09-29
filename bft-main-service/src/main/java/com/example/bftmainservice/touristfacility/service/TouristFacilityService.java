package com.example.bftmainservice.touristfacility.service;

import com.example.bftmainservice.touristfacility.domain.TouristFacility;
import com.example.bftmainservice.touristfacility.dto.TouristFacilityInfoResponseDto;
import com.example.bftmainservice.touristfacility.dto.TouristFacilityListResponseDto;

import java.util.List;

public interface TouristFacilityService {
    public List<TouristFacility> findByCode(String contentTypeId,
                                            String areaCode,
                                            String sigunguCode);

    public List<String> findImgByContentId(String contentId);

    public TouristFacility findByContentId(String contentId);

    List<TouristFacilityListResponseDto> returnListDto(String contentTypeId, String areaCode, String sigunguCode);
    public TouristFacilityInfoResponseDto returnInfoDto(Long memberId, String contentId);

    public List<TouristFacilityListResponseDto> returnNearHotelDto(Double userX, Double userY, int dis);
}
