package regenaration.team4.services;

import org.springframework.stereotype.Service;
import regenaration.team4.Registration;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.UserRepository;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;
    private final UserRepository userRepository;

    public  CitizenService(CitizenRepository citizenRepository,UserRepository userRepository){
        this.citizenRepository = citizenRepository;
        this.userRepository = userRepository;
    }

    public Citizen findByAmka (String amka){
        return citizenRepository.findByAmka(amka);
    }

    public void register(Registration registration)
    {
        User user = new User(registration.getUsername(),registration.getPassword(),"c");
        userRepository.save(user);
        Citizen citizen = new Citizen(registration.getAmka(),registration.getName(),registration.getSurname(),registration.getEmail(),registration.getPhone());
        citizen.setUser(user);
        citizenRepository.save(citizen);
    }

}
