package regenaration.team4.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.dto.UserRegistrationDTO;
import regenaration.team4.entities.Citizen;
import regenaration.team4.services.RegistrationService;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @PostMapping("api/registration")
    public Citizen newRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return registrationService.newRegistration(userRegistrationDTO);
    }
}