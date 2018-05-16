package oneapp.incture.workbox.pmc.dto;

import java.util.List;

public class ReportFormattedDto {
	private String sheetName;
	private List<String> headers;
	private List<Object[]> dataRows;

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public List<Object[]> getDataRows() {
		return dataRows;
	}

	public void setDataRows(List<Object[]> dataRows) {
		this.dataRows = dataRows;
	}
}
