package org.regeneration.project.controllers;

import org.regeneration.project.models.Doctor;
import org.regeneration.project.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(@Autowired DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public List<Doctor> getDoctor(){
        return  doctorService.getAllDoctors();
    }

    //Single Item
    @GetMapping("/{id}")
    public Optional<Doctor> getOneDoctor(@PathVariable Long id){
        return doctorService.getOneDoctor(id);
    }

    @PostMapping("")
    public Doctor getNewDoctor(@RequestBody Doctor newDoctor){
        return doctorService.postNewDoctor(newDoctor);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
//    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){ doctorService.deleteDoctor(id);}
}