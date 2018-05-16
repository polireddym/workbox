package oneapp.incture.workbox.inbox.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcessMessageDto {

	private List<MessageDto> processLevelMessageDto,taskLevelMessageDto;
	
	
	
	public List<MessageDto> getProcessLevelMessageDto() {
		return processLevelMessageDto;
	}
	/**
	 * @param processLevelMessageDto the processLevelMessageDto to set
	 */
	public void setProcessLevelMessageDto(List<MessageDto> processLevelMessageDto) {
		this.processLevelMessageDto = processLevelMessageDto;
	}
	/**
	 * @return the taskLevelMessageDto
	 */
	public List<MessageDto> getTaskLevelMessageDto() {
		return taskLevelMessageDto;
	}
	/**
	 * @param taskLevelMessageDto the taskLevelMessageDto to set
	 */
	public void setTaskLevelMessageDto(List<MessageDto> taskLevelMessageDto) {
		this.taskLevelMessageDto = taskLevelMessageDto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		return "ProcessMessageDto [processLevelMessageDto="
				+ (processLevelMessageDto != null
						? processLevelMessageDto.subList(0, Math.min(processLevelMessageDto.size(), maxLen)) : null)
				+ ", taskLevelMessageDto=" + (taskLevelMessageDto != null
						? taskLevelMessageDto.subList(0, Math.min(taskLevelMessageDto.size(), maxLen)) : null)
				+ "]";
	}
	
	
	
	
	
	
	
}
