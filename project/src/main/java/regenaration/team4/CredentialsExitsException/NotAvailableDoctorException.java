package regenaration.team4.CredentialsExitsException;

public class NotAvailableDoctorException extends RuntimeException {
    public NotAvailableDoctorException() {
        super("The Doctor is not available, try other day or time");
    }
}
