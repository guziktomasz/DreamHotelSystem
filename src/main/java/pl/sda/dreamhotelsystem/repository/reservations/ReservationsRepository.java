package pl.sda.dreamhotelsystem.repository.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.dreamhotelsystem.domain.Reservation;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {

    @Override
    Optional<Reservation> findById(Integer integer);

   //Optional<Reservation> findByStartVisitBefore(LocalDate today);
}
