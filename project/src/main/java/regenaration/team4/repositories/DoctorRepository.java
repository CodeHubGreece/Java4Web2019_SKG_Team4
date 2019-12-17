package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    //Set<Doctor> findBySpecialtyId(Integer specialtyId);
}
