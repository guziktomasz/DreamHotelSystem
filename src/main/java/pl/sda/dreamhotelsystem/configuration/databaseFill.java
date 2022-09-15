package pl.sda.dreamhotelsystem.configuration;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pl.sda.dreamhotelsystem.domain.Reservation;
import pl.sda.dreamhotelsystem.domain.Room;
import pl.sda.dreamhotelsystem.domain.UserHotel;
import pl.sda.dreamhotelsystem.dto.reservations.ReservationDto;
import pl.sda.dreamhotelsystem.dto.rooms.RoomDto;
import pl.sda.dreamhotelsystem.repository.reservations.ReservationsRepository;
import pl.sda.dreamhotelsystem.repository.rooms.RoomsRepository;
import pl.sda.dreamhotelsystem.repository.users.UsersRepository;
import pl.sda.dreamhotelsystem.service.rooms.RoomsService;
import pl.sda.dreamhotelsystem.service.users.UsersService;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class databaseFill implements CommandLineRunner {


    private final RoomsRepository roomsRepository;
    private final ReservationsRepository reservationsRepository;
    private final UsersRepository usersRepository;

    private final UsersService usersService;

    private final RoomsService roomsService;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        roomsRepository.deleteAll();
        Room turboVip = roomsRepository.save(new Room("TurboVip", 2, 1, 2, 1000));
        roomsRepository.save(new Room("VIP", 2, 2, 1, 800));
        roomsRepository.save(new Room("Bieda Edition", 4, 3, 1, 400));
        roomsRepository.save(new Room("TurboVip", 2, 4, 1, 1000));
        roomsRepository.save(new Room("Bieda Edition", 5, 5, 0, 500));
        roomsRepository.save(new Room("VIP", 2, 6, 1, 800));
        roomsRepository.save(new Room("TurboVip", 2, 7, 2, 1000));
        roomsRepository.save(new Room("TurboVip", 2, 8, 1, 1000));
        roomsRepository.save(new Room("Bieda Edition", 7, 9, 0, 650));
        roomsRepository.save(new Room("VIP", 3, 10, 2, 900));

        UserHotel save = usersRepository.save(new UserHotel("Zenon", "Martyniuk", "997", LocalDate.of(1969, 6, 23), "GUEST"));
        usersRepository.save(new UserHotel("Maryla", "Rodowicz", "123456789", LocalDate.of(1945, 12, 8), "GUEST"));
        usersRepository.save(new UserHotel("Sławomir", "Zapała", "9876544321", LocalDate.of(1983, 3, 19), "GUEST"));
        usersRepository.save(new UserHotel("Edyta", "Górniak", "666", LocalDate.of(1972, 11, 14), "GUEST"));



        reservationsRepository.save(new Reservation(LocalDate.of(2022, 9, 8),
                LocalDate.of(2022, 9, 11),
                1,
                true,
                false,
                true,
                false,
               turboVip,
                save));

        reservationsRepository.save(new Reservation(LocalDate.of(2022, 9, 11),
                LocalDate.of(2022, 9, 15),
                2,
                true,
                false,
                false,
                false,
                roomsRepository.findById(2).get(),
                usersRepository.findById(2).get()));
        reservationsRepository.save(new Reservation(LocalDate.of(2022, 9, 9),
                LocalDate.of(2022, 9, 20),
                6,
                false,
                false,
                false,
                false,
                roomsRepository.findById(3).get(),
                usersRepository.findById(3).get()));
        reservationsRepository.save(new Reservation(LocalDate.of(2022, 9, 9),
                LocalDate.of(2022, 9, 15),
                2,
                true,
                false,
                false,
                true,
                roomsRepository.findById(4).get(),
                usersRepository.findById(4).get()));


    }
}
