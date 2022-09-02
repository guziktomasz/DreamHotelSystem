package pl.sda.dreamhotelsystem.service.rooms;

import pl.sda.dreamhotelsystem.domain.Room;
import pl.sda.dreamhotelsystem.dto.rooms.RoomDto;

import java.util.Collection;
import java.util.Optional;

public interface RoomsService {

    Room createRoom(RoomDto roomDto);

    Collection<Room> getAllRooms();

    Optional<Room> getRoom(int roomNumber);

//    Collection<Room> filterRooms(int numberOfPeople);

    Optional<Room> updateRoom(RoomDto roomDto, int numberOfRoom);

    Optional<Room> deleteRoom(int numberOfRoom);
}
