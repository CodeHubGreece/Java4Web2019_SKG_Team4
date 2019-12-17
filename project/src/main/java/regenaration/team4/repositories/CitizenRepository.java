package regenaration.team4.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import regenaration.team4.entities.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {


}
