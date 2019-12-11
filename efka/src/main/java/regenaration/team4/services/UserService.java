package regenaration.team4.services;

import org.springframework.beans.factory.annotation.Autowired;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

}
