package pl.sda.dreamhotelsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String standard;

    private int numberOfPeople;

    private int roomNumber;

    private int floor;

    private double price;

    public Room() {
    }

    public Room(int id, String standard, int numberOfPeople, int roomNumber, int floor, double price) {
        this.id = id;
        this.standard = standard;
        this.numberOfPeople = numberOfPeople;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.price = price;
    }

    public Room(String standard, int numberOfPeople, int roomNumber, int floor, double price) {

        this.standard = standard;
        this.numberOfPeople = numberOfPeople;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getStandard() {
        return standard;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", standard='" + standard + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", roomNumber=" + roomNumber +
                ", floor=" + floor +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && numberOfPeople == room.numberOfPeople &&
                roomNumber == room.roomNumber && floor == room.floor &&
                Double.compare(room.price, price) == 0 && Objects.equals(standard, room.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, standard, numberOfPeople, roomNumber, floor, price);
    }
}
