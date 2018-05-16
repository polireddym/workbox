package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.poadapter.dto.TaskEventsDto;

public class TaskEventsResponse {
	
	private List<TaskEventsDto> taskEventDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage2) {
		this.responseMessage = responseMessage2;
	}

	public List<TaskEventsDto> getTaskEventDtos() {
		return taskEventDtos;
	}

	public void setTaskEventDtos(List<TaskEventsDto> taskEventDtos) {
		this.taskEventDtos = taskEventDtos;
	}

	@Override
	public String toString() {
		return "TaskEventsResponse [taskEventDtos=" + taskEventDtos + "]";
	}

}
