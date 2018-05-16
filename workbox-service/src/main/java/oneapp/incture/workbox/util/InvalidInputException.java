package oneapp.incture.workbox.util;

public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1997753363232807009L;

	public InvalidInputException() {
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

}
