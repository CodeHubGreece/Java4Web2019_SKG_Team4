package regenaration.team4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    private Integer doctor_id;
    private String doctor_name;
    private String doctor_surname;
    private  String doctor_email;
    private String doctor_phone;
    private User user;
    private Set<Appointment> appointments;
    private Specialty specialty;

    public Doctor(){}

    @Id
    @Column
    public Integer getDoctor_id() {
        return doctor_id;
    }
    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Column
    public String getDoctor_name() {
        return doctor_name;
    }
    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    @Column
    public String getDoctor_surname() {
        return doctor_surname;
    }
    public void setDoctor_surname(String doctor_surname) {
        this.doctor_surname = doctor_surname;
    }

    @Column
    public String getDoctor_email() {
        return doctor_email;
    }
    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    @Column
    public String getDoctor_phone() {
        return doctor_phone;
    }
    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    //@JoinColumn(name = "doctor_id")
    public Set<Appointment> getAppointments(){return appointments;}
    public void setAppointments(Set<Appointment> appointments){this.appointments = appointments;}

    @ManyToOne()
    @JoinColumn(name = "doctor_id", insertable = false,updatable = false)
    public Specialty getSpecialty(){return specialty;}
    public void setSpecialty(Specialty specialty){this.specialty = specialty;}
}
