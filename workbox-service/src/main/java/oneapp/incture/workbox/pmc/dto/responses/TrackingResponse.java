package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.pmc.dto.TasksCountDTO;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

@XmlRootElement
public class TrackingResponse {
	
	private List<TasksCountDTO> tasksCount;
	private ResponseMessage responseMessage;
	
	public List<TasksCountDTO> getTasksCount() {
		return tasksCount;
	}
	public void setTasksCount(List<TasksCountDTO> tasksCount) {
		this.tasksCount = tasksCount;
	}
	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
