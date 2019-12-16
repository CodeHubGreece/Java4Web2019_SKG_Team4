package org.regeneration.project.controllers;

import org.regeneration.project.models.Speciality;
import org.regeneration.project.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    private SpecialityService specialityService;

    public SpecialityController(@Autowired SpecialityService specialityService){
        this.specialityService = specialityService;
    }

    @GetMapping("")
    public List<Speciality> getSpeciality(){
        return  specialityService.getAllSpecialities();
    }

    //Single Item
    @GetMapping("/{id}")
    public Optional<Speciality> getOneSpeciality(@PathVariable Long id){return specialityService.getOneSpeciality(id);}

    @PostMapping("")
    public Speciality getNewSpeciality(@RequestBody Speciality newSpeciality){
        return specialityService.postNewSpeciality(newSpeciality);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
//    }

    @DeleteMapping("/{id}")
    public void deleteSpeciality(@PathVariable Long id){ specialityService.deleteSpeciality(id);}
}

