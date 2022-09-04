package pl.sda.dreamhotelsystem.service.users;

import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.domain.User;
import pl.sda.dreamhotelsystem.dto.users.UserDto;
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
    public User createUser(UserDto userDto) {
        User createdUser = new User(userDto.getName(),
                                    userDto.getSurname(),
                                    userDto.getTelephone(),
                                    userDto.getDateOfBirth(),
                                    userDto.getAccess());
        repository.save(createdUser);
        return createdUser;
    }

    @Override
    public Collection<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<User> updateUser(UserDto updatedUserDto, int id) {
        Optional<User> userToUpdate = repository.findById(id);
        if (userToUpdate.isEmpty()) {
            return userToUpdate;
        }
        User foundRoom = userToUpdate.get();
        User updatedUser = new User(foundRoom.getId(),
                                    updatedUserDto.getName(),
                                    updatedUserDto.getSurname(),
                                    updatedUserDto.getTelephone(),
                                    updatedUserDto.getDateOfBirth(),
                                    updatedUserDto.getAccess());
        repository.save(updatedUser);
        return Optional.of(updatedUser);
    }

    @Override
    public Optional<User> deleteUser(int id) {
        Optional<User> userToDelete = repository.findById(id);
        if (userToDelete.isEmpty()){
            return userToDelete;
        }
        User deletedUser = userToDelete.get();
        repository.delete(deletedUser);
        return Optional.of(deletedUser);
    }
}
