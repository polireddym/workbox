package oneapp.incture.workbox.poadapter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: ProcessEventsDo
 *
 */
@Entity
@SqlResultSetMappings({ @SqlResultSetMapping(name = "ProcessCountResults", columns = { @ColumnResult(name = "PROCESS_COUNT") }),
		@SqlResultSetMapping(name = "getProcessRemainderDetails", columns = { @ColumnResult(name = "PROCESS_ID"), @ColumnResult(name = "STARTED_AT"), @ColumnResult(name = "SLA"),
			@ColumnResult(name = "THRESHOLD"), @ColumnResult(name = "ACTION"), @ColumnResult(name = "EMAIL_ID"), @ColumnResult(name = "EMAIL_SUB"), @ColumnResult(name = "EMAIL_BODY"),
			@ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "STARTED_BY") }),
		@SqlResultSetMapping(name = "ProcessResults", columns = { @ColumnResult(name = "PROCESS_ID"), @ColumnResult(name = "STARTED_AT"), @ColumnResult(name = "STARTED_BY"),
				@ColumnResult(name = "SUBJECT"), @ColumnResult(name = "REQUEST_ID"), @ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "STARTED_BY_DISP"),
				@ColumnResult(name = "PROCESS_DISPLAY_NAME"), @ColumnResult(name = "R_NUM") }),
		@SqlResultSetMapping(name = "processAgingResult", columns = { @ColumnResult(name = "DATE_RANGE"), @ColumnResult(name = "PROCESS_COUNT"), @ColumnResult(name = "PROCESS_NAME"),
				@ColumnResult(name = "PROCESS_DISPLAY_NAME") }),
		@SqlResultSetMapping(name = "processAgingWeekResult", columns = { @ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "PROCESS_COUNT"), @ColumnResult(name = "STARTED_DATE"),
				@ColumnResult(name = "PROCESS_DISPLAY_NAME") }),
		@SqlResultSetMapping(name = "workBoxResults", columns = { @ColumnResult(name = "REQUEST_ID"), @ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "TASK_ID"),
				@ColumnResult(name = "DESCRIPTION"), @ColumnResult(name = "TASK_NAME"), @ColumnResult(name = "TASK_SUBJECT"), @ColumnResult(name = "STARTED_BY"),
				@ColumnResult(name = "TASK_CREATED_AT"), @ColumnResult(name = "TASK_STATUS"), @ColumnResult(name = "CUR_PROC"), @ColumnResult(name = "SLA"), @ColumnResult(name = "PROCESS_ID"), 
				@ColumnResult(name = "URL"), @ColumnResult(name = "SLA_DUE_DATE"), @ColumnResult(name = "FORWARDED_BY"), @ColumnResult(name = "FORWARDED_AT"), @ColumnResult(name = "PROCESS_DISPLAY_NAME")  }),
		@SqlResultSetMapping(name = "workBoxCompletedResults", columns = { @ColumnResult(name = "REQUEST_ID"), @ColumnResult(name = "PROCESS_NAME"), @ColumnResult(name = "TASK_ID"), 
				@ColumnResult(name = "DESCRIPTION"), @ColumnResult(name = "TASK_NAME"), @ColumnResult(name = "TASK_SUBJECT"), @ColumnResult(name = "STARTED_BY"),
				@ColumnResult(name = "TASK_CREATED_AT"), @ColumnResult(name = "TASK_STATUS"), @ColumnResult(name = "CUR_PROC") , @ColumnResult(name = "COMPLETED_AT"), @ColumnResult(name = "PROCESS_ID"), @ColumnResult(name = "SLA_DATE"), @ColumnResult(name = "DISP_NAME") }),
		@SqlResultSetMapping(name = "workBoxCountResult", columns = { @ColumnResult(name = "COUNT") }),
		@SqlResultSetMapping(name = "processByDuration", columns = { @ColumnResult(name = "REQUEST_ID"), @ColumnResult(name = "PROCESS_ID"), @ColumnResult(name = "NAME"),
				@ColumnResult(name = "SUBJECT"), @ColumnResult(name = "STARTED_AT"), @ColumnResult(name = "STARTED_BY"), @ColumnResult(name = "STARTED_BY_DISP"),
				@ColumnResult(name = "PROCESS_DISPLAY_NAME") }),
		@SqlResultSetMapping(name = "processEventsResults", columns = { @ColumnResult(name = "PROCESS_ID"), @ColumnResult(name = "STARTED_AT"), }),
		@SqlResultSetMapping(name = "createdByResult", columns = { @ColumnResult(name = "DISPLAY_NAME"),@ColumnResult(name = "ID") })
})
@Table(name = "PROCESS_EVENTS")
public class ProcessEventsDo implements BaseDo, Serializable {

	private static final long serialVersionUID = 1L;

	public ProcessEventsDo() {
		super();
	}

	@Id
	@Column(name = "PROCESS_ID", length = 32)
	private String processId;

	@Column(name = "NAME", length = 100)
	private String name;

	@Column(name = "SUBJECT", length = 100)
	private String subject;

	@Column(name = "STATUS", length = 100)
	private String status;

	@Column(name = "STARTED_BY", length = 255)
	private String startedBy;

	@Column(name = "STARTED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startedAt;

	@Column(name = "COMPLETED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date completedAt;

	@Column(name = "REQUEST_ID", length = 30)
	private String requestId;

	@Column(name = "STARTED_BY_DISP", length = 100)
	private String startedByDisplayName;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartedBy() {
		return startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}

	@Override
	public Object getPrimaryKey() {
		return processId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getStartedByDisplayName() {
		return startedByDisplayName;
	}

	public void setStartedByDisplayName(String startedByDisplayName) {
		this.startedByDisplayName = startedByDisplayName;
	}

	@Override
	public String toString() {
		return "ProcessEventsDo [processId=" + processId + ", name=" + name + ", subject=" + subject + ", status=" + status + ", startedBy=" + startedBy + ", startedAt=" + startedAt + ", completedAt="
				+ completedAt + ", requestId=" + requestId + ", startedByDisplayName=" + startedByDisplayName + "]";
	}

}
