package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class NewAccount {
	
	WebDriver driver;
	
	public void NewAccount(WebDriver driver) {
		this.driver=driver;		
	}
 
	@FindBy(linkText="New Account")
	WebElement newacc;
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="selaccount")
	WebElement selacc;
	
	@FindBy(name="inideposit")
	WebElement initialdep;
	
	@FindBy(name="button2")
	WebElement submit;
	
	@FindBy(xpath="//tr[4]/td[2]")
	WebElement accID;
	
	@FindBy(xpath="//tr[5]/td[2]")
	WebElement custno;
	
public static CharSequence readexceldata(int row, int col, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
		
		cell.setCellType(CellType.STRING); //convert cells value to string
		String data = cell.toString(); //to hold the string value in excel cell
		
		return data;
		
	}

public void writeexceldata(int row, int col, int value, String sheet) throws IOException {
	
	FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
	
	XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
	XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
	
//	ws.createRow(row); //creates an entire row
	ws.getRow(row).createCell(col).setCellValue(value); //gets the row mentioned before, creates a col, sets a value
	fs.close();
	
	FileOutputStream os = new FileOutputStream(".\\DataFolder\\Book1.xlsx");
	wb.write(os);
	os.close();
	
}
	
	
	public void addaccount() throws IOException{
		
		newacc.click();
		custid.sendKeys(readexceldata(6,0,"CustDetails"));
		
		Select sel = new Select(selacc);
		sel.selectByVisibleText("Savings");
		
		initialdep.sendKeys("2000");
		submit.click();
						
		NewAccount wd = new NewAccount();
		int accountno = Integer.parseInt(accID.getText());
		wd.writeexceldata(6, 0, accountno, "AccDetails");
		
//		int customerno = Integer.parseInt(custno.getText());
//		wd.writeexceldata(2, 1, customerno, "AccDetails");
		
	}
}
