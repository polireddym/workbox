package oneapp.incture.workbox.pmc.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oneapp.incture.workbox.poadapter.entity.BaseDo;

/**
 * Entity implementation class for Entity: ProcessEventsDo
 *
 */
@Entity
@Table(name = "PROCESS_CONFIG_TB")
public class ProcessConfigDo implements BaseDo, Serializable {

	

	private static final long serialVersionUID = 1L;

	public ProcessConfigDo() {
		super();
	}

	@Id
	@Column(name = "PROCESS_NAME", length = 100)
	private String processName;

	@Column(name = "LABEL_NAME", length = 100)
	private String labelName;
	
	@Column(name = "USER_ROLE", length = 1000)
	private String userRole;
	
	@Column(name = "SLA", length = 20)
	private String sla;
	
	@Column(name = "URGENT_SLA", length = 20)
	private String urgentSla;
	
	@Column(name = "PROCESS_DISPLAY_NAME", length = 100)
	private String processDisplayName;
	
	@Column(name = "USER_GROUP", length = 1000)
	private String userGroup;
	
	@Column(name = "PROCESS_CONFIG_ID", length = 50)
	private String processConfigId =UUID.randomUUID().toString().replaceAll("-", "");
	
	@Column(name = "PROCESS_SUBJECT", length = 250)
	private String subject;
	
	@Column(name = "PROCESS_DESC", length = 250)
	private String description;
	
	@Column(name = "LANE_COUNT")
	private Integer laneCount;

	public String getProcessConfigId() {
		return processConfigId;
	}

	public void setProcessConfigId(String processConfigId) {
		this.processConfigId = processConfigId;
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

	public Integer getLaneCount() {
		return laneCount;
	}

	public void setLaneCount(Integer laneCount) {
		this.laneCount = laneCount;
	}

	
	
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
	
	public String getSla() {
		return sla;
	}

	public void setSla(String sla) {
		this.sla = sla;
	}

	public String getUrgentSla() {
		return urgentSla;
	}

	public void setUrgentSla(String urgentSla) {
		this.urgentSla = urgentSla;
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


	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcessConfigDo [processName=" + processName + ", labelName=" + labelName + ", userRole=" + userRole
				+ ", sla=" + sla + ", urgentSla=" + urgentSla + ", processDisplayName=" + processDisplayName
				+ ", userGroup=" + userGroup + ", processConfigId=" + processConfigId + ", subject=" + subject
				+ ", description=" + description + ", laneCount=" + laneCount + "]";
	}

	@Override
	public Object getPrimaryKey() {
		return processName;
	}

}
