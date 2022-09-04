package pl.sda.dreamhotelsystem.service.users;

import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.domain.UserHotel;
import pl.sda.dreamhotelsystem.dto.users.UserHotelDto;
import pl.sda.dreamhotelsystem.repository.users.UsersRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository repository;

    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserHotel createUser(UserHotelDto userDto) {
        UserHotel createdUser = new UserHotel(userDto.getName(),
                                    userDto.getSurname(),
                                    userDto.getTelephone(),
                                    userDto.getDateOfBirth(),
                                    userDto.getAccess());
        repository.save(createdUser);
        return createdUser;
    }

    @Override
    public Collection<UserHotel> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<UserHotel> getUser(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserHotel> updateUser(UserHotelDto updatedUserDto, int id) {
        Optional<UserHotel> userToUpdate = repository.findById(id);
        if (userToUpdate.isEmpty()) {
            return userToUpdate;
        }
        UserHotel foundRoom = userToUpdate.get();
        UserHotel updatedUser = new UserHotel(foundRoom.getId(),
                                    updatedUserDto.getName(),
                                    updatedUserDto.getSurname(),
                                    updatedUserDto.getTelephone(),
                                    updatedUserDto.getDateOfBirth(),
                                    updatedUserDto.getAccess());
        repository.save(updatedUser);
        return Optional.of(updatedUser);
    }

    @Override
    public Optional<UserHotel> deleteUser(int id) {
        Optional<UserHotel> userToDelete = repository.findById(id);
        if (userToDelete.isEmpty()){
            return userToDelete;
        }
        UserHotel deletedUser = userToDelete.get();
        repository.delete(deletedUser);
        return Optional.of(deletedUser);
    }
}
