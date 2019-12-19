package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.Doctor;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByCitizen(Citizen citizen);
    List<Appointment> findByDoctor(Doctor doctor);
}
