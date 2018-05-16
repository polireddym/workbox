package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserWorkloadDetailsDto {
	private String userName;
	private String userId;
	private byte[] image;
	private String userMailId;
	private String applicationGroupsName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}


	public String getApplicationGroupsName() {
		return applicationGroupsName;
	}

	public void setApplicationGroupsName(String applicationGroupsName) {
		this.applicationGroupsName = applicationGroupsName;
	}

	@Override
	public String toString() {
		return "UserWorkloadDetailsDto [userName=" + userName + ", userId=" + userId + ", image=" + image
				+ ", userMailId=" + userMailId + ", applicationGroup=" + applicationGroupsName + "]";
	}

	

}
