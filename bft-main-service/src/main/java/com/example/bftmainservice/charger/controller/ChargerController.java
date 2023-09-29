package com.example.bftmainservice.charger.controller;


import com.example.bftmainservice.charger.dto.ChargerInfoDto;
import com.example.bftmainservice.charger.dto.ChargerListDto;
import com.example.bftmainservice.charger.service.ChargerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChargerController {
    private final ChargerService chargerService;

    @GetMapping("/chargers/{memberId}/{areaCode}")
    public ResponseEntity returnChargerList(@PathVariable("memberId") Long memberId,
                                            @PathVariable("areaCode") String areaCode) {

        List<ChargerListDto> result = chargerService.returnListDto(memberId, areaCode);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/chargers/info/{memberId}/{contentId}")
    public ResponseEntity returnChargerInfo(@PathVariable("memberId") Long memberId,
                                            @PathVariable("contentId") Long contentId) {
        ChargerInfoDto result = chargerService.returnChargerInfo(memberId, contentId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/near-chargers/{userX}/{userY}")
    public ResponseEntity returnNearChargers(@PathVariable("userX") double userX,
                                             @PathVariable("userY") double userY) {
        List<ChargerListDto> result = chargerService.returnNearChargerDto(userX, userY, 3);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
