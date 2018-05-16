package oneapp.incture.workbox.util;

/**
 * <code>ExecutionException</code> is wrapper over different kinds of
 * exceptions, generally indicate a fatal error eg: resource missing, data
 * source connection failed
 * 
 * @version 1, 04-April-2017
 * @since PMC
 */
public class ExecutionFault extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 627683056372690666L;
	/**
	 * Java type that goes as soapenv:Fault detail element.
	 */
	private MessageUIDto faultInfo;

	public ExecutionFault() {
		// TODO Auto-generated constructor stub
	}

	public ExecutionFault(String faultMessage) {
		super(faultMessage);
//		super("Execution on Server failed, please retry later");
		faultInfo = new MessageUIDto();
		faultInfo.setMessage(faultMessage);
	}

	public ExecutionFault(String message, MessageUIDto faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public ExecutionFault(String message, MessageUIDto faultInfo,
			Throwable cause) {
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	public MessageUIDto getFaultInfo() {
		return faultInfo;
	}
}