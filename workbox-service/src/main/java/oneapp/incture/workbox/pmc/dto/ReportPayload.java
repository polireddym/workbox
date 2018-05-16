package oneapp.incture.workbox.pmc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReportPayload {
	private String reportName;
	private String fileFormate;

	/* UserProcessDetailRequestDto parameter */
	private String labelValue;
	private String processName;
	private String requestId;
	private String status;
	private String userId;
	private Integer page;

	/* TaskAeging parameter */
	private String userGroup;
	private List<String> usersList;

	private String graphType;

	/* ProcessByDuration */
	private Integer startDayFrom;
	private Integer startDayTo;
	
	/* Completed Task Parameters */
	private String completedAt;
	private String createdBy;
	private String createdAt;
	private Integer skipCount;
	private Integer maxCount;
	private String period;
	
	
	private List<ReportAgingDto> reportAgingDtos;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getFileFormate() {
		return fileFormate;
	}

	public void setFileFormate(String fileFormate) {
		this.fileFormate = fileFormate;
	}

	public String getGraphType() {
		return graphType;
	}

	public void setGraphType(String graphType) {
		this.graphType = graphType;
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public List<String> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<String> usersList) {
		this.usersList = usersList;
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
	
	public List<ReportAgingDto> getReportAgingDtos() {
		return reportAgingDtos;
	}

	public void setReportAgingDtos(List<ReportAgingDto> reportAgingDtos) {
		this.reportAgingDtos = reportAgingDtos;
	}
	
	/* Completed Task Report Getters and Setters*/

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getSkipCount() {
		return skipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.skipCount = skipCount;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}
	
	public String getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(String completedAt) {
		this.completedAt = completedAt;
	}
	
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "ReportPayload [reportName=" + reportName + ", fileFormate=" + fileFormate + ", labelValue=" + labelValue + ", processName=" + processName + ", requestId=" + requestId + ", status="
				+ status + ", userId=" + userId + ", page=" + page + ", userGroup=" + userGroup + ", usersList=" + usersList + ", graphType=" + graphType + ", startDayFrom=" + startDayFrom
				+ ", startDayTo=" + startDayTo + "]";
	}

}
