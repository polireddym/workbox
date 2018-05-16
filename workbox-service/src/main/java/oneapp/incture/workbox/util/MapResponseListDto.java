package oneapp.incture.workbox.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapResponseListDto {
	private List<MapResponseDto> entry;

	public List<MapResponseDto> getEntry() {
		return entry;
	}

	public void setEntry(List<MapResponseDto> entry) {
		this.entry = entry;
	}
	
	@Override
	public String toString() {
		return "MapResponseListDto [entry=" + entry + "]";
	}
}