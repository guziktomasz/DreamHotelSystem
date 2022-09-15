package pl.sda.dreamhotelsystem.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate startVisit;

    private LocalDate endVisit;

    private int numberOfGuests;

    private boolean breakfast;

    private boolean parking;

    private boolean animal;

    private boolean spa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roomId")
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserHotel userHotel;

    public Reservation(){

    }

    public Reservation(LocalDate startVisit, LocalDate endVisit, int numberOfGuests, boolean breakfast, boolean parking, boolean animal, boolean spa, Room room, UserHotel userHotel) {
        this.startVisit = startVisit;
        this.endVisit = endVisit;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.parking = parking;
        this.animal = animal;
        this.spa = spa;
        this.room = room;
        this.userHotel = userHotel;
    }

    public Reservation(int id, LocalDate startVisit, LocalDate endVisit, int numberOfGuests, boolean breakfast, boolean parking, boolean animal, boolean spa, Room room, UserHotel userHotel) {
        this.id = id;
        this.startVisit = startVisit;
        this.endVisit = endVisit;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.parking = parking;
        this.animal = animal;
        this.spa = spa;
        this.room = room;
        this.userHotel = userHotel;
    }

    public int getId() {
        return id;
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

    public Room getRoom() {
        return room;
    }

    public UserHotel getUserHotel() {
        return userHotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && numberOfGuests == that.numberOfGuests && breakfast == that.breakfast && parking == that.parking && animal == that.animal && spa == that.spa && Objects.equals(startVisit, that.startVisit) && Objects.equals(endVisit, that.endVisit) && Objects.equals(room, that.room) && Objects.equals(userHotel, that.userHotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startVisit, endVisit, numberOfGuests, breakfast, parking, animal, spa, room, userHotel);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startVisit=" + startVisit +
                ", endVisit=" + endVisit +
                ", numberOfGuests=" + numberOfGuests +
                ", breakfast=" + breakfast +
                ", parking=" + parking +
                ", animal=" + animal +
                ", spa=" + spa +
                ", room=" + room +
                ", userHotel=" + userHotel +
                '}';
    }
}


