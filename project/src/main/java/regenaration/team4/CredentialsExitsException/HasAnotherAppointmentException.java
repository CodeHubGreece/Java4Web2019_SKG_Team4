package regenaration.team4.CredentialsExitsException;

public class HasAnotherAppointmentException extends RuntimeException {
    public HasAnotherAppointmentException() { super("You have an other appointment at that day and time, check your calendar");
    }
}
