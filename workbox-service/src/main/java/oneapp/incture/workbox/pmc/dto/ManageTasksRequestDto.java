package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ManageTasksRequestDto {

	private String owner;

	private String taskStatus;

	private String processName;

	private Integer startDayFrom;

	private Integer startDayTo;

	private Integer page;

	private String requestId;

	private String labelValue;

	public ManageTasksRequestDto() {
	}

	public ManageTasksRequestDto(String owner, String taskStatus, String processName, Integer startDayFrom, Integer startDayTo, Integer page, String requestId, String labelValue) {
		super();
		this.owner = owner;
		this.taskStatus = taskStatus;
		this.processName = processName;
		this.startDayFrom = startDayFrom;
		this.startDayTo = startDayTo;
		this.page = page;
		this.requestId = requestId;
		this.labelValue = labelValue;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

	@Override
	public String toString() {
		return "ManageTasksRequestDto [owner=" + owner + ", taskStatus=" + taskStatus + ", processName=" + processName + ", startDayFrom=" + startDayFrom + ", startDayTo=" + startDayTo + ", page="
				+ page + ", requestId=" + requestId + ", labelValue=" + labelValue + "]";
	}

}
