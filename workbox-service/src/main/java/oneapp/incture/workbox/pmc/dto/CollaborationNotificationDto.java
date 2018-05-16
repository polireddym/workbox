package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CollaborationNotificationDto {

	private String processId;
	private String eventId;
	private String createdAt;
	private String message;
	private String taskSubject;
	public String getTaskSubject() {
		return taskSubject;
	}
	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "CollaborationNotificationDto [processId=" + processId + ", eventId=" + eventId + ", createdAt="
				+ createdAt + ", message=" + message + ", taskSubject=" + taskSubject + "]";
	}
	
	
	
	
}
