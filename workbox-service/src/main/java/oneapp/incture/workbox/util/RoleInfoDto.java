package oneapp.incture.workbox.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoleInfoDto {
	private String roleUniqName;
	private String roleDescription;
	public String getRoleUniqName() {
		return roleUniqName;
	}
	public void setRoleUniqName(String roleUniqName) {
		this.roleUniqName = roleUniqName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
