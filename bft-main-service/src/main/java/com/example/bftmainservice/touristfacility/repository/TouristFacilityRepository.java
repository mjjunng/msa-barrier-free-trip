package com.example.bftmainservice.touristfacility.repository;

import com.example.bftmainservice.touristfacility.domain.TouristFacility;

import java.util.List;
import java.util.Optional;

public interface TouristFacilityRepository {
    public List<TouristFacility> findByCode(String contentTypeId,
                                            String areaCode,
                                            String sigunguCode);
    public List<String> findImgByContentId(String contentId);

    public TouristFacility findByContentId(String contentId);
    public Optional<TouristFacility> findByTitle(String keyword);

    public List<TouristFacility> findNearHotelsByPos(Double userX, Double userY, double dis);

}
