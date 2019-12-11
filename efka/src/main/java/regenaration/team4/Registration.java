package regenaration.team4;

public class Registration {
    private String username;
    private String password;
    private String amka;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public Registration(String username, String password,String amka, String name, String surname, String phone, String email) {
        this.username = username;
        this.password = password;
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAmka() {
        return amka;
    }
}
