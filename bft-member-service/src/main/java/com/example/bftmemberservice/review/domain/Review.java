package com.example.bftmemberservice.review.domain;

import com.example.bftmemberservice.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private BarrierFreeFacility facility;

    private double rating;
    private String content;

    public Review(Member member, BarrierFreeFacility facility, double rating, String content) {
        this.member = member;
        this.facility = facility;
        this.rating = rating;
        this.content = content;
    }
}
