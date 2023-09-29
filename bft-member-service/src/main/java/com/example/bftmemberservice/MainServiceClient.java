package com.example.bftmemberservice;

import com.example.bftmemberservice.review.domain.BarrierFreeFacility;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bft-main-service")
public interface MainServiceClient {
    @GetMapping("/touristFacility/{contentId}")
    BarrierFreeFacility returnFacility(@PathVariable("contentId") String contentId);
}
