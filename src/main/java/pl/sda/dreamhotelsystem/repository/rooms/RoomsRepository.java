package pl.sda.dreamhotelsystem.repository.rooms;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.dreamhotelsystem.domain.Room;

import java.util.Collection;
import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findAllByRoomNumber(int roomNumber);
}
