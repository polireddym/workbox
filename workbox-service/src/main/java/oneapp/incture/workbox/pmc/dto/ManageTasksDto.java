package oneapp.incture.workbox.pmc.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ManageTasksDto {

	private String requestId;

	private String processName;

	private Date createdDate;
	
	private String createdDateInString;

	private String openSinceinHrs;

	private String taskSubject;

	private String owners;

	private String status;

	private String eventId;

	private String processDisplayName;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getOpenSinceinHrs() {
		return openSinceinHrs;
	}

	public void setOpenSinceinHrs(String openSinceinHrs) {
		this.openSinceinHrs = openSinceinHrs;
	}

	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	public String getCreatedDateInString() {
		return createdDateInString;
	}

	public void setCreatedDateInString(String createdDateInString) {
		this.createdDateInString = createdDateInString;
	}

	@Override
	public String toString() {
		return "ManageTasksDto [requestId=" + requestId + ", processName=" + processName + ", createdDate="
				+ createdDate + ", createdDateInString=" + createdDateInString + ", openSinceinHrs=" + openSinceinHrs
				+ ", taskSubject=" + taskSubject + ", owners=" + owners + ", status=" + status + ", eventId=" + eventId
				+ ", processDisplayName=" + processDisplayName + "]";
	}
}
