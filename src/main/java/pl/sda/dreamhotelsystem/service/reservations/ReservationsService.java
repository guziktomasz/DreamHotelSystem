package pl.sda.dreamhotelsystem.service.reservations;

import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.dto.reservations.ReservationDto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface ReservationsService {

    Reservation createReservation(ReservationDto reservationDto);

    Collection<Reservation> getAllReservations();

    Optional<Reservation> getReservation(int id);

   Collection<Reservation> getReservationToday (LocalDate today);

    Optional<Reservation> updateReservation(ReservationDto reservationDto, int id);

    Optional<Reservation> deleteReservation(int id);
}
