package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
