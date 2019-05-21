package generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Lib implements IAutoConstant{
	public static Workbook  wb;
	public static String getCellValue(String excelFileName, String sheetName, int rowNum, int ColNum){
		String cellValue = "";
		try {
	wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName+".xlsx"));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(ColNum).toString();
		} catch (Exception e) {
		}
		return cellValue;
	}
	public static int getTotalRowCount(String excelFileName, String sheetName){
		int rowCount = 0;
		try {
	wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName+".xlsx"));
			rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {

		} 
		return rowCount;
	}
	public static String getPropertyValue(String propName){
		String propertyValue = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			propertyValue = prop.getProperty(propName);
		} catch (Exception e) {
			
		} 
		return propertyValue;
	}
	public static void captureScreenshot(WebDriver driver, String testMethodName){
		try {
			String dateTime = new Date().toString().replaceAll(":", "__");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File(SCREENSHOT_PATH + testMethodName +"__"+ dateTime+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
		}
	}
}
