package hellofood.exceptions;

@SuppressWarnings("serial")
public class ReservationFailureException extends Exception{

	public ReservationFailureException() {
		super();
	}

	public ReservationFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ReservationFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReservationFailureException(String message) {
		super(message);
	}

	public ReservationFailureException(Throwable cause) {
		super(cause);
	}
	
	
	

}
