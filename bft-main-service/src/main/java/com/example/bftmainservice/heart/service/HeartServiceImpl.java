package com.example.bftmainservice.heart.service;

import com.example.bftmainservice.member.domain.Member;
import com.example.bftmainservice.MemberServiceClient;
import com.example.bftmainservice.heart.domain.Heart;
import com.example.bftmainservice.heart.repository.HeartRepository;
import com.example.bftmainservice.touristfacility.domain.TouristFacility;
import com.example.bftmainservice.touristfacility.service.TouristFacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService{

    private final TouristFacilityService facilityService;
    private final HeartRepository heartRepository;
    private final MemberServiceClient memberServiceClient;



    public void likes(Long memberId, String contentId, int likes) {
        Optional<Member> member = memberServiceClient.getMember(memberId);
        TouristFacility facility = facilityService.findByContentId(contentId);

        if (likes == 1) {  // 찜 추가
            if (member.isPresent()) {
                Heart heart = new Heart(member.get(), facility);
                heartRepository.save(heart);
            }

        } else {    // 찜 해제
            if (member.isPresent()) {
                Heart prev = heartRepository.findByIds(member.get(), facility);
                heartRepository.delete(prev.getId());
            }

        }
    }
}
