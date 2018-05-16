package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import com.incture.pmc.poadapter.services.UserGroupDto;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class UserGroupDtoResponse {

	private List<UserGroupDto> userGroupDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<UserGroupDto> getUserGroupDtos() {
		return userGroupDtos;
	}

	public void setUserGroupDtos(List<UserGroupDto> userGroupDtos) {
		this.userGroupDtos = userGroupDtos;
	}

	@Override
	public String toString() {
		return "UserGroupDtoResponse [userGroupDtos=" + userGroupDtos + ", responseMessage=" + responseMessage + "]";
	}
	
}
