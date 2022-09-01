package pl.sda.dreamhotelsystem.dto.rooms;

import java.util.Objects;

public class RoomDto {

    private final String standard;

    private final int numberOfPeople;

    private final int roomNumber;

    private final int floor;

    private final double price;

    public RoomDto(String standard, int numberOfPeople, int roomNumber, int floor, double price) {
        this.standard = standard;
        this.numberOfPeople = numberOfPeople;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.price = price;
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
        return "RoomDto{" +
                "standard='" + standard + '\'' +
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
        RoomDto roomDto = (RoomDto) o;
        return numberOfPeople == roomDto.numberOfPeople &&
                roomNumber == roomDto.roomNumber && floor == roomDto.floor &&
                Double.compare(roomDto.price, price) == 0 && Objects.equals(standard, roomDto.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(standard, numberOfPeople, roomNumber, floor, price);
    }
}
