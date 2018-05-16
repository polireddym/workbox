package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.poadapter.dto.TaskEventsDto;

@XmlRootElement
public class TaskDetailsResponse {

	
	private List<TaskEventsDto> taskEventsList;
	private ResponseMessage responseMessage;

	public List<TaskEventsDto> getTaskEventsList() {
		return taskEventsList;
	}

	public void setProcessEventsList(List<TaskEventsDto> taskEventsList) {
		this.taskEventsList = taskEventsList;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
}
