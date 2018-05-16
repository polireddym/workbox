package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class SlaManagementDto extends BaseDto {

	private String slaId;
	private String processName;
	private String taskType;
	private String modeName;
	private String subject;
	private String description;
	private String slaCount;
	private String slaUnit;
	private String urgentSlaUnit;
	private String urgentSlaCount;
	private String slaCountOld;
	private String slaUnitOld;
	private String urgentSlaUnitOld;
	private String urgentSlaCountOld;
	private String taskName;
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

	public String getUrgentSlaUnitOld() {
		return urgentSlaUnitOld;
	}

	public void setUrgentSlaUnitOld(String urgentSlaUnitOld) {
		this.urgentSlaUnitOld = urgentSlaUnitOld;
	}

	public String getUrgentSlaCountOld() {
		return urgentSlaCountOld;
	}

	public void setUrgentSlaCountOld(String urgentSlaCountOld) {
		this.urgentSlaCountOld = urgentSlaCountOld;
	}


	public String getSlaUnit() {
		return slaUnit;
	}

	public void setSlaUnit(String slaUnit) {
		this.slaUnit = slaUnit;
	}

	public String getUrgentSlaUnit() {
		return urgentSlaUnit;
	}

	public void setUrgentSlaUnit(String urgentSlaUnit) {
		this.urgentSlaUnit = urgentSlaUnit;
	}

	public String getSlaId() {
		return slaId;
	}

	public void setSlaId(String slaId) {
		this.slaId = slaId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSlaCount() {
		return slaCount;
	}

	public void setSlaCount(String slaCount) {
		this.slaCount = slaCount;
	}

	public String getUrgentSlaCount() {
		return urgentSlaCount;
	}

	public void setUrgentSlaCount(String urgentSlaCount) {
		this.urgentSlaCount = urgentSlaCount;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	
	@Override
	public String toString() {
		return "SlaManagementDto [slaId=" + slaId + ", processName=" + processName + ", taskType=" + taskType
				+ ", modeName=" + modeName + ", subject=" + subject + ", description=" + description + ", slaCount="
				+ slaCount + ", slaUnit=" + slaUnit + ", urgentSlaUnit=" + urgentSlaUnit + ", urgentSlaCount="
				+ urgentSlaCount + ", slaCountOld=" + slaCountOld + ", slaUnitOld=" + slaUnitOld + ", urgentSlaUnitOld="
				+ urgentSlaUnitOld + ", urgentSlaCountOld=" + urgentSlaCountOld + ", taskName=" + taskName
				+ ", processDisplayName=" + processDisplayName + "]";
	}

	@Override
	public Boolean getValidForUsage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {
		// TODO Auto-generated method stub
		
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


}
