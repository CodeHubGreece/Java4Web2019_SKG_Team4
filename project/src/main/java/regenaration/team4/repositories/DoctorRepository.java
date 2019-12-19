package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;
import regenaration.team4.entities.User;

import java.util.List;
import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    Doctor findDoctorByUser(User user);
    List<Doctor> findBySpecialty(Specialty specialty);
}
