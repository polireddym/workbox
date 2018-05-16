package oneapp.incture.workbox.pmc.dto.responses;

import java.util.List;

import oneapp.incture.workbox.pmc.dto.WorkloadRangeDto;
import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

public class WorkloadRangeResponse {

	private List<WorkloadRangeDto> workloadRangeDtos;
	private ResponseMessage responseMessage;

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<WorkloadRangeDto> getWorkloadRangeDtos() {
		return workloadRangeDtos;
	}

	public void setWorkloadRangeDtos(List<WorkloadRangeDto> workloadRangeDtos) {
		this.workloadRangeDtos = workloadRangeDtos;
	}

	@Override
	public String toString() {
		return "WorkloadRangeResponse [workloadRangeDtos=" + workloadRangeDtos + "]";
	}

}
