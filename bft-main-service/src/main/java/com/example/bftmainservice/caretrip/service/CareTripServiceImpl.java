package com.example.bftmainservice.caretrip.service;

import com.example.bftmainservice.MemberServiceClient;
import com.example.bftmainservice.caretrip.domain.CareTrip;
import com.example.bftmainservice.caretrip.domain.CareTripHeart;
import com.example.bftmainservice.caretrip.dto.CareTripListResponseDto;
import com.example.bftmainservice.caretrip.repository.CareTripHeartRepository;
import com.example.bftmainservice.caretrip.repository.CareTripRepository;
import com.example.bftmainservice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CareTripServiceImpl implements CareTripService{
    private final CareTripRepository careTripRepository;
    private final MemberServiceClient memberServiceClient;
    private final CareTripHeartRepository careTripHeartRepository;

    public List<CareTripListResponseDto> returnListDto(Long memberId, String sido, String sigungu) {
        List<CareTrip> careTrips = careTripRepository.findByAreaName(sido, sigungu);
        List<CareTripListResponseDto> result = new ArrayList<>();
        Optional<Member> member = memberServiceClient.getMember(memberId);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        if (member.isPresent()) {
            for (CareTrip c: careTrips) {
                CareTripListResponseDto dto = modelMapper.map(c, CareTripListResponseDto.class);
                Optional<CareTripHeart> likes = careTripHeartRepository.findByIdsIfLikes(member.get(), c);
                if (likes.isPresent()) {
                    dto.setLike(1);
                } else {
                    dto.setLike(0);
                }
                result.add(dto);
            }
        }
        return result;

    }

    public void likes(Long memberId, Long contentId, int likes) {
        Optional<Member> member = memberServiceClient.getMember(memberId);
        Optional<CareTrip> careTrip = careTripRepository.findById(contentId);

        if (likes == 1) {  // 찜 추가
            if ((member.isPresent()) && (careTrip.isPresent())) {
                CareTripHeart careTripHeart = new CareTripHeart(member.get(), careTrip.get());
                careTripHeartRepository.save(careTripHeart);
            }

        } else {    // 찜 해제
            if ((member.isPresent()) && (careTrip.isPresent())) {
                Optional<CareTripHeart> careTripHeart = careTripHeartRepository.findByIds(member.get(), careTrip.get());
                if (careTripHeart.isPresent()) {
                    int cnt = careTripHeartRepository.delete(careTripHeart.get().getId());
                }
            }

        }
    }
}
