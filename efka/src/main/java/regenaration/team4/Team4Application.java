package regenaration.team4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.SpecialtyRepository;
import regenaration.team4.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Team4Application implements CommandLineRunner {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {SpringApplication.run(Team4Application.class, args);}

    @Override
    public void run(String... args) throws Exception{

        List<Specialty> specialties = new ArrayList<>();
        Specialty specialtyA = new Specialty(1,"kardiologos");
        specialties.add(specialtyA);
        specialtyRepository.saveAll(specialties);

        List<User> users = new ArrayList<>();
        User userB = new User(2,"name2","password2","c");
        users.add(userB);
        userRepository.saveAll(users);

    }

}
