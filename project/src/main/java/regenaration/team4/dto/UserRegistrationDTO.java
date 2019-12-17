package regenaration.team4.dto;


public class UserRegistrationDTO {

    private Long userId;
    private String username;
    private String citizen_password;
    private Long citizenId;
    private String citizen_name;
    private String citizen_lastname;
    private String citizen_email;
    private String citizen_phone;
    private String amka;

    public UserRegistrationDTO(Long userId, String username, String citizen_password, Long citizenId, String citizen_name, String citizen_lastname, String citizen_email, String citizen_phone, String amka) {
        this.userId = userId;
        this.username = username;
        this.citizen_password = citizen_password;
        this.citizenId = citizenId;
        this.citizen_name = citizen_name;
        this.citizen_lastname = citizen_lastname;
        this.citizen_email = citizen_email;
        this.citizen_phone = citizen_phone;
        this.amka = amka;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getCitizen_password() {
        return citizen_password;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public String getCitizen_name() {
        return citizen_name;
    }

    public String getCitizen_lastname() {
        return citizen_lastname;
    }

    public String getCitizen_email() {
        return citizen_email;
    }

    public String getCitizen_phone() {
        return citizen_phone;
    }

    public String getAmka() {
        return amka;
    }
}