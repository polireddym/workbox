package oneapp.incture.workbox.util;

public class SecurityException  extends Exception {
	private static final long serialVersionUID = 1997753363232807009L;

	public SecurityException() {
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}
}
