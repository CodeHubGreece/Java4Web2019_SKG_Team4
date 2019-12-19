package regenaration.team4.CredentialsExitsException;

public class PastAppointmentException extends RuntimeException {
    public PastAppointmentException() {super("You are trying to book an appointment in the past, try again");
    }
}

