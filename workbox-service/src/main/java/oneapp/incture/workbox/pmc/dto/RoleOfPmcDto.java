package oneapp.incture.workbox.pmc.dto;


import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Neelam Raj
 *
 */
@XmlRootElement
public class RoleOfPmcDto {

	private Map<String, String> roleMap;
	private String roleName;

	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	
	public Map<String, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, String> roleMap) {
		this.roleMap = roleMap;
	}

	@Override
	public String toString() {
		return "RoleOfPmcDto [roleMap=" + roleMap + ", roleName=" + roleName + "]";
	}

	
	
	
}
