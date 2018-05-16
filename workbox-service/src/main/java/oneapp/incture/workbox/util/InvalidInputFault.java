package oneapp.incture.workbox.util;


/**
 * <code>InvalidInputFault</code> is to indicate application that the parameters
 * passed to the method is invalid w.r.t its implementation.
 * 
 * @version 1, 05-April-2017
 * @since PMC
 */
public class InvalidInputFault extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5879608670346636459L;
	private MessageUIDto faultInfo;

	public InvalidInputFault() {
		// TODO Auto-generated constructor stub
	}

	public InvalidInputFault(String faultMessage) {
		super(faultMessage);
		faultInfo = new MessageUIDto();
		faultInfo.setMessage(faultMessage);
	}
	
	public InvalidInputFault(String message, MessageUIDto faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public InvalidInputFault(String message, MessageUIDto faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public MessageUIDto getFaultInfo() {
		return faultInfo;
	}
}