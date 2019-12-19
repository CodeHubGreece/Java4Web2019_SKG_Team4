package regenaration.team4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import regenaration.team4.WebAppConfig;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.AppointmentRepository;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.UserRepository;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    CitizenRepository citizenRepository;

    @PreAuthorize("hasRole('DOCTOR')")
    public List<Appointment> getAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                             @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                             @RequestParam(value = "description", defaultValue = "") String description,
                                             Principal principal) throws ParseException {

        //κανω το string που θα μου φέρουν date type. μαλλον λάθος
        User loggedInUser = userRepository.findByUsername(principal.getName());
        Date dateFrom=new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);

        if (loggedInUser.getRole() == WebAppConfig.Role.DOCTOR) {

            Integer docId = loggedInUser.getDoctor().getDoctor_id();

            List<Appointment> appointments = appointmentRepository.findAll();
            List<Appointment> response = new ArrayList<>();

            for (Appointment a : appointments) {
                if (a.getAppointment_date().compareTo(dateFrom) >= 0 && a.getAppointment_date().compareTo(dateTo) <= 0 && a.getDoctor().getDoctor_id() == docId) {
                    if (a.getAppointment_description().toLowerCase().contains(description.toLowerCase())) {
                        response.add(a);
                    }
                }
            }
            return response;
        }
        return null;
    }

    //βρες το ραντεβού
    @PreAuthorize("hasRole('DOCTOR')")
    @PostAuthorize("returnObject.doctor.user.username == authentication.principal.username")
    public Optional<Appointment> doctorGetAppointment(@PathVariable Long id) {
        return appointmentRepository.findById(id);
    }
    // βρες τον πολίτη που έχει το ραντεβού
    @PreAuthorize("hasRole('DOCTOR')")
    public Optional<Citizen> getCitizen(@PathVariable Long id) {
        return citizenRepository.findById(id);
    }

}