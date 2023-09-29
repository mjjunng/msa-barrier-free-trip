package com.example.bftmainservice.rental.service;

import com.example.bftmainservice.MemberServiceClient;
import com.example.bftmainservice.member.domain.Member;
import com.example.bftmainservice.rental.domain.Rental;
import com.example.bftmainservice.rental.domain.RentalHeart;
import com.example.bftmainservice.rental.dto.RentalListDto;
import com.example.bftmainservice.rental.repository.RentalHeartRepository;
import com.example.bftmainservice.rental.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService{
    private final RentalRepository rentalRepository;
    private final MemberServiceClient memberServiceClient;
    private final RentalHeartRepository rentalHeartRepository;

    @Override
    public List<RentalListDto> returnRentalServiceList(Long memberId, String sido, String sigungu) {
        List<Rental> rentals = rentalRepository.findByAreaName(sido, sigungu);
        Optional<Member> member = memberServiceClient.getMember(memberId);
        List<RentalListDto> result = new ArrayList<>();

        if (member.isPresent()) {
            for (Rental r: rentals) {
                RentalListDto dto = new RentalListDto(r.getTitle(), r.getAddr(), r.getTel());
                Optional<RentalHeart> likes = rentalHeartRepository.findByIdsIfLikes(member.get(), r);
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
        Optional<Rental> rental = rentalRepository.findById(contentId);

        if (likes == 1) {  // 찜 추가
            if ((member.isPresent()) && (rental.isPresent())) {
                RentalHeart rentalHeart = new RentalHeart(member.get(), rental.get());
                rentalHeartRepository.save(rentalHeart);
            }

        } else {    // 찜 해제
            if ((member.isPresent()) && (rental.isPresent())) {
                Optional<RentalHeart> rentalHeart = rentalHeartRepository.findByIds(member.get(), rental.get());
                if (rentalHeart.isPresent()) {
                    int cnt = rentalHeartRepository.delete(rentalHeart.get().getId());
                }
            }

        }
    }
}
