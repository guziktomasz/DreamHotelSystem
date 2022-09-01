package pl.sda.dreamhotelsystem.service.rooms;


import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.domain.Room;
import pl.sda.dreamhotelsystem.dto.rooms.RoomDto;
import pl.sda.dreamhotelsystem.repository.rooms.RoomsRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository repository;

    public RoomsServiceImpl(RoomsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room createRoom(RoomDto roomDto) {
        Room createdRoom = new Room(roomDto.getStandard(),
                                    roomDto.getNumberOfPeople(),
                                    roomDto.getRoomNumber(),
                                    roomDto.getFloor(),
                                    roomDto.getPrice());
        repository.save(createdRoom);
        return createdRoom;
    }


    @Override
    public Collection<Room> getAllRooms() {
        return repository.findAll();
    }

    @Override
    public Optional<Room> getRoom(int id) {
        return repository.findById(id);
    }

//    @Override
//    public Collection<Room> filterRooms(int numberOfPeople) {
//        return null;
//    }

    @Override
    public Optional<Room> updateRoom(RoomDto updatedRoomDto, int numberOfRoom) {
        Optional<Room> roomToUpdate = repository.findAllByRoomNumber(numberOfRoom);
        if (roomToUpdate.isEmpty()) {
            return roomToUpdate;
        }
        Room foundRoom = roomToUpdate.get();
        Room updatedRoom = new Room(foundRoom.getId(), updatedRoomDto.getStandard(),
                                    updatedRoomDto.getNumberOfPeople(),
                                    updatedRoomDto.getRoomNumber(),
                                    updatedRoomDto.getFloor(),
                                    updatedRoomDto.getPrice());

        repository.save(updatedRoom);
        return Optional.of(updatedRoom);
    }

    @Override
    public Optional<Room> deleteRoom(int numberOfRoom) {
        Optional<Room> roomToDelete = repository.findAllByRoomNumber(numberOfRoom);
        if (roomToDelete.isEmpty()){
            return roomToDelete;
        }
        Room deletedRoom = roomToDelete.get();
        repository.delete(deletedRoom);
        return Optional.of(deletedRoom);
    }
}
