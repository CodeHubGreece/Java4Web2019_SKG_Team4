package regenaration.team4.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import regenaration.team4.dto.AppointmentDTO;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;
import regenaration.team4.services.CitizenService;

import java.security.Principal;
import java.util.List;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @PostMapping("/api/citizen/appointment")
    public Appointment createCitizenAppointment(@RequestBody AppointmentDTO newAppointmentDTO, Principal principal) {
        return citizenService.createCitizenAppointment(newAppointmentDTO, principal);
    }
    //ζηταω να έρθουν οι ειδικότητες
    @GetMapping("/getspecialities")
    public List<Specialty> getSpecialties(Authentication authentication) {
        return citizenService.getSpecialties();
    }

    //ζηταω να μου έρθει ο γιατρός που διάλεξα
    @GetMapping("/getDoctorsWithSpecialty/{specialtyId}")
    public List<Doctor> getDoctorsBySpecialtyId(@PathVariable Long specialtyId) {
        return citizenService.getDoctors(specialtyId);
    }
    //για να διαγραψω απο την βαση (αφου βγάλω ένα Id μετα αλλάζουν όλα?)
    @DeleteMapping("/deleteAppointment/{appointmentId}")
    public void deleteAppointmentById(@PathVariable Long appointmentId) {
        citizenService.deleteAppointmentById(appointmentId);
    }
    //για να μετατρεψω ένα ραντεβού μου
    @PutMapping("/editAppointment")
    public Appointment editAppointment(@RequestBody AppointmentDTO editAppointmentDTO, Principal principal) {
        return citizenService.editAppointment(editAppointmentDTO, principal);
    }

}