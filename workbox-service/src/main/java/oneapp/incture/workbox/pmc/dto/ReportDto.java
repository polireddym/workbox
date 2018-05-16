package oneapp.incture.workbox.pmc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReportDto {
	private String reportName;
	private List<ReportAgingDto> reportDtoList ;
	
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public List<ReportAgingDto> getReportDtoList() {
		return reportDtoList;
	}
	public void setReportDtoList(List<ReportAgingDto> reportDtoList) {
		this.reportDtoList = reportDtoList;
	}
	@Override
	public String toString() {
		return "DifferentReportDto [reportName=" + reportName + ", reportDtoList=" + reportDtoList + "]";
	}
	
}
