package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Login {
 
WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;	
		
		
	}		
	
	@FindBy(name="uid")
	WebElement userID;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="btnLogin")
	WebElement btnlogin;
	
	public static CharSequence readdataexcel(int row, int col, String sheet) throws IOException {
		FileInputStream fs = new FileInputStream(".\\DataFolder\\Book1.xlsx"); //object for file
		
		XSSFWorkbook wb = new XSSFWorkbook(fs); //object for workbook
		XSSFSheet ws = wb.getSheet(sheet);//object for subsheet
		XSSFCell cell = ws.getRow(row).getCell(col); //object for cells(row and column)
		
		cell.setCellType(CellType.STRING); //convert cells value to string
		String data = cell.toString(); //to hold the string value in excel cell
		
		return data;
	}	
			
	public void loginpage() throws IOException{
			
		userID.sendKeys(readdataexcel(1,0,"login"));
		pass.sendKeys(readdataexcel(1,1,"login"));
		
		btnlogin.click();

		}
		
	}
	
