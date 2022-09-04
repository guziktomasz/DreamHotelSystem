package pl.sda.dreamhotelsystem.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.dreamhotelsystem.domain.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
