package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import com.incture.pmc.poadapter.services.GroupInfoDto;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class GroupInfoDtoResponse {

	private List<GroupInfoDto> groupInfoDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}


	public List<GroupInfoDto> getGroupInfoDtos() {
		return groupInfoDtos;
	}

	public void setGroupInfoDtos(List<GroupInfoDto> groupInfoDtos) {
		this.groupInfoDtos = groupInfoDtos;
	}

	@Override
	public String toString() {
		return "GroupInfoDtoResponse [groupInfoDtos=" + groupInfoDtos + "]";
	}
	
}
