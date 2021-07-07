package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Delete {
  WebDriver driver;
  
  public void Delete(WebDriver driver) {
	  this.driver = driver;
	  
  }
  
  @FindBy(linkText="Delete Customer")
	WebElement delcust;
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="AccSubmit")
	WebElement sub;
	
		
	public static CharSequence readexceldata(int row, int col, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
		
		cell.setCellType(CellType.STRING); //convert cells value to string
		String data = cell.toString(); //to hold the string value in excel cell
		
		return data;
		
	}
	
	
	public void deletecust() throws IOException {
		delcust.click();
		custid.sendKeys(readexceldata(7,0,"CustDetails"));
		sub.click();
	}
}
