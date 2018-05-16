package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcessDetailsDto {

	private String processName;

	private Integer startDayFrom;

	private Integer startDayTo;
	private Integer page;

	ProcessDetailsDto() {
	}

	public ProcessDetailsDto(String processName, Integer startDayFrom, Integer startDayTo, Integer page) {
		this.processName = processName;
		this.page = page;
		this.startDayFrom = startDayFrom;
		this.startDayTo = startDayTo;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
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

	@Override
	public String toString() {
		return "ProcessDetailsDto [processName=" + processName + ", startDayFrom=" + startDayFrom + ", startDayTo=" + startDayTo + ", page=" + page + "]";
	}

}
