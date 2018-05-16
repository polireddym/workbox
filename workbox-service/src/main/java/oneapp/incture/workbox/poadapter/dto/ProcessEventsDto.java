package oneapp.incture.workbox.poadapter.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class ProcessEventsDto extends BaseDto {
	private String processId;
	private String requestId;
	private String name;
	private String subject;
	private String status;
	private String startedBy;
	private Date startedAt;
	private Date completedAt;
	private String startedByUser;
	private String startedAtInString;
	private String completedAtInString;
	private String startedByDisplayName;
	private String processDisplayName;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartedBy() {
		return startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStartedByUser() {
		return startedByUser;
	}

	public void setStartedByUser(String startedByUser) {
		this.startedByUser = startedByUser;
	}

	public String getStartedAtInString() {
		return startedAtInString;
	}

	public void setStartedAtInString(String startedAtInString) {
		this.startedAtInString = startedAtInString;
	}

	public String getCompletedAtInString() {
		return completedAtInString;
	}

	public void setCompletedAtInString(String completedAtInString) {
		this.completedAtInString = completedAtInString;
	}

	public String getStartedByDisplayName() {
		return startedByDisplayName;
	}

	public void setStartedByDisplayName(String startedByDisplayName) {
		this.startedByDisplayName = startedByDisplayName;
	}

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	@Override
	public String toString() {
		return "ProcessEventsDto [processId=" + processId + ", requestId=" + requestId + ", name=" + name + ", subject=" + subject + ", status=" + status + ", startedBy=" + startedBy + ", startedAt="
				+ startedAt + ", completedAt=" + completedAt + ", startedByUser=" + startedByUser + ", startedAtInString=" + startedAtInString + ", completedAtInString=" + completedAtInString
				+ ", startedByDisplayName=" + startedByDisplayName + "]";
	}

	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {
		// TODO Auto-generated method stub

	}

}
