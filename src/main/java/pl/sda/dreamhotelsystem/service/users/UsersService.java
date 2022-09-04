package pl.sda.dreamhotelsystem.service.users;

import pl.sda.dreamhotelsystem.domain.User;
import pl.sda.dreamhotelsystem.dto.users.UserDto;

import java.util.Collection;
import java.util.Optional;

public interface UsersService {

    User createUser(UserDto userDto);

    Collection<User> getAllUsers();

    Optional<User> getUser(int id);

    Optional<User> updateUser(UserDto userDto, int id);

    Optional<User> deleteUser(int id);
}
