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
@Table(name = "WORKLOAD_TB")
public class WorkloadRangeDo implements BaseDo, Serializable {

	private static final long serialVersionUID = 1L;

	public WorkloadRangeDo() {
		super();
	}

	@Id
	@Column(name = "LOAD_TYPE", length = 20)
	private String loadType;

	@Column(name = "LOWER_LIMIT")
	private Integer lowLimit;

	@Column(name = "UPPER_LIMIT")
	private Integer highLimit;

	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public Integer getLowLimit() {
		return lowLimit;
	}

	public void setLowLimit(Integer lowLimit) {
		this.lowLimit = lowLimit;
	}

	public Integer getHighLimit() {
		return highLimit;
	}

	public void setHighLimit(Integer highLimit) {
		this.highLimit = highLimit;
	}

	@Override
	public String toString() {
		return "WorkloadRangeDo [loadType=" + loadType + ", lowLimit=" + lowLimit + ", highLimit=" + highLimit + "]";
	}

	@Override
	public Object getPrimaryKey() {
		return loadType;
	}
	
}
