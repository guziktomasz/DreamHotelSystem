package pl.sda.dreamhotelsystem.repository.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.dreamhotelsystem.domain.Reservation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {

    @Override
    Optional<Reservation> findById(Integer integer);

    @Query("SELECT r FROM Reservation r WHERE (r.startVisit <= ?1 AND ?1 <= r.endVisit)")
   Collection<Reservation> findAllReservationToday(LocalDate today);
}
