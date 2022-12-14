package pl.sda.dreamhotelsystem.dto.reservations;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.domain.Room;
import pl.sda.dreamhotelsystem.domain.UserHotel;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationDto {
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startVisit;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endVisit;

    private int numberOfGuests;

    private boolean breakfast;

    private boolean parking;

    private boolean animal;

    private boolean spa;

    private int roomId;

    private int userId;

//    public ReservationDto(LocalDate startVisit, LocalDate endVisit, int numberOfGuests,
//                          boolean breakfast, boolean parking, boolean animal, boolean spa,
//                          Room room, UserHotel userHotel) {
//        this.startVisit = startVisit;
//        this.endVisit = endVisit;
//        this.numberOfGuests = numberOfGuests;
//        this.breakfast = breakfast;
//        this.parking = parking;
//        this.animal = animal;
//        this.spa = spa;
//        this.roomId = room.getId();
//        this.userId = userHotel.getId();
//    }


    public ReservationDto(LocalDate startVisit, LocalDate endVisit, int numberOfGuests, boolean breakfast, boolean parking, boolean animal, boolean spa, int roomId, int userId) {
        this.startVisit = startVisit;
        this.endVisit = endVisit;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.parking = parking;
        this.animal = animal;
        this.spa = spa;
        this.roomId = roomId;
        this.userId = userId;
    }

    public ReservationDto(Reservation reservation){
        this.startVisit = reservation.getStartVisit();
        this.endVisit = reservation.getEndVisit();
        this.numberOfGuests = reservation.getNumberOfGuests();
        this.breakfast = reservation.isBreakfast();
        this.parking = reservation.isParking();
        this.animal = reservation.isAnimal();
        this.spa = reservation.isSpa();
        this.roomId = reservation.getRoom().getId();
        this.userId = reservation.getUserHotel().getId();
    }

    public LocalDate getStartVisit() {
        return startVisit;
    }

    public LocalDate getEndVisit() {
        return endVisit;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public boolean isParking() {
        return parking;
    }

    public boolean isAnimal() {
        return animal;
    }

    public boolean isSpa() {
        return spa;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "startVisit=" + startVisit +
                ", endVisit=" + endVisit +
                ", numberOfGuests=" + numberOfGuests +
                ", breakfast=" + breakfast +
                ", parking=" + parking +
                ", animal=" + animal +
                ", spa=" + spa +
                ", roomId=" + roomId +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDto that = (ReservationDto) o;
        return numberOfGuests == that.numberOfGuests && breakfast == that.breakfast &&
                parking == that.parking && animal == that.animal && spa == that.spa &&
                roomId == that.roomId && userId == that.userId &&
                Objects.equals(startVisit, that.startVisit) &&
                Objects.equals(endVisit, that.endVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startVisit, endVisit, numberOfGuests, breakfast,
                parking, animal, spa, roomId, userId);
    }
}
