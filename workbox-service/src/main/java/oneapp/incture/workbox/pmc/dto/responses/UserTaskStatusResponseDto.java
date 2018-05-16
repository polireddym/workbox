package oneapp.incture.workbox.pmc.dto.responses;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;
import oneapp.incture.workbox.util.MapResponseTaskListDto;

@XmlRootElement
public class UserTaskStatusResponseDto {
	
	private MapResponseTaskListDto taskCountDetail;
	private ResponseMessage responseMessage;


	public MapResponseTaskListDto getTaskCountDetail() {
		return taskCountDetail;
	}

	public void setTaskCountDetail(MapResponseTaskListDto taskCountDetail) {
		this.taskCountDetail = taskCountDetail;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "UserTaskStatusResponseDto [taskCountDetail=" + taskCountDetail + ", responseMessage=" + responseMessage
				+ "]";
	}
}