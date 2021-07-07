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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditAccount {
  WebDriver driver;
  
  public void EditAccount(WebDriver driver) {
	  this.driver = driver;
	  
  }
  
  @FindBy(linkText="Edit Account")
  WebElement edacc;
  
  @FindBy(name="accountno")
  WebElement accno;
  
  @FindBy(name="AccSubmit")
  WebElement submit;
  
  @FindBy(name="a_type")
  WebElement selacc;
  
  @FindBy(name="AccSubmit")
  WebElement accsubmit;
  
  public static CharSequence readexceldata(int row, int col, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
		
		cell.setCellType(CellType.STRING); //convert cells value to string
		String data = cell.toString(); //to hold the string value in excel cell
		
		return data;
		
	}
  
  public void editacc() throws IOException {
	  
	  edacc.click();
	  accno.sendKeys(readexceldata(4,0,"AccDetails"));
	  submit.click();
	  
	  Select sel = new Select(selacc);
	  sel.selectByVisibleText("Current");
	  
	  
	  accsubmit.click();
	  
  }
}
