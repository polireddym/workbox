package oneapp.incture.workbox.pmc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

@XmlRootElement
public class ProcessAgeingResponse extends PMCReportBaseDto {

	private List<AgingGraphDto> ageingGraph;

	private AgingResponseDto ageingTable;

	private ResponseMessage responseMessage;

	public List<AgingGraphDto> getAgeingGraph() {
		return ageingGraph;
	}

	public void setAgeingGraph(List<AgingGraphDto> ageingGraph) {
		this.ageingGraph = ageingGraph;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public AgingResponseDto getAgeingTable() {
		return ageingTable;
	}

	public void setAgeingTable(AgingResponseDto ageingTable) {
		this.ageingTable = ageingTable;
	}

}
