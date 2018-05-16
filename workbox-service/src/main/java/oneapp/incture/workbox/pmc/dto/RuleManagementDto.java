package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class RuleManagementDto extends BaseDto {

	private String ruleId;
	private String type;
	private String name;
	private String thresholdLimitUnit;
	private String thresholdLimitCount;
	private String action;
	private String status;
	private String thresholdUnitOld; 
	private String thresholdCountOld; 
	private String actionOld;
	private String statusOld;
	private String change;
	private String taskName;
	private String slaUnit;
	private String slaCount;
	private String slaId;
	private String emailIdList;
	private String emailSubject;
	private String emailBody;
	private String processDisplayName;
	
	
	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	public String getEmailIdList() {
		return emailIdList;
	}

	public void setEmailIdList(String emailIdList) {
		this.emailIdList = emailIdList;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getThresholdLimitUnit() {
		return thresholdLimitUnit;
	}

	public void setThresholdLimitUnit(String thresholdLimitUnit) {
		this.thresholdLimitUnit = thresholdLimitUnit;
	}

	public String getThresholdLimitCount() {
		return thresholdLimitCount;
	}

	public void setThresholdLimitCount(String thresholdLimitCount) {
		this.thresholdLimitCount = thresholdLimitCount;
	}
	public String getThresholdUnitOld() {
		return thresholdUnitOld;
	}

	public void setThresholdUnitOld(String thresholdUnitOld) {
		this.thresholdUnitOld = thresholdUnitOld;
	}

	public String getThresholdCountOld() {
		return thresholdCountOld;
	}

	public void setThresholdCountOld(String thresholdCountOld) {
		this.thresholdCountOld = thresholdCountOld;
	}

	public String getActionOld() {
		return actionOld;
	}

	public void setActionOld(String actionOld) {
		this.actionOld = actionOld;
	}

	public String getStatusOld() {
		return statusOld;
	}

	public void setStatusOld(String statusOld) {
		this.statusOld = statusOld;
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
	
	@Override
	public String toString() {
		return "RuleManagementDto [ruleId=" + ruleId + ", type=" + type + ", name=" + name + ", thresholdLimitUnit="
				+ thresholdLimitUnit + ", thresholdLimitCount=" + thresholdLimitCount + ", action=" + action
				+ ", status=" + status + ", thresholdUnitOld=" + thresholdUnitOld + ", thresholdCountOld="
				+ thresholdCountOld + ", actionOld=" + actionOld + ", statusOld=" + statusOld + ", change=" + change
				+ ", taskName=" + taskName + ", slaUnit=" + slaUnit + ", slaCount=" + slaCount + ", slaId=" + slaId
				+ ", emailIdList=" + emailIdList + ", emailSubject=" + emailSubject + ", emailBody=" + emailBody
				+ ", processDisplayName=" + processDisplayName + "]";
	}

	public String getSlaId() {
		return slaId;
	}

	public void setSlaId(String slaId) {
		this.slaId = slaId;
	}

}
