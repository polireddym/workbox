package oneapp.incture.workbox.pmc.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TasksCountDTO {

	private String status;
	private BigDecimal count;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TrackingResponse [status=" + status + ", count=" + count + "]";
	}

}
