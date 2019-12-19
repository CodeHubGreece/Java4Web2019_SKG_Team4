package regenaration.team4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import regenaration.team4.WebAppConfig;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {


    private Integer user_id;
    private String username;
    private String user_password;
    private WebAppConfig.Role user_type;
    private Citizen citizen;
    private Doctor doctor;

    public  User(){}

    public User(String username, String user_password, WebAppConfig.Role user_type){
        this.username = username;
        this.user_password = user_password;
        this.user_type = user_type;
    }

    public User(String user, String user1) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Integer getUser_id() {

        return user_id;
    }
    public void setUser_id(Integer user_id) {

        this.user_id = user_id;
    }

    @Column
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    @JsonIgnore
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Column
    public WebAppConfig.Role getRole() {
        return user_type;
    }
    public void setRole(WebAppConfig.Role user_type) {
        this.user_type = user_type;
    }

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    public Citizen getCitizen(){return citizen;}
    public void setCitizen(Citizen citizen){this.citizen = citizen;}

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    public Doctor getDoctor(){return doctor;}
    public void setDoctor(Doctor doctor){this.doctor = doctor;}

}
