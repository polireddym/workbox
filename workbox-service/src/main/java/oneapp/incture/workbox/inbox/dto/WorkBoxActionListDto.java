package oneapp.incture.workbox.inbox.dto;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkBoxActionListDto {

	private List<WorkBoxActionDto> taskInstanceList;

	@Override
	public String toString() {
		return "WorkBoxActionListDto [taskInstanceList=" + taskInstanceList + "]";
	}

	public List<WorkBoxActionDto> getTaskInstanceList() {
		return taskInstanceList;
	}

	public void setTaskInstanceList(List<WorkBoxActionDto> taskInstanceList) {
		this.taskInstanceList = taskInstanceList;
	}	
	
}
