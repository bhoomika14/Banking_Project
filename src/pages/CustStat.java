package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class CustStat {
  WebDriver driver;
  
  public void CustStat(WebDriver driver) {
	  this.driver=driver;
  }
  
  	@FindBy(linkText="Customised Statement")
  	WebElement custom;
  
  	@FindBy(name="accountno")
	WebElement accno;
	
  	@FindBy(name="fdate")
  	WebElement fdate;
  	
  	@FindBy(name="tdate")
  	WebElement tdate;
  	
  	@FindBy(name="amountlowerlimit")
  	WebElement mintrans;
  	
  	@FindBy(name="numtransaction")
  	WebElement numtrans;
  	 	
	@FindBy(name="AccSubmit")
	WebElement submit;
	
	public static CharSequence readexceldata(int row, int col, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
		
		cell.setCellType(CellType.STRING); //convert cells value to string
		String data = cell.toString(); //to hold the string value in excel cell
		
		return data;
		
	}
  
	
	public void custstatement() throws IOException{
		
		custom.click();
		accno.sendKeys(readexceldata(4,0,"AccDetails")); 
		fdate.sendKeys("0407");
		fdate.sendKeys(Keys.TAB);
		fdate.sendKeys("2021");
		tdate.sendKeys("0607");
		tdate.sendKeys(Keys.TAB);
		tdate.sendKeys("2021");
		mintrans.sendKeys("2000");
		numtrans.sendKeys("2");
		submit.click();
	
	}
	
}
