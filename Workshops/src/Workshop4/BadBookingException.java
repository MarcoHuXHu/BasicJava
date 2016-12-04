package Workshop4;

@SuppressWarnings(value="all")
public class BadBookingException extends Exception{
	public BadBookingException() { }
	public BadBookingException(String message) {super(message); } 
}
