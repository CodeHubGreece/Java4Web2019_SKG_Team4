package regenaration.team4.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private Integer user_id;
    private String username;
    private String user_password;
    private String user_type;
    private Citizen citizen;
    private Doctor doctor;

    public  User(){}

    public User(Integer user_id,String username,String user_password,String user_type){
        this.user_id = user_id;
        this.username = username;
        this.user_password = user_password;
        this.user_type = user_type;
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
    public String getUser_password() {
        return user_password;
    }
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Column
    public String getUser_type() {
        return user_type;
    }
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    @OneToOne(mappedBy = "user")
    public Citizen getCitizen(){return citizen;}
    public void setCitizen(Citizen citizen){this.citizen = citizen;}

    @OneToOne(mappedBy = "user")
    public Doctor getDoctor(){return doctor;}
    public void setDoctor(Doctor doctor){this.doctor = doctor;}

}
