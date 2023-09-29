package com.example.bftmainservice.charger.service;

import com.example.bftmainservice.charger.dto.ChargerInfoDto;
import com.example.bftmainservice.charger.dto.ChargerListDto;

import java.util.List;

public interface ChargerService {
    public List<ChargerListDto> returnListDto(Long memberId, String areaCode);
    public void likes(Long memberId, Long contentId, int likes);

    public ChargerInfoDto returnChargerInfo(Long memberId, Long contentId);
    public List<ChargerListDto> returnNearChargerDto(Double userX, Double userY, int dis);
}
