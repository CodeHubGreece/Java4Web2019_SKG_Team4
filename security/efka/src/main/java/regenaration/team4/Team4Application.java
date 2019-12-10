package regenaration.team4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.SpecialtyRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Team4Application implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;

    public static void main(String[] args) {SpringApplication.run(Team4Application.class, args);}

    @Override
    public void run(String... args) throws Exception{

        List<Specialty> specialties = new ArrayList<>();
        Specialty specialtyA = new Specialty();
        specialtyA.setSpecialty_id(1);
        specialtyA.setSpecialty_name("kardiologos");
        specialties.add(specialtyA);
        specialtyRepository.saveAll(specialties);

        List<Doctor> doctors = new ArrayList<>();
        Doctor doctorA = new Doctor();
        doctorA.setDoctor_name("Giatros A");
        doctorA.setDoctor_id(1);
        doctorA.setDoctor_surname("Giatros B");
        doctorA.setDoctor_email("Giatros@gmail.com");
        doctorA.setDoctor_phone("123456789");
        doctorA.setSpecialty_id(1);
        doctorA.setUser_id(1);
        doctors.add(doctorA);
        doctorRepository.saveAll(doctors);
    }

}
