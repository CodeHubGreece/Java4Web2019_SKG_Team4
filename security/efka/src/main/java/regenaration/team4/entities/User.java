package regenaration.team4.entities;

import regenaration.team4.service.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    private Integer user_id;

    @Column
    private String username;

    @Column
    private String user_password;

   /* @Column
    private  String user_type;*/

    /*εμεις είχαμε δηλώσει τον τύπο του χρήστη με string. Για λόγους ασφαλείας και σε περίπτωση
    * που θέλουμε μετά να βαλουμε Admin εκανα ενα enum με ρόλους (ακουσα να το λένε στο μαθημα) σαν ονομα πάνω έβαλα το user type
    * για να κανει Mapping με την βάση*/

    @Column(name = "user_type")
    private Role role;

    private Doctor doctor;
    private Citizen citizen;

    public User() { }

    /*Φτιάχνω δυο constractors στον ένα θα παρει απο το front το user name και to password και extra
    * στον απο κάτω θα πάρω και τον ρολο ανάλογα με το πως θα το υλοποιήσουμε στο front*/
    public User(String username, String password) {
        this.username = username;
        this.user_password = password;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.user_password = password;
        this.role = role;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /*public void setUser_type(String user_type) {
        this.user_type = user_type;
    }*/

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_password() {
        return user_password;
    }

   /* public String getUser_type() {
        return user_type;
    }*/

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
