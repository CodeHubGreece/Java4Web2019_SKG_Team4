package regenaration.team4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Team4Application implements CommandLineRunner {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {SpringApplication.run(Team4Application.class, args);}

    @Override
    public void run(String... args) {

        List<User> users = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        User userA = new User("userA", "passA", "C");
        users.add(userA);userRepository.saveAll(users);
        Citizen citizen = new Citizen("01234567890","citizenAname","citizenAsurname","citizenAemail","xxxxxxxxxA");
        citizen.setUser(userA);
        citizens.add(citizen);
        citizenRepository.saveAll(citizens);

    }

}
