package oneapp.incture.workbox.pmc.rest.dto;

public class TaskRestDto {
	
	private String processId;

	public TaskRestDto() {
		super();
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public String toString() {
		return "TaskRestDto [processId=" + processId + "]";
	}
	
	

}
