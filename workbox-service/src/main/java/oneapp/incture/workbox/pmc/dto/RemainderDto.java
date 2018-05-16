package oneapp.incture.workbox.pmc.dto;

public class RemainderDto {
	
	private String id;
	private String startedAt;
	private String sla;
	private String jobName;
	private String threshold;
	private String action;
	private String emailIds;
	private String emailSub;
	private String emailBody;
	private String status;
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String processId) {
		this.id = processId;
	}

	public String getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(String startedAt) {
		this.startedAt = startedAt;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String processName) {
		this.jobName = processName;
	}

	public String getThreshold() {
		return threshold;
	}

	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(String emailId) {
		this.emailIds = emailId;
	}

	public String getEmailSub() {
		return emailSub;
	}

	public void setEmailSub(String emailSub) {
		this.emailSub = emailSub;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RemainderDto [id=" + id + ", startedAt=" + startedAt + ", sla=" + sla + ", jobName=" + jobName
				+ ", threshold=" + threshold + ", action=" + action + ", emailIds=" + emailIds + ", emailSub="
				+ emailSub + ", emailBody=" + emailBody + ", status=" + status + ", userId=" + userId + "]";
	}

}
