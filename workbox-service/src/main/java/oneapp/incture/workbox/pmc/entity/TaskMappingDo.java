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

@Entity
@Table(name = "TASK_STEP_MAPPING")
@SqlResultSetMappings({ @SqlResultSetMapping(name = "parallelTaskResults", columns = { @ColumnResult(name = "TASK_SLA_ID") }) })
public class TaskMappingDo implements BaseDo, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public TaskMappingDo() {
		super();
	}
	
	@Id
	@Column(name = "TASK_MAPPING_ID", length = 50)
	private String mappingId;
	
	@Column(name = "TASK_SLA_ID", length = 50)
	private String slaId;
	
	@Column(name = "NEXT_TASK_ID", length = 50)
	private String nextTaskSlaId;
	
	@Column(name = "REJECT_FLAG", length = 30)
	private String rejectFlag;

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}

	public String getSlaId() {
		return slaId;
	}

	public void setSlaId(String slaId) {
		this.slaId = slaId;
	}

	public String getNextTaskSlaId() {
		return nextTaskSlaId;
	}

	public void setNextTaskSlaId(String nextTaskSlaId) {
		this.nextTaskSlaId = nextTaskSlaId;
	}

	public String getRejectFlag() {
		return rejectFlag;
	}

	public void setRejectFlag(String rejectFlag) {
		this.rejectFlag = rejectFlag;
	}

	@Override
	public String toString() {
		return "TaskMappingDo [mappingId=" + mappingId + ", slaId=" + slaId + ", nextTaskSlaId=" + nextTaskSlaId
				+ ", rejectFlag=" + rejectFlag + "]";
	}

	@Override
	public Object getPrimaryKey() {
		return mappingId;
	}
	
	
}
