package oneapp.incture.workbox.poadapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaskOwnersDoPK implements BaseDo, Serializable {

	/**
	 * 
	 */
	public TaskOwnersDoPK() {
		super();
	}

	private static final long serialVersionUID = -7858573206799766633L;

	@Column(name = "EVENT_ID", length = 32, nullable = false)
	private String eventId;

	@Column(name = "TASK_OWNER", length = 255, nullable = false)
	private String taskOwner;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((taskOwner == null) ? 0 : taskOwner.hashCode());
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
		TaskOwnersDoPK other = (TaskOwnersDoPK) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (taskOwner == null) {
			if (other.taskOwner != null)
				return false;
		} else if (!taskOwner.equals(other.taskOwner))
			return false;
		return true;
	}

	@Override
	public Object getPrimaryKey() {
		return null;
	}

}
