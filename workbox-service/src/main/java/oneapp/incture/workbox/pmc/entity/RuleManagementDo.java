package oneapp.incture.workbox.pmc.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import oneapp.incture.workbox.poadapter.entity.BaseDo;

/**
 * Entity implementation class for Entity: RuleManagementDo
 *
 */
@Entity
@SqlResultSetMappings({
	@SqlResultSetMapping(name = "ProcessRules", columns = { @ColumnResult(name = "RULE_ID"),
			@ColumnResult(name = "TYPE"), @ColumnResult(name = "PROCESS_NAME"),
			@ColumnResult(name = "THRESHOLD_LIMIT"), @ColumnResult(name = "ACTION"), @ColumnResult(name = "STATUS"),
			@ColumnResult(name = "TASK_NAME"), @ColumnResult(name = "SLA"),@ColumnResult(name = "PROCESS_DISPLAY_NAME"), @ColumnResult(name = "EMAIL_ID"), @ColumnResult(name = "EMAIL_SUBJECT"), @ColumnResult(name = "EMAIL_BODY") }),
	@SqlResultSetMapping(name = "TaskRules", columns = { @ColumnResult(name = "RULE_ID"),
			@ColumnResult(name = "TYPE"), @ColumnResult(name = "PROCESS_NAME"),
			@ColumnResult(name = "THRESHOLD_LIMIT"), @ColumnResult(name = "ACTION"), @ColumnResult(name = "STATUS"),
			@ColumnResult(name = "TASK_NAME"), @ColumnResult(name = "SLA"), @ColumnResult(name = "SLA_ID"), @ColumnResult(name = "EMAIL_ID"), @ColumnResult(name = "EMAIL_SUBJECT"), @ColumnResult(name = "EMAIL_BODY") }) })
@Table(name = "RULE_TB")
public class RuleManagementDo implements BaseDo, Serializable {

	private static final long serialVersionUID = 1L;

	public RuleManagementDo() {
		super();
	}

	@Id
	@Column(name = "RULE_ID", length = 80)
	private String ruleId = UUID.randomUUID().toString().replaceAll("-", "");

	@Column(name = "TYPE", length = 20)
	private String type;

	@Column(name = "THRESHOLD_LIMIT", length = 20)
	private String thresholdLimit;

	@Column(name = "PROCESS_NAME", length = 255)
	private String name;

	@Column(name = "TASK_NAME", length = 255)
	private String taskName;

	@Column(name = "ACTION", length = 255)
	private String action;

	@Column(name = "STATUS", length = 20)
	private String status;

	@Column(name = "EMAIL_ID", length = 300)
	private String emailIdList;

	@Column(name = "EMAIL_SUBJECT", length = 2000)
	private String emailSubject;

	@Column(name = "EMAIL_BODY", length = 300)
	private String emailBody;

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

	public String getThresholdLimit() {
		return thresholdLimit;
	}

	public void setThresholdLimit(String thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
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

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "RuleManagementDo [ruleId=" + ruleId + ", type=" + type + ", thresholdLimit=" + thresholdLimit
				+ ", name=" + name + ", taskName=" + taskName + ", action=" + action + ", status=" + status
				+ ", emailIdList=" + emailIdList + ", emailSubject=" + emailSubject + ", emailBody=" + emailBody + "]";
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return ruleId;
	}

}
