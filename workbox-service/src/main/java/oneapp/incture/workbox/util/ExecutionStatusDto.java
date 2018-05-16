package oneapp.incture.workbox.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExecutionStatusDto {

	private FaultStatus faultStatus;
	private String faultMessage;

	public FaultStatus getFaultStatus() {
		return faultStatus;
	}

	public void setFaultStatus(FaultStatus faultStatus) {
		this.faultStatus = faultStatus;
	}

	public String getFaultMessage() {
		return faultMessage;
	}

	public void setFaultMessage(String faultMessage) {
		this.faultMessage = faultMessage;
	}

}
