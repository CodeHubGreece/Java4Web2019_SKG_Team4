package regenaration.team4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import regenaration.team4.entities.Appointment;
import regenaration.team4.services.AppointmentService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/getcitizensearch")
    public List<Appointment> getCitizenSearch(@RequestParam("fDate")Date fromDate, @RequestParam("tDate") Date toDate, @RequestParam("specialtyId") Integer specialtyId, Principal principal){
        return appointmentService.getFilteredCitizenAppointments(fromDate,toDate,specialtyId,principal);
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
