package oneapp.incture.workbox.pmc.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SlaListDto{
	
	private String processName;
	private String noOfInstances;
	private List<SlaManagementDto> slaList;
	private String slaCount;
	private String slaUnit;
	private String slaCountOld;
	private String slaUnitOld;
	private String processDisplayName;
	
	public String getProcessDisplayName() {
		return processDisplayName;
	}
	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}
	public String getSlaCountOld() {
		return slaCountOld;
	}
	public void setSlaCountOld(String slaCountOld) {
		this.slaCountOld = slaCountOld;
	}
	public String getSlaUnitOld() {
		return slaUnitOld;
	}
	public void setSlaUnitOld(String slaUnitOld) {
		this.slaUnitOld = slaUnitOld;
	}
	private Boolean isUpdated;
	private Integer slaId;
	
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getNoOfInstances() {
		return noOfInstances;
	}
	public void setNoOfInstances(String noOfInstances) {
		this.noOfInstances = noOfInstances;
	}
	public List<SlaManagementDto> getSlaList() {
		return slaList;
	}
	public void setSlaList(List<SlaManagementDto> slaList) {
		this.slaList = slaList;
	}
	public String getSlaCount() {
		return slaCount;
	}
	public void setSlaCount(String slaCount) {
		this.slaCount = slaCount;
	}
	public String getSlaUnit() {
		return slaUnit;
	}
	public void setSlaUnit(String slaUnit) {
		this.slaUnit = slaUnit;
	}
	public Boolean getIsUpdated() {
		return isUpdated;
	}
	public void setIsUpdated(Boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	public Integer getSlaId() {
		return slaId;
	}
	public void setSlaId(Integer slaId) {
		this.slaId = slaId;
	}
	@Override
	public String toString() {
		return "SlaListDto [processName=" + processName + ", noOfInstances=" + noOfInstances + ", slaList=" + slaList
				+ ", slaCount=" + slaCount + ", slaUnit=" + slaUnit + ", slaCountOld=" + slaCountOld + ", slaUnitOld="
				+ slaUnitOld + ", processDisplayName=" + processDisplayName + ", isUpdated=" + isUpdated + ", slaId="
				+ slaId + "]";
	}
	



	
}
