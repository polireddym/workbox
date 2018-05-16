package oneapp.incture.workbox.inbox.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.incture.pmc.poadapter.services.CustomAttributeDto;

@XmlRootElement
public class WorkBoxDto {
	private String requestId;
	private String processName;
	private String name;
	private String subject;
	private String startedBy;
	private String createdAt;
	private String completedAt;
	private String status;
	private String taskOwner;
	private String taskId;
	private String processId;
	private String taskDescription;
	private String detailURL;
	private float timePercentCompleted;
	private String timeLeftDisplayString;
	private boolean isBreached;
	private String slaDisplayDate;
	private String sla;
	private String url;
	private CustomAttributeDto customAttributes;
	/* this attribute is added for setting sla due date*/
	private String slaDueDate;
	
	/* Forwarded At And Forwarded By Added */
	private String forwardedBy;
	private String forwardedAt;
	
	/* Process Display Name */
	private String processDisplayName;


	public String getSlaDueDate() {
		return slaDueDate;
	}

	public void setSlaDueDate(String slaDueDate) {
		this.slaDueDate = slaDueDate;
	}

	public CustomAttributeDto getCustomAttributes() {
		return customAttributes;
	}

	public void setCustomAttributes(CustomAttributeDto customAttributes) {
		this.customAttributes = customAttributes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isBreached() {
		return isBreached;
	}

	public void setBreached(boolean isBreached) {
		this.isBreached = isBreached;
	}

	public String getSlaDisplayDate() {
		return slaDisplayDate;
	}

	public void setSlaDisplayDate(String slaDisplayDate) {
		this.slaDisplayDate = slaDisplayDate;
	}

	public String getDetailURL() {
		return detailURL;
	}

	public void setDetailURL(String detailURL) {
		this.detailURL = detailURL;
	}


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

	public String getStartedBy() {
		return startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(String completedAt) {
		this.completedAt = completedAt;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getTimeLeftDisplayString() {
		return timeLeftDisplayString;
	}

	public void setTimeLeftDisplayString(String timeLeftDisplayString) {
		this.timeLeftDisplayString = timeLeftDisplayString;
	}

	public float getTimePercentCompleted() {
		return timePercentCompleted;
	}

	public void setTimePercentCompleted(float timePercentCompleted) {
		this.timePercentCompleted = timePercentCompleted;
	}

	public String getForwardedBy() {
		return forwardedBy;
	}

	public void setForwardedBy(String forwardedBy) {
		this.forwardedBy = forwardedBy;
	}

	public String getForwardedAt() {
		return forwardedAt;
	}

	public void setForwardedAt(String forwardedAt) {
		this.forwardedAt = forwardedAt;
	}

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	@Override
	public String toString() {
		return "WorkBoxDto [requestId=" + requestId + ", processName=" + processName + ", name=" + name + ", subject="
				+ subject + ", startedBy=" + startedBy + ", createdAt=" + createdAt + ", completedAt=" + completedAt
				+ ", status=" + status + ", taskOwner=" + taskOwner + ", taskId=" + taskId + ", processId=" + processId
				+ ", taskDescription=" + taskDescription + ", detailURL=" + detailURL + ", timePercentCompleted="
				+ timePercentCompleted + ", timeLeftDisplayString=" + timeLeftDisplayString + ", isBreached="
				+ isBreached + ", slaDisplayDate=" + slaDisplayDate + ", sla=" + sla + ", url=" + url + ", slaDueDate="
				+ slaDueDate + ", forwardedBy=" + forwardedBy + ", forwardedAt=" + forwardedAt + ", processDisplayName="
				+ processDisplayName + "]";
	}

	
}
