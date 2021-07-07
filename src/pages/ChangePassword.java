package pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class ChangePassword {
	
	WebDriver driver;
	
	public void ChangePassword(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(linkText="Change Password")
	WebElement pass;
	
	@FindBy(name="oldpassword")
	WebElement oldpass;
	
	@FindBy(name="newpassword")
	WebElement newpass;
	
	@FindBy(name="confirmpassword")
	WebElement confirmpass;
	
	@FindBy(name="sub")
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
	
public void writeexceldata(int row, int col, String value, String sheet) throws IOException {
		
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		
		
		ws.createRow(row); //creates an entire row
		ws.getRow(row).createCell(col).setCellValue(value); //gets the row mentioned before, creates a col, sets a value
		fs.close();
		
		FileOutputStream os = new FileOutputStream(".\\DataFolder\\Book1.xlsx");
		wb.write(os);
		os.close();
		
	}
	
	public void changepass() throws IOException{		
		pass.click();
		oldpass.sendKeys(readexceldata(1,1,"login"));
		newpass.sendKeys("Abc12345!");
		String newpass1 = newpass.getText();
		confirmpass.sendKeys("Abc12345!");
		submit.click();
		
		ChangePassword wd = new ChangePassword();
		wd.writeexceldata(1, 1, newpass1, "login");
	}
	
  
}
