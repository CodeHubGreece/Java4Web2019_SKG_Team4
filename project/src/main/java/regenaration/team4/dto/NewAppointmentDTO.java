package regenaration.team4.dto;

import java.util.Date;

public class NewAppointmentDTO {

    private String appointmentDescription;
    private String appointmentComments;
    private Date appointmentDate;
    private String doctorName;

    public NewAppointmentDTO(String appointmentDescription, String appointmentComments, Date appointmentDate, String doctorName) {
        this.appointmentDescription = appointmentDescription;
        this.appointmentComments = appointmentComments;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public String getAppointmentComments() {
        return appointmentComments;
    }

    public void setAppointmentComments(String appointmentComments) {
        this.appointmentComments = appointmentComments;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
