package com.example.bftmainservice.rental.repository;

import com.example.bftmainservice.member.domain.Member;
import com.example.bftmainservice.rental.domain.Rental;
import com.example.bftmainservice.rental.domain.RentalHeart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class RentalHeartRepositoryImpl implements RentalHeartRepository {
    private final EntityManager em;

    @Override
    public void save(RentalHeart rentalHeart) {
        em.persist(rentalHeart);
    }

    @Override
    public int delete(Long heartId) {
        int cnt = em.createQuery("delete from RentalHeart rh where rh.id=:ids")
                .setParameter("ids", heartId)
                .executeUpdate();
        em.clear();
        return cnt;
    }

    @Override
    public Optional<RentalHeart> findByIds(Member member, Rental rental) {
        List<RentalHeart> rentalHearts = em.createQuery("select rh from RentalHeart rh " +
                        "where rh.member=:members and rh.rental=:rentals")
                .setParameter("members", member)
                .setParameter("rentals", rental)
                .getResultList();

        return rentalHearts.stream().findAny();
    }

    @Override
    public Optional<RentalHeart> findByIdsIfLikes(Member member, Rental rental) {
        List <RentalHeart> rentalHearts = em.createQuery("select rh from RentalHeart rh " +
                        "where rh.member=:members and rh.rental=:rentals")
                .setParameter("members", member)
                .setParameter("rentals", rental)
                .getResultList();

        return rentalHearts.stream().findAny();
    }
}
