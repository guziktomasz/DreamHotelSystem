package pl.sda.dreamhotelsystem.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.dreamhotelsystem.domain.UserHotel;

public interface UsersRepository extends JpaRepository<UserHotel, Integer> {
}
