package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskNameDto{
	
	private String taskName;
	private String slaUnit;
	private String slaCount;


	public String getSlaUnit() {
		return slaUnit;
	}


	public void setSlaUnit(String slaUnit) {
		this.slaUnit = slaUnit;
	}


	public String getSlaCount() {
		return slaCount;
	}


	public void setSlaCount(String slaCount) {
		this.slaCount = slaCount;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	@Override
	public String toString() {
		return "TaskNameDto [taskName=" + taskName + ", slaUnit=" + slaUnit + ", slaCount=" + slaCount + "]";
	}




}
