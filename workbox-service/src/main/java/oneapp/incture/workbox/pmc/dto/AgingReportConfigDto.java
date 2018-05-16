package oneapp.incture.workbox.pmc.dto;

public class AgingReportConfigDto {

	
	
	private String from;
	private String to;
	private String displayName;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String toString() {
		return "AgingRangeConfigDto [from=" + from + ", to=" + to + ", displayName=" + displayName + "]";
	}
	
	
}
