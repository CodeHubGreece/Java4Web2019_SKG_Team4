package regenaration.team4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import regenaration.team4.CredentialsExitsException.CredentialsExitsException;
import regenaration.team4.WebAppConfig;
import regenaration.team4.dto.UserRegistrationDTO;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.UserRepository;

@Service
public class RegistrationService {


    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Citizen newRegistration(UserRegistrationDTO userRegistrationDTO) {

        if (userRepository.findByUsername(userRegistrationDTO.getUsername()) == null){

            User newUser = new User();
            newUser.setUsername(userRegistrationDTO.getUsername());
            newUser.setUser_password(passwordEncoder.encode(userRegistrationDTO.getCitizen_password()));
            newUser.setRole(WebAppConfig.Role.CITIZEN);

            Citizen newCitizen = new Citizen();
            newCitizen.setCitizen_name(userRegistrationDTO.getCitizen_name());
            newCitizen.setCitizen_surname(userRegistrationDTO.getCitizen_lastname());
            newCitizen.setCitizen_email(userRegistrationDTO.getCitizen_email());
            newCitizen.setCitizen_phone(userRegistrationDTO.getCitizen_phone());
            newCitizen.setAmka(userRegistrationDTO.getAmka());
            newCitizen.setUser(newUser);

            return citizenRepository.save(newCitizen);
        } else {
            throw new CredentialsExitsException(userRegistrationDTO.getUsername(), userRegistrationDTO.getCitizen_email(), userRegistrationDTO.getCitizen_phone());
        }
    }

}
