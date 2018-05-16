package oneapp.incture.workbox.pmc.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageDto {

	private String message;
	private String userDisplayName;
	private String userId;
	private Date createdAt;
	private String createdAtDisplayDate;
	private String eventId;
	private String processId;
	private String chatId;
	private String chatDisplayName;
	
	
	public String getCreatedAtDisplayDate() {
		return createdAtDisplayDate;
	}
	public void setCreatedAtDisplayDate(String createdAtDisplayDate) {
		this.createdAtDisplayDate = createdAtDisplayDate;
	}

	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the userDisplayName
	 */
	public String getUserDisplayName() {
		return userDisplayName;
	}
	/**
	 * @param userDisplayName the userDisplayName to set
	 */
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getChatDisplayName() {
		return chatDisplayName;
	}
	public void setChatDisplayName(String chatDisplayName) {
		this.chatDisplayName = chatDisplayName;
	}
	
	@Override
	public String toString() {
		return "MessageDto [message=" + message + ", userDisplayName=" + userDisplayName + ", userId=" + userId
				+ ", createdAt=" + createdAt + ", createdAtDisplayDate=" + createdAtDisplayDate + ", eventId=" + eventId
				+ ", processId=" + processId + ", chatId=" + chatId + ", chatDisplayName=" + chatDisplayName + "]";
	}
	
	
	
	
}
