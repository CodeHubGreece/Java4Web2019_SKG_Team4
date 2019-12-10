package regenaration.team4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty implements Serializable {

    private Integer specialty_id;
    private String specialty_name;
    private Set<Doctor> doctors;

    public Specialty(){}

    public Specialty(Integer specialty_id,String specialty_name){
        this.specialty_id = specialty_id;
        this.specialty_name = specialty_name;
    }

    @Id
    public Integer getSpecialty_id() {
        return specialty_id;
    }
    public void setSpecialty_id(Integer specialty_id) {
        this.specialty_id = specialty_id;
    }

    @Column
    public String getSpecialty_name() {
        return specialty_name;
    }
    public void setSpecialty_name(String specialty_name) {
        this.specialty_name = specialty_name;
    }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    //@JoinColumn(name = "doctor_id")
    public Set<Doctor> getDoctors(){return doctors;}
    public void setDoctors(Set<Doctor> doctors){this.doctors = doctors;}

}
