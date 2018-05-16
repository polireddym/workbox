package oneapp.incture.workbox.poadapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaskEventsDoPK implements BaseDo, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -363219593432656662L;

	public TaskEventsDoPK() {
		super();
	}

	@Column(name = "EVENT_ID", length = 32, nullable = false)
	private String eventId;

	@Column(name = "PROCESS_ID", length = 32, nullable = false)
	private String processId;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskEventsDoPK other = (TaskEventsDoPK) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		return true;
	}

	@Override
	public Object getPrimaryKey() {
		return null;
	}

}
