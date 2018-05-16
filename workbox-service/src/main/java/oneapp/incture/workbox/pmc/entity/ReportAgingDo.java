package oneapp.incture.workbox.pmc.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import oneapp.incture.workbox.poadapter.entity.BaseDo;

@Entity
@Table(name = "REPORT_AGING_CONFIG")
public class ReportAgingDo implements BaseDo, Serializable {

	private static final long serialVersionUID = -7341365853980611944L;
	@Id
	@Column(name = "ID")
	private String id =UUID.randomUUID().toString().replaceAll("-", "");;

	@Column(name = "REPORT_NAME", length = 50)
	private String reportName;

	@Column(name = "LOWER_SEGMENT")
	private Integer lowerSegment;

	@Column(name = "HIGHER_SEGMENT")
	private Integer higherSegment;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "RANGE")
	private Integer agingRange;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Integer getLowerSegment() {
		return lowerSegment;
	}

	public void setLowerSegment(Integer lowerSegment) {
		this.lowerSegment = lowerSegment;
	}

	public Integer getHigherSegment() {
		return higherSegment;
	}

	public void setHigherSegment(Integer higherSegment) {
		this.higherSegment = higherSegment;
	}

	public Integer getAgingRange() {
		return agingRange;
	}

	public void setAgingRange(Integer agingRange) {
		this.agingRange = agingRange;
	}

	@Override
	public String toString() {
		return "ReportAgingDo [id=" + id + ", reportName=" + reportName + ", lowerSegment=" + lowerSegment
				+ ", higherSegment=" + higherSegment + ", displayName=" + displayName + ", agingRange=" + agingRange
				+ "]";
	}

	@Override
	public Object getPrimaryKey() {
		return id;
	}
}
