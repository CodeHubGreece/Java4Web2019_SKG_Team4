package regenaration.team4.dto;

import java.util.Date;

public class AppointmentDTO {


    private Integer doctorId;
    private Long appointment_id;
    private Date appointment_date;
    private String specialtyName;
    private String appointment_comments;
    private String appointment_description;

    public AppointmentDTO(Integer doctorId, Date appointment_date, String specialtyName, String appointment_comments, String appointment_description) {
        this.doctorId = doctorId;
        this.appointment_date = appointment_date;
        this.specialtyName = specialtyName;
        this.appointment_comments = appointment_comments;
        this.appointment_description = appointment_description;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_comments() {
        return appointment_comments;
    }

    public void setAppointment_comments(String appointment_comments) {
        this.appointment_comments = appointment_comments;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getAppointment_description() {
        return appointment_description;
    }

    public void setAppointment_description(String appointment_description) {
        this.appointment_description = appointment_description;
    }

    public Long getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Long appointment_id) {
        this.appointment_id = appointment_id;
    }
}