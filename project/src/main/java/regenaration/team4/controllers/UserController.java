package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.UserRepository;

import java.security.Principal;

@RestController
public class UserController  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/user")
    public User getUser(Principal principal){return userRepository.findByUsername(principal.getName());}

    @GetMapping("/getcitizen")
    public Citizen getCitizenProfile(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return citizenRepository.findCitizenByUser(user);
    }

    @GetMapping("/getdoctorprofile")
    public Doctor getDoctorProfile(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return doctorRepository.findDoctorByUser(user);
    }



}
