package pl.sda.dreamhotelsystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.PositiveOrZero;

@Component
@ConfigurationProperties(prefix = "pl.sda.dreamhotelsystem")
@Validated
public class AppConfig {

    @PositiveOrZero
    private int sizeOfInitialDataRooms;

    @PositiveOrZero
    private int sizeOfInitialDataReservations;

    @PositiveOrZero
    private int sizeOfInitialDataUsersHotel;

    public int getSizeOfInitialDataRooms() {
        return sizeOfInitialDataRooms;
    }

    public int getSizeOfInitialDataReservations() {
        return sizeOfInitialDataReservations;
    }

    public void setSizeOfInitialDataRooms(int sizeOfInitialDataRooms) {
        this.sizeOfInitialDataRooms = sizeOfInitialDataRooms;
    }

    public void setSizeOfInitialDataReservations(int sizeOfInitialDataReservations) {
        this.sizeOfInitialDataReservations = sizeOfInitialDataReservations;
    }

    public int getSizeOfInitialDataUsersHotel() {
        return sizeOfInitialDataUsersHotel;
    }

    public void setSizeOfInitialDataUsersHotel(int sizeOfInitialDataUsersHotel) {
        this.sizeOfInitialDataUsersHotel = sizeOfInitialDataUsersHotel;
    }
}
