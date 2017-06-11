package hellofood.exceptions;

@SuppressWarnings("serial")
public class DateReservationException  extends Exception{

	public DateReservationException() {
		super();
	}

	public DateReservationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DateReservationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateReservationException(String message) {
		super(message);
	}

	public DateReservationException(Throwable cause) {
		super(cause);
	}
	
	
	

}
