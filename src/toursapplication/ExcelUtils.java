package toursapplication;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtils {
		
		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static FileInputStream excelFile;
		
		private static String filePath;
		
		public static void setExcelFile() throws Exception{
			try{
				System.out.println("entered setexcel");
				String workingDir = System.getProperty("user.dir");
				filePath = workingDir+File.separator+"src"+File.separator+"File.xlsx";
				System.out.println("file path is "+filePath);
				excelFile = new FileInputStream(filePath);
				System.out.println("file path is 1 "+filePath);
				ExcelWBook = new XSSFWorkbook(excelFile);
				ExcelWSheet = ExcelWBook.getSheet("Sheet1");
				System.out.println("end of excel");
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
		XSSFRow row = ExcelWSheet.getRow(RowNum);
		XSSFCell cell = row.getCell(ColNum);
		return cell.getStringCellValue();
	}
	public static int getCellData1(int RowNum, int ColNum) throws Exception{
		
		XSSFRow row = ExcelWSheet.getRow(RowNum);
		XSSFCell cell = row.getCell(ColNum);
		return (int) cell.getNumericCellValue();
	}
}
