package oneapp.incture.workbox.pmc.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLoadDto {
	
	private String userName;
	private String plant;
	private String userGroup;
	private BigDecimal noOfTask;
	private String userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public BigDecimal getNoOfTask() {
		return noOfTask;
	}
	public void setNoOfTask(BigDecimal noOfTask) {
		this.noOfTask = noOfTask;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
