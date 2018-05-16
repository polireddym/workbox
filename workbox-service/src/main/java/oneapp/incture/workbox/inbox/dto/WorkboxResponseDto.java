package oneapp.incture.workbox.inbox.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import oneapp.incture.workbox.poadapter.dto.ResponseMessage;

@XmlRootElement
public class WorkboxResponseDto {
	private List<WorkBoxDto> workBoxDtos;
	private BigDecimal count ;
	private ResponseMessage responseMessage;
	private int pageCount;

	public List<WorkBoxDto> getWorkBoxDtos() {
		return workBoxDtos;
	}

	public void setWorkBoxDtos(List<WorkBoxDto> workBoxDtos) {
		this.workBoxDtos = workBoxDtos;
	}

	public ResponseMessage getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(ResponseMessage responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "WorkboxResponseDto [workBoxDtos=" + workBoxDtos + ", count=" + count + ", responseMessage="
				+ responseMessage + ", pageCount=" + pageCount + "]";
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}
	
}
