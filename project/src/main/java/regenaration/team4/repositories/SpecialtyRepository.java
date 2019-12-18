package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Specialty;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
    List<Specialty> findAll();
}
