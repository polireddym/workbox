package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.BaseDto;
import oneapp.incture.workbox.util.EnOperation;
import oneapp.incture.workbox.util.InvalidInputFault;

@XmlRootElement
public class UserDto extends BaseDto{

	private String userId;
	private String emailId;
	private String userType;
	private Boolean status;
	private String firstNm;
	private String lastNm;
	private String telephone;
	private String mobile;
	private String address;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getFirstNm() {
		return firstNm;
	}
	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}
	public String getLastNm() {
		return lastNm;
	}
	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", emailId=" + emailId + ", userType=" + userType + ", status=" + status + ", firstNm=" + firstNm + ", lastNm="
				+ lastNm + ", telephone=" + telephone + ", mobile=" + mobile + ", address=" + address + "]";
	}
	@Override
	public Boolean getValidForUsage() {
		return null;
	}
	@Override
	public void validate(EnOperation enOperation) throws InvalidInputFault {
		
	}
	
	
}
