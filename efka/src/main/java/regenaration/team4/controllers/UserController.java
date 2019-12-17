package org.regeneration.project.controllers;

import org.regeneration.project.models.User;
import org.regeneration.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService){
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return  userService.getAllUsers();
    }

    //Single Item
    @GetMapping("/users/{id}")
    public Optional<User> getOneUser(@PathVariable Long id){
        return userService.getOneUser(id);
    }

    @GetMapping("/user")
    public User getLoggedInUser(Principal loggedInUser) {
        return userService.getLoggedInUser(loggedInUser);
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User newUser){
         return userService.postNewUser(newUser);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
