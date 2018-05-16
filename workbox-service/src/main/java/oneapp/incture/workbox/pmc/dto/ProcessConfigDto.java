package oneapp.incture.workbox.pmc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class ProcessConfigDto extends BaseDto {

	private String processName;
	private String labelName;
	private String sla;
	private String urgentSla;
	private String processDisplayName;
	private String userGroup;
	private String userRole;
	//private String processConfigId;
	private String subject;
	private String description;
	private Integer laneCount;
	private String key ;
	private Boolean isDeleted;



	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/*private String processConfigId;
	 *//**
	 * @return the processConfigId
	 */
	/*public String getProcessConfigId() {
		return processConfigId;
	}

	 *//**
	 * @param processConfigId the processConfigId to set
	 *//*
	public void setProcessConfigId(String processConfigId) {
		this.processConfigId = processConfigId;
	}*/

	List<String> userList;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getUrgentSla() {
		return urgentSla;
	}

	public void setUrgentSla(String urgentSla) {
		this.urgentSla = urgentSla;
	}

	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the laneCount
	 */
	public Integer getLaneCount() {
		return laneCount;
	}

	/**
	 * @param laneCount the laneCount to set
	 */
	public void setLaneCount(Integer laneCount) {
		this.laneCount = laneCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ProcessConfigDto [processName=" + processName + ", labelName=" + labelName + ", sla=" + sla
				+ ", urgentSla=" + urgentSla + ", processDisplayName=" + processDisplayName + ", userGroup=" + userGroup
				+ ", userRole=" + userRole + ", subject=" + subject + ", description=" + description + ", laneCount="
				+ laneCount + ", key=" + key + ", isDeleted=" + isDeleted + ", userList=" + userList + "]";
	}

	@Override
	public Boolean getValidForUsage() {
		return null;
	}

	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
