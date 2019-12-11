package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
