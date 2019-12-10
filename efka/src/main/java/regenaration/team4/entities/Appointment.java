package regenaration.team4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    private Integer appointment_id;
    private Date appointment_date;
    private String appointment_description;
    private String appointment_comments;
    private Citizen citizen;
    private Doctor doctor;

    public Appointment(){}

    public Appointment(Integer appointment_id,Date appointment_date,String appointment_description,String appointment_comments){
        this.appointment_id = appointment_id;
        this.appointment_date = appointment_date;
        this.appointment_description = appointment_description;
        this.appointment_comments = appointment_comments;
    }

    @Id
    public Integer getAppointment_id() {
        return appointment_id;
    }
    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    @Column
    public Date getAppointment_date() {
        return appointment_date;
    }
    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    @Column
    public String getAppointment_description() {
        return appointment_description;
    }
    public void setAppointment_description(String appointment_description) {this.appointment_description = appointment_description;}

    @Column
    public String getAppointment_comments() {
        return appointment_comments;
    }
    public void setAppointment_comments(String appointment_comments) {this.appointment_comments = appointment_comments;}

    @ManyToOne
    @JoinColumn(name = "amka")
    public Citizen getCitizen(){return citizen;}
    public void setCitizen(Citizen citizen){this.citizen = citizen;}

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor(){return doctor;}
    public void setDoctor(Doctor doctor){this.doctor = doctor;}

}
