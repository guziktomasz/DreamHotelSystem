package pl.sda.dreamhotelsystem.service.reservations;

import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.dto.reservations.ReservationDto;
import pl.sda.dreamhotelsystem.repository.reservations.ReservationsRepository;
import pl.sda.dreamhotelsystem.repository.rooms.RoomsRepository;
import pl.sda.dreamhotelsystem.repository.users.UsersRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class ReservationsServiceImpl implements ReservationsService{

    private final ReservationsRepository reservationsRepository;

    private final RoomsRepository roomsRepository;

    private final UsersRepository usersRepository;

    public ReservationsServiceImpl(ReservationsRepository reservationsRepository, RoomsRepository roomsRepository, UsersRepository usersRepository) {
        this.reservationsRepository = reservationsRepository;
        this.roomsRepository = roomsRepository;
        this.usersRepository = usersRepository;
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
//reservationDto.getRoomId(),
//reservationDto.getUserId());
                                                        roomsRepository.findById(reservationDto.getRoomId()).get(),
                                                        usersRepository.findById(reservationDto.getUserId()).get());

        reservationsRepository.save(createdReservation);
        return createdReservation;
    }

    @Override
    public Collection<Reservation> getAllReservations() {
        return reservationsRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservation(int id) {
        return reservationsRepository.findById(id);
    }

    @Override
    public Collection<Reservation> getReservationToday(LocalDate today) {
        //today = today.plusDays(1);
        return reservationsRepository.findAllReservationToday(today);
    }

    @Override
    public Optional<Reservation> updateReservation(ReservationDto updatedReservationDto, int id) {
        Optional<Reservation> reservationToUpdate = reservationsRepository.findById(id);
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
                                                        roomsRepository.findById(updatedReservationDto.getRoomId()).get(),
                                                        usersRepository.findById(updatedReservationDto.getUserId()).get());
        reservationsRepository.save(updatedReservation);
        return Optional.of(updatedReservation);
    }

    @Override
    public Optional<Reservation> deleteReservation(int id) {
        Optional<Reservation> reservationToDelete = reservationsRepository.findById(id);
        if (reservationToDelete.isEmpty()){
            return reservationToDelete;
        }
        Reservation deletedReservation = reservationToDelete.get();
        reservationsRepository.delete(deletedReservation);
        return Optional.of(deletedReservation);
    }
}
