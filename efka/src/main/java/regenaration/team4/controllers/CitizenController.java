package org.regeneration.project.controllers;

import org.regeneration.project.models.Citizen;
import org.regeneration.project.models.User;
import org.regeneration.project.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    private CitizenService citizenService;

    public CitizenController(@Autowired CitizenService citizenService){
        this.citizenService = citizenService;
    }

    @GetMapping("")
    public List<Citizen> getCitizen(){
        return  citizenService.getAllCitizens();
    }

    //Single Item
    @GetMapping("/{id}")
    public Optional<Citizen> getOneCitizen(@PathVariable Long id){
        return citizenService.getOneCitizen(id);
    }

    @PostMapping("")
    public Citizen getNewCitizen(@RequestBody Citizen newCitizen){
        return citizenService.postNewCitizen(newCitizen);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
//    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Long id){
        citizenService.deleteCitizen(id);
    }
}
