package pl.sda.dreamhotelsystem.controller.rooms;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.dreamhotelsystem.domain.Room;
import pl.sda.dreamhotelsystem.dto.rooms.RoomDto;
import pl.sda.dreamhotelsystem.service.rooms.RoomsService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rooms")
public class RoomsController {

    private final RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        System.out.println("RoomController " + roomsService);
        this.roomsService = roomsService;
    }

    // Create

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody @Valid RoomDto roomDto) {
//        System.out.println("RoomController.createRoom(" + roomDto + ")");
        return roomsService.createRoom(roomDto);
    }

    // Read

    @GetMapping
    public Collection<Room> getAllRooms(){
        return roomsService.getAllRooms();
    }

    @GetMapping(path = "/{roomNumber}")
    public ResponseEntity<Room> getRoom(@PathVariable int roomNumber){
        System.out.println("getRoomByRoomNumber");
        return roomsService.getRoom(roomNumber).map(room -> new ResponseEntity<>(room, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update

    @PutMapping(path = "/{roomNumber}")
    public ResponseEntity<Room> updateRoom(@RequestBody @Valid RoomDto updateRoomDto,
                                           @PathVariable int roomNumber){
        Optional<Room> updatedRoom = roomsService.updateRoom(updateRoomDto, roomNumber);
        if (updatedRoom.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedRoom.get(), HttpStatus.OK);
    }

    // Delete

    @DeleteMapping(path = "/{roomNumber}")
    public ResponseEntity<Room> deleteRoom(@PathVariable int roomNumber){
        Optional<Room> deletedRoom = roomsService.deleteRoom(roomNumber);
        if (deletedRoom.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedRoom.get(), HttpStatus.OK);
}
}
