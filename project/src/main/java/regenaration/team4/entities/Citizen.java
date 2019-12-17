package regenaration.team4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "citizens")
public class Citizen implements Serializable {

    private  String amka;
    private String citizen_name;
    private String citizen_surname;
    private String citizen_email;
    private String phone;
    private User user;
    private Set<Appointment> appointments;

    public Citizen(){}

    public Citizen(String amka,String citizen_name,String citizen_surname,String citizen_email,String citizen_phone){
        this.amka = amka;
        this.citizen_name = citizen_name;
        this.citizen_surname = citizen_surname;
        this.citizen_email = citizen_email;
        this.phone = citizen_phone;
    }

    @Id
    @Column(length = 11)
    public String getAmka() {return amka;}
    public void setAmka(String amka) {this.amka = amka; }

    @Column
    public String getCitizen_name() {
        return citizen_name;
    }
    public void setCitizen_name(String citizen_name) {
        this.citizen_name = citizen_name;
    }

    @Column
    public String getCitizen_surname() {
        return citizen_surname;
    }
    public void setCitizen_surname(String citizen_surname) {
        this.citizen_surname = citizen_surname;
    }

    @Column
    public String getCitizen_email() {
        return citizen_email;
    }
    public void setCitizen_email(String citizen_email) {
        this.citizen_email = citizen_email;
    }

    @Column
    public String getCitizen_phone() {
        return phone;
    }
    public void setCitizen_phone(String citizen_phone) {
        this.phone = citizen_phone;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)
    public Set<Appointment> getAppointments(){return appointments;}
    public void setAppointments(Set<Appointment> appointments){this.appointments = appointments;}

}
