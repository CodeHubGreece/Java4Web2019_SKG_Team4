package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.entities.Specialty;
import regenaration.team4.repositories.SpecialtyRepository;

import java.util.List;

@RestController
public class SpecialtyController {

    @GetMapping("/getspecialities")
    public List<Specialty> getAllSpecialties(){
        return specialtyRepository.findAll();
    }
    @Autowired
    private SpecialtyRepository specialtyRepository;

}
