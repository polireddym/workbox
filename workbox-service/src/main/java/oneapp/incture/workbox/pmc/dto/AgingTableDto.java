package oneapp.incture.workbox.pmc.dto;

import java.math.BigDecimal;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.util.MapResponseListDto;
import oneapp.incture.workbox.util.ServicesUtil;

@XmlRootElement
public class AgingTableDto implements Comparable<AgingTableDto> {

	public AgingTableDto(String name) {
		this.name = name;
	}
	
	public AgingTableDto() {
	}

	private String name;
	private Map<String, BigDecimal> oldDataMap;
	private MapResponseListDto dataMap;
//	private List<AgingDataMapDto> listDataMap;
	private BigDecimal count;
	private String userName;
	private String processDisplayName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, BigDecimal> getOldDataMap() {
		return oldDataMap;
	}

	public void setOldDataMap(Map<String, BigDecimal> dataMap) {
		this.oldDataMap = dataMap;
	}

	public BigDecimal getCount() {
		return count;
	}

//	public List<AgingDataMapDto> getListDataMap() {
//		return listDataMap;
//	}
//
//	public void setListDataMap(List<AgingDataMapDto> listDataMap) {
//		this.listDataMap = listDataMap;
//	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProcessDisplayName() {
		return processDisplayName;
	}

	public void setProcessDisplayName(String processDisplayName) {
		this.processDisplayName = processDisplayName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgingTableDto other = (AgingTableDto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AgingTableDto [name=" + name + ", oldDataMap=" + oldDataMap + ", dtoDataMap=" + dataMap + ", count="
				+ count + ", userName=" + userName + ", processDisplayName=" + processDisplayName + "]";
	}

	@Override
	public int compareTo(AgingTableDto obj) {
		if (!ServicesUtil.isEmpty(this.name) && !ServicesUtil.isEmpty(obj.name))
			return this.name.compareTo(obj.name);
		return 0;
	}

	public MapResponseListDto getDataMap() {
		return dataMap;
	}

	public void setDataMap(MapResponseListDto dtoDataMap) {
		this.dataMap = dtoDataMap;
	}

}
