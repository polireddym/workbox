package oneapp.incture.workbox.pmc.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdminControlDto {

	private List<ProcessConfigDto> processConfigDtos;
	private List<WorkloadRangeDto> workloadRangeDtos;
	private List<ReportDto> reportDto;
	private List<AgingRangeConfigDto> agingRangeConfigDto;
	private Integer processCount;
	private Integer taskCount;
	private Integer taskStatusCount;
	
	@Override
	public String toString() {
		return "AdminControlDto [processConfigDtos=" + processConfigDtos + ", workloadRangeDtos=" + workloadRangeDtos
				+ ", reportDto=" + reportDto + ", agingRangeConfigDto=" + agingRangeConfigDto + ", processCount="
				+ processCount + ", taskCount=" + taskCount + ", taskStatusCount=" + taskStatusCount + "]";
	}
	/**
	 * @return the processConfigDtos
	 */
	public List<ProcessConfigDto> getProcessConfigDtos() {
		return processConfigDtos;
	}
	/**
	 * @param processConfigDtos the processConfigDtos to set
	 */
	public void setProcessConfigDtos(List<ProcessConfigDto> processConfigDtos) {
		this.processConfigDtos = processConfigDtos;
	}
	/**
	 * @return the workloadRangeDtos
	 */
	public List<WorkloadRangeDto> getWorkloadRangeDtos() {
		return workloadRangeDtos;
	}
	/**
	 * @param workloadRangeDtos the workloadRangeDtos to set
	 */
	public void setWorkloadRangeDtos(List<WorkloadRangeDto> workloadRangeDtos) {
		this.workloadRangeDtos = workloadRangeDtos;
	}
	
	
	/**
	 * @return the agingRangeConfigDto
	 */
	public List<AgingRangeConfigDto> getAgingRangeConfigDto() {
		return agingRangeConfigDto;
	}
	/**
	 * @param agingRangeConfigDto the agingRangeConfigDto to set
	 */
	public void setAgingRangeConfigDto(List<AgingRangeConfigDto> agingRangeConfigDto) {
		this.agingRangeConfigDto = agingRangeConfigDto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * @return the processCount
	 */
	public Integer getProcessCount() {
		return processCount;
	}
	/**
	 * @param processCount the processCount to set
	 */
	public void setProcessCount(Integer processCount) {
		this.processCount = processCount;
	}
	/**
	 * @return the taskCount
	 */
	public Integer getTaskCount() {
		return taskCount;
	}
	/**
	 * @param taskCount the taskCount to set
	 */
	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}
	/**
	 * @return the taskStatusCount
	 */
	public Integer getTaskStatusCount() {
		return taskStatusCount;
	}
	/**
	 * @param taskStatusCount the taskStatusCount to set
	 */
	public void setTaskStatusCount(Integer taskStatusCount) {
		this.taskStatusCount = taskStatusCount;
	}
	public List<ReportDto> getReportDto() {
		return reportDto;
	}
	public void setReportDto(List<ReportDto> reportDto) {
		this.reportDto = reportDto;
	}
	
	
	
	
}
