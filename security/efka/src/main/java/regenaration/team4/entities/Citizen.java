package regenaration.team4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "citizens")
public class Citizen implements Serializable {

    @Id
    private  String amka;

    @Column
    private String citizen_name;

    @Column
    private String citizen_surname;

    @Column
    private String citizen_email;

    @Column
    private String citizen_phone;

    @Column
    private Integer user_id;

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public void setCitizen_name(String citizen_name) {
        this.citizen_name = citizen_name;
    }

    public void setCitizen_surname(String citizen_surname) {
        this.citizen_surname = citizen_surname;
    }

    public void setCitizen_email(String citizen_email) {
        this.citizen_email = citizen_email;
    }

    public void setCitizen_phone(String citizen_phone) {
        this.citizen_phone = citizen_phone;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAmka() {
        return amka;
    }

    public String getCitizen_name() {
        return citizen_name;
    }

    public String getCitizen_surname() {
        return citizen_surname;
    }

    public String getCitizen_email() {
        return citizen_email;
    }

    public String getCitizen_phone() {
        return citizen_phone;
    }

    public Integer getUser_id() {
        return user_id;
    }
}
