package regenaration.team4.CredentialsExitsException;

public class CredentialsExitsException extends RuntimeException {

        public CredentialsExitsException(String username, String email, String phone) {
            super("One or more of your credentials (" + username + ", " + email + ", " + phone + ") already exist.");
        }

}

