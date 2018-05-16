package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserGroupDto {
	
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "UserGroupDto [groupName=" + groupName + "]";
	}
	
	
}
