package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class FundTransfer {
	
	WebDriver driver;
	
	public void FundTransfer(WebDriver driver) {
		this.driver=driver;		
	}
	
	@FindBy(linkText="Fund Transfer")
	WebElement trans;
	
	@FindBy(name="payersaccount")
	WebElement payer;
	
	@FindBy(name="payeeaccount")
	WebElement payee;
	
	@FindBy(name="ammount")
	WebElement amount;
	
	@FindBy(name="desc")
	WebElement descript;
	
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
	
	public void fundtrans() throws IOException {
		
		trans.click();
		payer.sendKeys(readexceldata(1,0,"AccDetails"));
		payee.sendKeys(readexceldata(4,0,"AccDetails"));
		amount.sendKeys("100");
		descript.sendKeys("Transfer");
		submit.click();
	}
	
}
