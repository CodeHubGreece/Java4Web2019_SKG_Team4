package regenaration.team4.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import regenaration.team4.entities.User;

import java.util.Collection;
import java.util.Collections;

public class ApiUserDetails implements UserDetails {

    private final User user;

    public ApiUserDetails(User user) {this.user=user;}

    /*Εδω κανουμε τον έλεγχο για να δούμε αν ο user που έχουμε είναι γιατρός ή πολίτης*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getRole() == Role.DOCTOR) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + Role.DOCTOR.name()));
        } else if (user.getRole() == Role.CITIZEN) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + Role.CITIZEN.name()));
        } else {
            return null;
        }
    }

    @Override
    public String getPassword() { return user.getUser_password();} // παρε τον κωδικό

    @Override
    public String getUsername() { return user.getUsername();} // παρε το όνομα

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

