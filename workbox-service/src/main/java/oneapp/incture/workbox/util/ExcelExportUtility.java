package oneapp.incture.workbox.util;

import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


/**
 * @author INC00400
 *
 * @param <E>
 */
public abstract class ExcelExportUtility< E extends Object> {

	 protected SXSSFWorkbook wb;
	    protected Sheet sh;
	    protected static final String EMPTY_VALUE = " ";
	    /**
	     * This method demonstrates how to Auto resize Excel column
	     */
	    private void autoResizeColumns(int listSize) {
	    	System.err.println("Size :"+listSize);
	        for (int colIndex = 1; colIndex < listSize; colIndex++) {
	        	System.err.println("Col Index :"+colIndex);
	        	int width = ((int)(200 * 1.14388)) * 256;
	        	sh.setColumnWidth(colIndex, width);
	        }
	    }
	    /**
	     * 
	     * This method will return Style of Header Cell
	     * 
	     * @return
	     */
	    protected CellStyle getHeaderStyle() {
	        CellStyle style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        style.setBorderBottom(BorderStyle.THIN);
	        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderLeft(BorderStyle.THIN);
	        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderRight(BorderStyle.THIN);
	        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderTop(BorderStyle.THIN);
	        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    //    style.setAlignment(CellStyle.ALIGN_CENTER);
	        return style;
	    }
	    /**
	     * 
	     * This method will return style for Normal Cell
	     * 
	     * @return
	     */
	    protected CellStyle getNormalStyle() {
	        CellStyle style = wb.createCellStyle();
	        style.setBorderBottom(BorderStyle.THIN);
	        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderLeft(BorderStyle.THIN);
	        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderRight(BorderStyle.THIN);
	        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	        style.setBorderTop(BorderStyle.THIN);
	        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    //    style.setAlignment(CellStyle.ALIGN_CENTER);
	        return style;
	    }
	    /**
	     * @param columns
	     */
	    private void fillHeader(String[] columns) {
	        wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
	        sh = wb.createSheet("Validated Data");
	        CellStyle headerStle = getHeaderStyle();
	        for (int rownum = 0; rownum < 1; rownum++) {
	           Row row = sh.createRow(rownum);
	            for (int cellnum = 0; cellnum < columns.length; cellnum++) {
	                Cell cell = row.createCell(cellnum);
	                cell.setCellValue(columns[cellnum]);
	                cell.setCellStyle(headerStle);
	            }
	        }
	    }
	    /**
	     * @param columns
	     * @param dataList
	     * @return
	     */
	    public final SXSSFWorkbook exportExcel(String[] columns, List<E> dataList) {
	        fillHeader(columns);
	        fillData(dataList);
	        autoResizeColumns(columns.length);
	        return wb;
	    }
	    /**
	     * @param dataList
	     */
	    public abstract void fillData(List<E> dataList);
}
