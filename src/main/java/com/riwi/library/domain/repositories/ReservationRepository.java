package com.riwi.library.domain.repositories;

import com.riwi.library.domain.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Long countByBookIdAndReservationDate(Long bookId, LocalDate reservationDate);

    List<Reservation> findAllByUser_Id(Long userId);

    List<Reservation> findAllByBook_Id(Long bookId);
}
