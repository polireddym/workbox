package oneapp.incture.workbox.pmc.entity;

import java.io.Serializable;

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
@Table(name = "PROCESS_STEPS")
public class ProcessStepsDo implements BaseDo, Serializable {

	private static final long serialVersionUID = 1L;

	public ProcessStepsDo() {
		super();
	}

	@Id
	@Column(name = "PROCESS_ID")
	private Integer processId;

	@Column(name = "TASK_STEP")
	private Integer taskStep;

	@Column(name = "PROCESS_NAME", length = 100)
	private String processName;

	@Column(name = "ACTIVITY_TYPE", length = 20)
	private String activityType;

	@Column(name = "SUBJECT", length = 250)
	private String subject;

	@Column(name = "DESCRIPTION", length = 1000)
	private String description;

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Integer getTaskStep() {
		return taskStep;
	}

	public void setTaskStep(Integer taskStep) {
		this.taskStep = taskStep;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
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

	@Override
	public String toString() {
		return "ProcessStepsDo [processId=" + processId + ", taskStep=" + taskStep + ", processName=" + processName + ", activityType=" + activityType + ", subject=" + subject + ", description="
				+ description + "]";
	}

	@Override
	public Object getPrimaryKey() {
		return processId;
	}

}
