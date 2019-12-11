package regenaration.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import regenaration.team4.entities.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, String> {

    Citizen findByAmka(String amka);

}
