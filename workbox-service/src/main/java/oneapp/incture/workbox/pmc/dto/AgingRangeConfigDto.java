package oneapp.incture.workbox.pmc.dto;
/* For Process and task status range*/



public class AgingRangeConfigDto {

	private String reportId;
	private Integer agingRange;
	private String reportName;

	/**
	 * @return the agingRange
	 */
	public Integer getAgingRange() {
		return agingRange;
	}

	/**
	 * @param agingRange
	 *            the agingRange to set
	 */
	public void setAgingRange(Integer agingRange) {
		this.agingRange = agingRange;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * @param reportName
	 *            the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgingRangeConfigDto [reportId=" + reportId + ", agingRange=" + agingRange + ", reportName=" + reportName
				+ "]";
	}

	/**
	 * @return the repoetId
	 */
	public String getReportId() {
		return reportId;
	}

	/**
	 * @param repoetId the repoetId to set
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	

}
