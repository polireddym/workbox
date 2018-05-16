
package oneapp.incture.workbox.pmc.dto;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import oneapp.incture.workbox.poadapter.dto.ProcessEventsDto;
import oneapp.incture.workbox.util.ExcelExportUtility;

public class ExcelExportResponse extends ExcelExportUtility<ProcessEventsDto> {

	@Override
	public void fillData(List<ProcessEventsDto> dataList) {
		CellStyle normalStyle = getNormalStyle();
		int rownum = 1;
		SimpleDateFormat dtFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		for (ProcessEventsDto dto : dataList) {
			Row row = sh.createRow(rownum);

			// request Id
			Cell cell_0 = row.createCell(0, CellType.STRING);
			cell_0.setCellStyle(normalStyle);
			cell_0.setCellValue(dto.getRequestId()!=null?dto.getRequestId():"");

			// Process Name
			Cell cell_1 = row.createCell(1, CellType.STRING);
			cell_1.setCellStyle(normalStyle);
			cell_1.setCellValue(dto.getName()!=null?dto.getName():"");

			// Process Subject
			Cell cell_2 = row.createCell(2, CellType.STRING);
			cell_2.setCellStyle(normalStyle);
			cell_2.setCellValue(dto.getSubject()!=null?dto.getSubject():"");

			// Process Started At
			Cell cell_3 = row.createCell(3, CellType.STRING);
			cell_3.setCellStyle(normalStyle);
			cell_3.setCellValue(dto.getStartedAt() != null ? dtFormat.format(dto.getStartedAt()) : " ");

			// Process Started By
			Cell cell_4 = row.createCell(4, CellType.STRING);
			cell_4.setCellStyle(normalStyle);
			cell_4.setCellValue(dto.getStartedByUser()!=null?dto.getStartedByUser():"");

			rownum++;
		}
	}
}