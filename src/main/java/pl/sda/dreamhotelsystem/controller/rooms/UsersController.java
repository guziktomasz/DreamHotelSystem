package pl.sda.dreamhotelsystem.controller.rooms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.dreamhotelsystem.domain.User;
import pl.sda.dreamhotelsystem.dto.users.UserDto;
import pl.sda.dreamhotelsystem.service.users.UsersService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

   private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    //Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserDto userDto) {

        return usersService.createUser(userDto);
    }

    //Read
    @GetMapping
    public Collection<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        System.out.println("getUserById");
        return usersService.getUser(id).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //Update
    @PutMapping(path = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto updateUserDto,
                                           @PathVariable int id){
        Optional<User> updatedUser = usersService.updateUser(updateUserDto, id);
        if (updatedUser.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
    }
    //Delete
    @DeleteMapping(path = "/id")
    public ResponseEntity<User> deletedUser(@PathVariable int id){
        Optional<User> deletedUser = usersService.deleteUser(id);
        if(deletedUser.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedUser.get(), HttpStatus.OK);
    }
}
