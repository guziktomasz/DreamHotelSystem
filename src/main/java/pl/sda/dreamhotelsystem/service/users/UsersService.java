package pl.sda.dreamhotelsystem.service.users;

import pl.sda.dreamhotelsystem.domain.UserHotel;
import pl.sda.dreamhotelsystem.dto.users.UserHotelDto;

import java.util.Collection;
import java.util.Optional;

public interface UsersService {

    UserHotel createUser(UserHotelDto userDto);

    Collection<UserHotel> getAllUsers();

    Optional<UserHotel> getUser(int id);

    Optional<UserHotel> updateUser(UserHotelDto userDto, int id);

    Optional<UserHotel> deleteUser(int id);
}
