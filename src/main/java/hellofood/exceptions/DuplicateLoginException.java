package hellofood.exceptions;

@SuppressWarnings("serial")
public class DuplicateLoginException extends Exception {

	public DuplicateLoginException() {
		super();
	}

	public DuplicateLoginException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateLoginException(String message) {
		super(message);
	}

	public DuplicateLoginException(Throwable cause) {
		super(cause);
	}

}
