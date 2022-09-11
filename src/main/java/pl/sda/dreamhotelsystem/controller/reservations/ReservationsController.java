package pl.sda.dreamhotelsystem.controller.reservations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.dto.reservations.ReservationDto;
import pl.sda.dreamhotelsystem.service.reservations.ReservationsService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService){
        System.out.println("ReservationController " + reservationsService);
        this.reservationsService = reservationsService;
    }

    // Create

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody @Valid ReservationDto reservationDto){
        return reservationsService.createReservation(reservationDto);
    }

    // Read

    @GetMapping
    public Collection<Reservation> getAllReservations(){
        return reservationsService.getAllReservations();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable int id){
        return reservationsService.getReservation(id).map(reservation ->
                new ResponseEntity<>(reservation, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping(path = "/{today}")
//    public ResponseEntity<Reservation> getReservationToday(@PathVariable LocalDate today){
//        return reservationsService.getReservationToday(today).map(reservation ->
//                        new ResponseEntity<>(reservation, HttpStatus.OK)).
//                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    // Update

    @PutMapping(path = "/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody @Valid ReservationDto updateReservationDto,
                                                         @PathVariable int id){
        Optional<Reservation> updatedReservation = reservationsService.updateReservation(updateReservationDto, id);
        if (updatedReservation.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedReservation.get(), HttpStatus.OK);
    }

    // Delete

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable int id){
        Optional<Reservation> deletedReservation = reservationsService.deleteReservation(id);
        if (deletedReservation.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedReservation.get(), HttpStatus.OK);
    }
}
