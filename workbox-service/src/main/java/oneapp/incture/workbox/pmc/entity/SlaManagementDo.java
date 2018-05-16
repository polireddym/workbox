package oneapp.incture.workbox.pmc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import oneapp.incture.workbox.poadapter.entity.BaseDo;

/**
 * Entity implementation class for Entity: SlaManagementDo
 *
 */
@Entity
@SqlResultSetMappings({ 
	
	@SqlResultSetMapping(name = "SlaResults", columns = { @ColumnResult(name = "TASK_SLA_ID"), @ColumnResult(name = "PROC_NAME"), @ColumnResult(name = "TASK_DEF"),
		@ColumnResult(name = "TASK_MODE"), @ColumnResult(name = "TASK_TYPE"), @ColumnResult(name = "TASK_SUBJECT"), @ColumnResult(name = "TASK_DESC"), @ColumnResult(name = "SLA"),
		@ColumnResult(name = "URGENT_SLA"), @ColumnResult(name = "LANE") }), 
	@SqlResultSetMapping(name = "taskSLA", columns = { @ColumnResult(name = "SLA"), @ColumnResult(name = "URGENT_SLA") }),
	@SqlResultSetMapping(name = "ProcessConfigResults", columns = { @ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "PROCESS_DESC"), @ColumnResult(name = "LABEL_NAME"), @ColumnResult(name = "LANE_COUNT")
	, @ColumnResult(name = "PROCESS_CONFIG_ID"), @ColumnResult(name = "PROCESS_DISPLAY_NAME"), @ColumnResult(name = "SLA"), @ColumnResult(name = "PROCESS_SUBJECT")
	, @ColumnResult(name = "URGENT_SLA"), @ColumnResult(name = "USER_GROUP"), @ColumnResult(name = "USER_ROLE") }) })
@Table(name = "TASK_SLA")
public class SlaManagementDo implements BaseDo, Serializable {

	private static final long serialVersionUID = 1L;

	public SlaManagementDo() {
		super();
	}

	@Id
	@Column(name = "TASK_SLA_ID", length = 50)
	private String slaId;

	@Column(name = "PROC_NAME", length = 100)
	private String processName;

	@Column(name = "TASK_DEF", length = 100)
	private String taskName;

	@Column(name = "TASK_MODE", length = 50)
	private String modeName;

	@Column(name = "TASK_TYPE", length = 50)
	private String taskType;

	@Column(name = "TASK_SUBJECT", length = 250)
	private String subject;

	@Column(name = "TASK_DESC", length = 1000)
	private String description;

	@Column(name = "SLA", length = 20)
	private String sla;

	@Column(name = "URGENT_SLA", length = 20)
	private String urgentSla;
	
	@Column(name = "LANE")
	private int lane;

	public String getProcessName() {
		return processName;
	}

	public String getSlaId() {
		return slaId;
	}

	public void setSlaId(String slaId) {
		this.slaId = slaId;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
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
	
	public int getLane() {
		return lane;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}


	@Override
	public String toString() {
		return "SlaManagementDo [slaId=" + slaId + ", processName=" + processName + ", taskName=" + taskName
				+ ", modeName=" + modeName + ", taskType=" + taskType + ", subject=" + subject + ", description="
				+ description + ", sla=" + sla + ", urgentSla=" + urgentSla + ", lane=" + lane + "]";
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return slaId;
	}

}
