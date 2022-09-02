package pl.sda.dreamhotelsystem.service.reservations;

import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.dto.reservations.ReservationDto;
import pl.sda.dreamhotelsystem.repository.reservations.ReservationsRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class ReservationsServiceImpl implements ReservationsService{

    private final ReservationsRepository repository;

    public ReservationsServiceImpl(ReservationsRepository repository){
        this.repository = repository;
    }

    @Override
    public Reservation createReservation(ReservationDto reservationDto) {
        Reservation createdReservation = new Reservation(reservationDto.getStartVisit(),
                                                        reservationDto.getEndVisit(),
                                                        reservationDto.getNumberOfGuests(),
                                                        reservationDto.isBreakfast(),
                                                        reservationDto.isParking(),
                                                        reservationDto.isAnimal(),
                                                        reservationDto.isSpa(),
                                                        reservationDto.getRoomId(),
                                                        reservationDto.getUserId());
        repository.save(createdReservation);
        return createdReservation;
    }

    @Override
    public Collection<Reservation> getAllReservations() {
        return repository.findAll();
    }

    @Override
    public Optional<Reservation> getReservation(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Reservation> updateReservation(ReservationDto updatedReservationDto, int id) {
        Optional<Reservation> reservationToUpdate = repository.findById(id);
        if (reservationToUpdate.isEmpty()){
            return reservationToUpdate;
        }
        Reservation foundReservation = reservationToUpdate.get();
        Reservation updatedReservation = new Reservation(foundReservation.getId(),
                                                        updatedReservationDto.getStartVisit(),
                                                        updatedReservationDto.getEndVisit(),
                                                        updatedReservationDto.getNumberOfGuests(),
                                                        updatedReservationDto.isBreakfast(),
                                                        updatedReservationDto.isParking(),
                                                        updatedReservationDto.isAnimal(),
                                                        updatedReservationDto.isSpa(),
                                                        updatedReservationDto.getRoomId(),
                                                        updatedReservationDto.getUserId());
        repository.save(updatedReservation);
        return Optional.of(updatedReservation);
    }

    @Override
    public Optional<Reservation> deleteReservation(int id) {
        Optional<Reservation> reservationToDelete = repository.findById(id);
        if (reservationToDelete.isEmpty()){
            return reservationToDelete;
        }
        Reservation deletedReservation = reservationToDelete.get();
        repository.delete(deletedReservation);
        return Optional.of(deletedReservation);
    }
}
