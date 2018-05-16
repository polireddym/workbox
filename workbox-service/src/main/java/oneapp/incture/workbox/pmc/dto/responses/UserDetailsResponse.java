package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import com.incture.pmc.poadapter.services.UserDetailsDto;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class UserDetailsResponse {

	private List<UserDetailsDto> userDetailsDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<UserDetailsDto> getUserDetailsDtos() {
		return userDetailsDtos;
	}

	public void setUserDetailsDtos(List<UserDetailsDto> userDetailsDtos) {
		this.userDetailsDtos = userDetailsDtos;
	}

	@Override
	public String toString() {
		return "UserDetailsResponse [userDetailsDtos=" + userDetailsDtos + ", responseMessage=" + responseMessage + "]";
	}

}
