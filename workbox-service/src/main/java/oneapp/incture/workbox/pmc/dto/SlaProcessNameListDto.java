package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SlaProcessNameListDto{
	
	private String processName;
	private String processDisplayName;
	private Boolean slaExist;
	private String slaCount;
	private String slaUnit;


	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Boolean getSlaExist() {
		return slaExist;
	}

	public void setSlaExist(Boolean slaExist) {
		this.slaExist = slaExist;
	}

	@Override
	public String toString() {
		return "SlaProcessNameListDto [processName=" + processName + ", processDisplayName=" + processDisplayName
				+ ", slaExist=" + slaExist + ", slaCount=" + slaCount + ", slaUnit=" + slaUnit + "]";
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

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

}
