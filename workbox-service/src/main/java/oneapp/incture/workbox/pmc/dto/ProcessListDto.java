package oneapp.incture.workbox.pmc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcessListDto {
	List<String> processNameList;

	public List<String> getProcessNameList() {
		return processNameList;
	}

	public void setProcessNameList(List<String> processNameList) {
		this.processNameList = processNameList;
	}

	@Override
	public String toString() {
		return "ProcessListDto [processNameList=" + processNameList + "]";
	}

}
