package oneapp.incture.workbox.inbox.dto;
//package oneapp.incture.workbox.inbox.dto;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.xml.bind.annotation.XmlRootElement;
//
//import oneapp.incture.workbox.pmc.dto.BaseDto;
//import oneapp.incture.workbox.util.EnOperation;
//import oneapp.incture.workbox.util.InvalidInputFault;
//
//@XmlRootElement
//public class CollaborationDto extends BaseDto {
//
//	// private String messageId;
//	private String processId;
//	private String eventId;
//	private String userId;
//	private String userDisplayName;
//	private Date createdAt;
//	private String message;
//	private String chatId;
//	private String chatDisplayName;
//	private List<MessageDto> messageDto;
//
//	/**
//	 * @return the messageId
//	 */
//	/*
//	 * public String getMessageId() { return messageId; }
//	 *//**
//		 * @param messageId
//		 *            the messageId to set
//		 */
//
//	/*
//	 * public void setMessageId(String messageId) { this.messageId = messageId;
//	 * }
//	 *//**
//		 * @return the processId
//		 */
//	public String getProcessId() {
//		return processId;
//	}
//
//	/**
//	 * @return the messageDto
//	 */
//	/**
//	 * @param processId
//	 *            the processId to set
//	 */
//	public void setProcessId(String processId) {
//		this.processId = processId;
//	}
//
//	/**
//	 * @return the messageDto
//	 */
//	public List<MessageDto> getMessageDto() {
//		return messageDto;
//	}
//
//	/**
//	 * @param messageDto
//	 *            the messageDto to set
//	 */
//	public void setMessageDto(List<MessageDto> messageDto) {
//		this.messageDto = messageDto;
//	}
//
//	/**
//	 * @return the eventId
//	 */
//	public String getEventId() {
//		return eventId;
//	}
//
//	/**
//	 * @param eventId
//	 *            the eventId to set
//	 */
//	public void setEventId(String eventId) {
//		this.eventId = eventId;
//	}
//
//	/**
//	 * @return the userId
//	 */
//	public String getUserId() {
//		return userId;
//	}
//
//	/**
//	 * @param userId
//	 *            the userId to set
//	 */
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	/**
//	 * @return the userDisplayName
//	 */
//	public String getUserDisplayName() {
//		return userDisplayName;
//	}
//
//	/**
//	 * @param userDisplayName
//	 *            the userDisplayName to set
//	 */
//	public void setUserDisplayName(String userDisplayName) {
//		this.userDisplayName = userDisplayName;
//	}
//
//	/**
//	 * @return the createdAt
//	 */
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	/**
//	 * @param createdAt
//	 *            the createdAt to set
//	 */
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	/**
//	 * @return the message
//	 */
//	public String getMessage() {
//		return message;
//	}
//
//	/**
//	 * @param message
//	 *            the message to set
//	 */
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	/**
//	 * @return the chatId
//	 */
//	public String getChatId() {
//		return chatId;
//	}
//
//	/**
//	 * @param chatId
//	 *            the chatId to set
//	 */
//	public void setChatId(String chatId) {
//		this.chatId = chatId;
//	}
//
//	/**
//	 * @return the chatDisplayName
//	 */
//	public String getChatDisplayName() {
//		return chatDisplayName;
//	}
//
//	/**
//	 * @param chatDisplayName
//	 *            the chatDisplayName to set
//	 */
//	public void setChatDisplayName(String chatDisplayName) {
//		this.chatDisplayName = chatDisplayName;
//	}
//
//	
//	@Override
//	public String toString() {
//		final int maxLen = 10;
//		return "CollaborationDto [processId=" + processId + ", eventId=" + eventId + ", userId=" + userId
//				+ ", userDisplayName=" + userDisplayName + ", createdAt=" + createdAt + ", message=" + message
//				+ ", chatId=" + chatId + ", chatDisplayName=" + chatDisplayName + ", messageDto="
//				+ (messageDto != null ? messageDto.subList(0, Math.min(messageDto.size(), maxLen)) : null) + "]";
//	}
//
//	@Override
//	public Boolean getValidForUsage() {
//		return null;
//	}
//
//	@Override
//	public void validate(EnOperation enOperation) throws InvalidInputFault {
//
//	}
//
//}
