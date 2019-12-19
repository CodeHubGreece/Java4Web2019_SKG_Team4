package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Citizen;
import regenaration.team4.services.DoctorService;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/api/doctor/appointments")
    public List<Appointment> getAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                             @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                             @RequestParam(value = "description", defaultValue = "") String description,
                                             Principal principal) throws ParseException {

        return doctorService.getAppointments(fromDate,toDate,description,principal);
    }

    //μονο του έβαλε το optional ζητάμε ενα appointment
    @GetMapping("/api/doctor/appointment/{id}")
    public Optional<Appointment> doctorGetAppointment(@PathVariable Long id) {
        return doctorService.doctorGetAppointment(id);

    }

    //δες τα στοιχεία του πολίτη που έχει το ραντεβού
    @GetMapping("/api/doctor/citizen/{id}")
    public Optional<Citizen> getCitizen(@PathVariable Long id) {
        return doctorService.getCitizen(id);

    }

}
