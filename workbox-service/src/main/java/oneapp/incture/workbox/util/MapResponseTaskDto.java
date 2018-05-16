package oneapp.incture.workbox.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapResponseTaskDto {

	private String key;
	private TaskStatusDto value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public TaskStatusDto getValue() {
		return value;
	}
	public void setValue(TaskStatusDto value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MapResponseTaskDto [key=" + key + ", value=" + value + "]";
	}
	
}