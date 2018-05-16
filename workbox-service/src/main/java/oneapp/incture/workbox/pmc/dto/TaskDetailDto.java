package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskDetailDto {

	private String userId;
	
	private Integer startDayFrom;
	
	private Integer startDayTo;
	
	private String status;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStartDayFrom() {
		return startDayFrom;
	}

	public void setStartDayFrom(Integer startDayFrom) {
		this.startDayFrom = startDayFrom;
	}

	public Integer getStartDayTo() {
		return startDayTo;
	}

	public void setStartDayTo(Integer startDayTo) {
		this.startDayTo = startDayTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskDetailDto [userId=" + userId + ", startDayFrom=" + startDayFrom + ", startDayTo=" + startDayTo + ", status=" + status + "]";
	}

	
}
