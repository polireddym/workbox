package oneapp.incture.workbox.pmc.dto.responses;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.pmc.dto.AgingResponseDto;
import oneapp.incture.workbox.pmc.dto.PMCReportBaseDto;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

@XmlRootElement
public class TaskAgeingResponse extends PMCReportBaseDto{

	private ResponseMessage responseMessage;
	private AgingResponseDto ageingTable;

	public AgingResponseDto getAgeingTable() {
		return ageingTable;
	}

	public void setAgeingTable(AgingResponseDto ageingTable) {
		this.ageingTable = ageingTable;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

}
