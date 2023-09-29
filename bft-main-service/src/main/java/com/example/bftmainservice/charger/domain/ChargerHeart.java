package com.example.bftmainservice.charger.domain;

import com.example.bftmainservice.member.domain.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "charger_heart")
@Data
@NoArgsConstructor
public class ChargerHeart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "chargerId")
    private Charger charger;

    public ChargerHeart(Member member, Charger charger) {
        this.member = member;
        this.charger = charger;
    }
}
