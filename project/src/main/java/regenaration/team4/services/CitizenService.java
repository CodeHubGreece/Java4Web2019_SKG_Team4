package regenaration.team4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import regenaration.team4.dto.AppointmentDTO;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Citizen;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.AppointmentRepository;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.SpecialtyRepository;
import regenaration.team4.repositories.UserRepository;

import java.security.Principal;

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
    }
