package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.dto.AppointmentDTO;
import regenaration.team4.entities.Appointment;
import regenaration.team4.services.CitizenService;

import java.security.Principal;

@RestController
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @PostMapping("/api/citizen/appointment")
    public Appointment createCitizenAppointment(@RequestBody AppointmentDTO newAppointmentDTO, Principal principal) {
        return citizenService.createCitizenAppointment(newAppointmentDTO, principal);
    }
}