package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;

import java.util.List;
import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findBySpecialty(Specialty specialty);
}
