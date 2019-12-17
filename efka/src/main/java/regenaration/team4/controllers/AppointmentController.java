package org.regeneration.project.controllers;

import org.regeneration.project.models.Appointment;
import org.regeneration.project.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(@Autowired AppointmentService appointmentService){ this.appointmentService = appointmentService; }

    @GetMapping("")
    public List<Appointment> getAppointment(){
        return  appointmentService.getAllAppointments();
    }

    //Single Item
    @GetMapping("/{id}")
    public Optional<Appointment> getOneAppointment(@PathVariable Long id){ return appointmentService.getOneAppointment(id);}

    @PostMapping("")
    public Appointment getNewAppointment(@RequestBody Appointment newAppointment){
        return appointmentService.postNewAppointment(newAppointment);
    }

//    @PutMapping("/{id}")
//    public User updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userService.updateUser(newUser, id);
//    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
    }
}
