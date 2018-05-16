package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import com.incture.pmc.poadapter.services.UserDto;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class UserDtoResponse {

	private List<UserDto> userDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<UserDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDto> userDtos) {
		this.userDtos = userDtos;
	}

	@Override
	public String toString() {
		return "UserDtoResponse [userDtos=" + userDtos + ", responseMessage=" + responseMessage + "]";
	}
	
}
