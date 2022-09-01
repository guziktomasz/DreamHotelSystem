package pl.sda.dreamhotelsystem.controller.rooms;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.dreamhotelsystem.service.rooms.RoomsService;

@RestController
@RequestMapping(path = "/rooms")
public class RoomsController {

    private final RoomsService roomsService;

    public RoomsController(RoomsService roomsService) {
        System.out.println("RoomController " + roomsService);
        this.roomsService = roomsService;
    }

    // Create

//    @PostMapping
//    @ResponseStatus
}
