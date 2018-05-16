package oneapp.incture.workbox.poadapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ProcessEventsDo
 *
 */
@Entity
@SqlResultSetMappings({
		@SqlResultSetMapping(name = "TaskOwnersListResult", columns = { @ColumnResult(name = "OWNER"),
				@ColumnResult(name = "OWNER_NAME") }),
		@SqlResultSetMapping(name = "TaskOwnersTaskCountResult", columns = { @ColumnResult(name = "OWNER"),
				@ColumnResult(name = "TASK_COUNT"), @ColumnResult(name = "OWNER_NAME") }),
		@SqlResultSetMapping(name = "TaskAgingCountResult", columns = { @ColumnResult(name = "OWNER"),
				@ColumnResult(name = "DATE_RANGE"), @ColumnResult(name = "TASK_COUNT") ,@ColumnResult(name = "OWNER_NAME")}),
		@SqlResultSetMapping(name = "taskOwnersResults", columns = { @ColumnResult(name = "TASK_OWNER"),
				@ColumnResult(name = "EVENT_ID")}),
		@SqlResultSetMapping(name = "getEmailsResult", columns = { @ColumnResult(name = "EMAILS")}) 
})

@Table(name = "TASK_OWNERS")
public class TaskOwnersDo implements BaseDo, Serializable {

	/**
	 * 
	 */
	public TaskOwnersDo() {
		super();
	}

	private static final long serialVersionUID = 8966817427208717661L;

	@EmbeddedId
	private TaskOwnersDoPK taskOwnersDoPK;

	@Column(name = "IS_PROCESSED")
	private Boolean isProcessed;
	
	@Column(name = "IS_SUBSTITUTED")
	private Boolean isSubstituted;
	
	@Column(name = "TASK_OWNER_DISP", length = 100)
	private String taskOwnerDisplayName;
	
	@Column(name = "TASK_OWNER_EMAIL", length = 60)
	private String ownerEmail;

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public TaskOwnersDoPK getTaskOwnersDoPK() {
		return taskOwnersDoPK;
	}

	public void setTaskOwnersDoPK(TaskOwnersDoPK taskOwnersDoPK) {
		this.taskOwnersDoPK = taskOwnersDoPK;
	}

	public Boolean getIsProcessed() {
		return isProcessed;
	}

	public void setIsProcessed(Boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	public Boolean getIsSubstituted() {
		return isSubstituted;
	}

	public void setIsSubstituted(Boolean isSubstituted) {
		this.isSubstituted = isSubstituted;
	}


	@Override
	public String toString() {
		return "TaskOwnersDo [taskOwnersDoPK=" + taskOwnersDoPK + ", isProcessed=" + isProcessed + ", isSubstituted="
				+ isSubstituted + ", taskOwnerDisplayName=" + taskOwnerDisplayName + ", ownerEmail=" + ownerEmail + "]";
	}

	public String getTaskOwnerDisplayName() {
		return taskOwnerDisplayName;
	}

	public void setTaskOwnerDisplayName(String taskOwnerDisplayName) {
		this.taskOwnerDisplayName = taskOwnerDisplayName;
	}

	@Override
	public Object getPrimaryKey() {
		return taskOwnersDoPK;
	}

}
