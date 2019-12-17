package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.UserRepository;

import java.security.Principal;

@RestController
public class UserController  {
    @GetMapping("/user")
    public User getUser(Principal principal){
        return userRepository.findByUsername(principal.getName());

    }
    @Autowired
    private UserRepository userRepository;


}
