package oneapp.incture.workbox.pmc.dto;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CollaborationMessagesDto {

	//private String eventId;
	private List<MessageDto> messageDtos;
	private Map<String, MessageDto> mapOfEvents;

	

	public List<MessageDto> getMessageDtos() {
		return messageDtos;
	}

	public void setMessageDtos(List<MessageDto> messageDtos) {
		this.messageDtos = messageDtos;
	}


	public Map<String, MessageDto> getMapOfEvents() {
		return mapOfEvents;
	}

	public void setMapOfEvents(Map<String, MessageDto> mapOfEvents) {
		this.mapOfEvents = mapOfEvents;
	}

	@Override
	public String toString() {
		return "CollaborationMessagesDto [messageDtos=" + messageDtos + ", mapOfEvents=" + mapOfEvents + "]";
	}


}
