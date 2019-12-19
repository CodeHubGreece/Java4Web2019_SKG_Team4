package regenaration.team4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import regenaration.team4.WebAppConfig;
import regenaration.team4.dto.AppointmentDTO;
import regenaration.team4.entities.*;
import regenaration.team4.repositories.AppointmentRepository;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.SpecialtyRepository;
import regenaration.team4.repositories.UserRepository;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;


    @PreAuthorize("hasRole('CITIZEN')")
    public Appointment createCitizenAppointment(@RequestBody AppointmentDTO AppointmentDTO, Principal principal) {
        Appointment appointment = new Appointment();
        User loggedInUser = userRepository.findByUsername(principal.getName());
            Citizen citizen = loggedInUser.getCitizen();
            Doctor doctor = doctorRepository.findById(AppointmentDTO.getDoctorId()).get();
            appointment.setCitizen(citizen);
            appointment.setDoctor(doctor);
            appointment.setAppointment_date(AppointmentDTO.getAppointment_date());
            appointment.setAppointment_comments(AppointmentDTO.getAppointment_comments());
            appointment.setAppointment_description(AppointmentDTO.getAppointment_description());
            appointmentRepository.save(appointment);
            return appointment;
        }

    @PreAuthorize("hasRole('CITIZEN')")
    public List<Specialty> getSpecialties() {
        return specialtyRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    public List<Doctor> getDoctors(@PathVariable Integer specialityId) {
        //κανω μια λιστα με γιατρους
        List<Doctor> doctors = new ArrayList<Doctor>();
        // To Optional αντικειμενο περιέχει μη μηδενικά αντικείμενα.
        Optional <Specialty> specialtyOptional = specialtyRepository.findById(specialityId);
        // βαζω στο specialty το Id
        Specialty specialty = specialtyOptional.get();
        //με βαση το id θα ψαξει τους γιατρούς με το αντίστοιχο speciality
        doctors = doctorRepository.findBySpecialty(specialty);
        // επιστέφει την λίστα των γιατρών
        return doctors;
        }

    @PreAuthorize("hasRole('CITIZEN')")
    // αυτο το εβαλε μονο του το Idea, εγω ήθελα να ειναι appointment
    @PostAuthorize("returnObject.citizen.user.username == authentication.principal.username")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id);
    }

    @PreAuthorize("hasRole('CITIZEN')")
    public void deleteAppointmentById(@PathVariable String appointmentId) {
        Long appointmentID = Long.parseLong(appointmentId);
        //getAppointmentById(appointmentID);
        appointmentRepository.deleteById(appointmentID);
    }

    @PreAuthorize("hasRole('CITIZEN')")
    public Appointment editAppointment(@RequestBody AppointmentDTO editAppointmentDTO, Principal principal) {
        //pare to appointment poy dialekse o xristis
        Appointment appointmentToEdit = appointmentRepository.findById(editAppointmentDTO.getAppointment_id()).get();
        // πρεπει να πουμε και στον γιατρο να αλλάξει το ραντεβού του
        Optional<Doctor> doctor = doctorRepository.findById(appointmentToEdit.getDoctor().getDoctor_id()); //Μονο του εβαλε Optional
        //χρειαζομαι τον χρηστη για το principal
        User loggedInUser = userRepository.findByUsername(principal.getName());
        Citizen citizen = loggedInUser.getCitizen();
        //βαλε τα νεα στοιχεία στο appointment to edit
        appointmentToEdit.setAppointment_date(editAppointmentDTO.getAppointment_date());
        appointmentToEdit.setAppointment_description(editAppointmentDTO.getAppointment_description());
        appointmentToEdit.setAppointment_comments(editAppointmentDTO.getAppointment_comments());
        // και περασε το στην βαση
        appointmentRepository.save(appointmentToEdit);
        return appointmentToEdit;
    }

    @PreAuthorize("hasRole('CITIZEN')")
    public List<Appointment> getCitAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                                @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                                @RequestParam(value = "specialty", defaultValue = "") String specialty,
                                                Principal principal) throws ParseException {

        User loggedInUser = userRepository.findByUsername(principal.getName());
        Date dateFrom=new SimpleDateFormat("dd/MM/yyyy").parse(fromDate);
        Date dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(toDate);
        if (loggedInUser.getRole() == WebAppConfig.Role.CITIZEN) {
            Integer citId = loggedInUser.getCitizen().getUser().getUser_id(); // εδώ θέλω να πάρω το citizen id. ??? το ίδιο 4 γραμμές κάτω.
            List<Appointment> appointments = appointmentRepository.findAll();
            List<Appointment> response = new ArrayList<>();
                for (Appointment a : appointments) {
                    if (a.getAppointment_date().compareTo(dateFrom) >= 0 && a.getAppointment_date().compareTo(dateTo) <= 0 && a.getCitizen().getUser().getUser_id() == citId) {
                        if (a.getDoctor().getSpecialty().getSpecialty_id() == Long.parseLong(specialty)) {
                            response.add(a);
                        }
                    }
                }
            return response;
            }
        return null;
    }



}