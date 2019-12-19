




package regenaration.team4.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import regenaration.team4.dto.SearchDTO;
import regenaration.team4.entities.Appointment;
import regenaration.team4.entities.Doctor;
import regenaration.team4.entities.Specialty;
import regenaration.team4.entities.User;
import regenaration.team4.repositories.AppointmentRepository;
import regenaration.team4.repositories.CitizenRepository;
import regenaration.team4.repositories.DoctorRepository;
import regenaration.team4.repositories.UserRepository;
import java.security.Principal;
import java.util.Date;
import java.util.List;
@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    CitizenRepository citizenRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    public List<Appointment> getFilteredCitizenAppointments(@RequestBody SearchDTO searchDTO, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        List<Appointment> appointments = appointmentRepository.findByCitizen(citizenRepository.findCitizenByUser(user));
        for (int i = 0; i < appointments.size(); i++) {
            Doctor doctor = appointments.get(i).getDoctor();
            Specialty specialty = doctor.getSpecialty();
            Integer mySpecialtyId = specialty.getSpecialty_id();
            if ( ((appointments.get(i).getAppointment_date().compareTo(searchDTO.getFromDate())) < 0) || ((appointments.get(i).getAppointment_date().compareTo(searchDTO.getToDate())) > 0) || (mySpecialtyId != searchDTO.getSpecialtyId()) ) {
                appointments.remove(appointments.get(i));
            }
        }
        return appointments;
    }
    public List<Appointment> getFilteredDoctorAppointments(@RequestParam("fDate") Date fromDate, @RequestParam("tDate") Date toDate,Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        List<Appointment> appointments = appointmentRepository.findByDoctor(doctorRepository.findDoctorByUser(user));
        for (int i = 0; i < appointments.size(); i++) {
            if ( ((appointments.get(i).getAppointment_date().compareTo(fromDate)) > 0) || ((appointments.get(i).getAppointment_date().compareTo(toDate)) < 0) ) {
                appointments.remove(appointments.get(i));
            }
        }
        return appointments;
    }
    public List<Appointment> getAllCitizenAppointments(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return appointmentRepository.findByCitizen(citizenRepository.findCitizenByUser(user));
    }
    public List<Appointment> getAllDoctorAppointments(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return appointmentRepository.findByDoctor(doctorRepository.findDoctorByUser(user));
    }
}