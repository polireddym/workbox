package oneapp.incture.workbox.inbox.dto;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class RequestIdListDto extends BaseDto{

	private String eventId;
	private String requestId;

	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	@Override
	public String toString() {
		return "RequestIdListDto [eventId=" + eventId + ", requestId=" + requestId + "]";
	}
	@Override
	public Boolean getValidForUsage() {
		return null;
	}
	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {
		
	}
	
	
}
