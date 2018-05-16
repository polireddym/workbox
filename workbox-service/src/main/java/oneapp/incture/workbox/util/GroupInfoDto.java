package oneapp.incture.workbox.util;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GroupInfoDto {

	private String groupUniqName;
	private String groupDiscription;
	public String getGroupUniqName() {
		return groupUniqName;
	}
	public void setGroupUniqName(String groupUniqName) {
		this.groupUniqName = groupUniqName;
	}
	public String getGroupDiscription() {
		return groupDiscription;
	}
	public void setGroupDiscription(String groupDiscription) {
		this.groupDiscription = groupDiscription;
	}
	
}
