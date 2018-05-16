package oneapp.incture.workbox.pmc.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MailRequestDto {

	private String mailTo;
	private String mailSubject;
	private String mailBody;
	private String slaId;

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	
	public String getSlaId() {
		return slaId;
	}

	public void setSlaId(String slaId) {
		this.slaId = slaId;
	}

	@Override
	public String toString() {
		return "MailRequestDto [mailTo=" + mailTo + ", mailSubject=" + mailSubject + ", mailBody=" + mailBody + ", slaId=" + slaId + "]";
	}
}
