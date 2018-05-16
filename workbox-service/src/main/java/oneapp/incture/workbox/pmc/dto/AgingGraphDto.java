package oneapp.incture.workbox.pmc.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AgingGraphDto{
	private String processDisplayName;
	private String processName;
	private BigDecimal noOfProcess;
	private String range;

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public BigDecimal getNoOfProcess() {
		return noOfProcess;
	}

	public void setNoOfProcess(BigDecimal noOfProcess) {
		this.noOfProcess = noOfProcess;
	}
	
	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	@Override
	public String toString() {
		return "AgingGraphDto [processName=" + processName + ", noOfProcess=" + noOfProcess + ", range=" + range + "]";
	}
}
