package regenaration.team4.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import regenaration.team4.dto.SearchDTO;
import regenaration.team4.entities.Appointment;
import regenaration.team4.services.AppointmentService;
import java.security.Principal;
import java.util.Date;
import java.util.List;
@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/getcitizensearch")
    public List<Appointment> getCitizenSearch(@RequestBody SearchDTO searchDTO, Principal principal){
        return appointmentService.getFilteredCitizenAppointments(searchDTO,principal);
    }
    @GetMapping("/getallcitizenappointments")
    public List<Appointment> getAllCitizenAppointments(Principal principal){
        return appointmentService.getAllCitizenAppointments(principal);
    }
    @GetMapping("/getalldoctorappointments")
    public List<Appointment> getAllDoctorAppointments(Principal principal){
        return appointmentService.getAllDoctorAppointments(principal);
    }
    @GetMapping("/getdoctorsearch")
    public List<Appointment> getDoctorSearch(@RequestParam("fDate")Date fromDate, @RequestParam("tDate") Date toDate,Principal principal){
        return appointmentService.getFilteredDoctorAppointments(fromDate,toDate,principal);
    }
}