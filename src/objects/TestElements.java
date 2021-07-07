package objects;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Balance;
import pages.ChangePassword;
import pages.CustStat;
import pages.Delete;
import pages.DeleteAccount;
import pages.Deposit;
import pages.Edit;
import pages.EditAccount;
import pages.FundTransfer;
import pages.Login;
import pages.Logout;
import pages.MiniStat;
import pages.NewAccount;
import pages.NewCustomer;
import pages.Withdrawal;

public class TestElements extends baseclass{
	
  @Test
  public void f() throws IOException, Throwable {
	  
	  Login log = PageFactory.initElements(driver, Login.class);	
	  log.loginpage();
	  Thread.sleep(2000);
	  
	  
	  NewCustomer test = PageFactory.initElements(driver, NewCustomer.class);
	  test.newcustomer();
	  Thread.sleep(2000);	
	  
	  Edit ed = PageFactory.initElements(driver, Edit.class);
	  ed.editcust();
	  Thread.sleep(2000);
	  
	  
	  Delete del = PageFactory.initElements(driver, Delete.class);	
	  del.deletecust();
	  Alert alt1 = driver.switchTo().alert();
	  alt1.accept();
	  Thread.sleep(500);
	  alt1.accept();
	  Thread.sleep(2000);
	  
	  NewAccount newaccount = PageFactory.initElements(driver, NewAccount.class);
	  newaccount.addaccount();
	  Thread.sleep(2000);
	  	  
	  EditAccount editaccount = PageFactory.initElements(driver, EditAccount.class);
	  editaccount.editacc();
	  Thread.sleep(2000);
	  	  
	  DeleteAccount deleteacc = PageFactory.initElements(driver, DeleteAccount.class);
	  deleteacc.delaccount();
	  Alert alt2 = driver.switchTo().alert();
	  alt2.accept();
	  alt2.accept();
	  Thread.sleep(2000);
	  
	  Deposit depositamount = PageFactory.initElements(driver, Deposit.class);
	  depositamount.depamount();
	  Thread.sleep(2000);
	  
	  
	  Withdrawal withdraw = PageFactory.initElements(driver, Withdrawal.class);
	  withdraw.withdrawamount();
	  Thread.sleep(2000);
	  
	  FundTransfer ftransfer = PageFactory.initElements(driver, FundTransfer.class);
	  ftransfer.fundtrans();
	  Thread.sleep(2000);
	  
	  
	  Balance balanceenq = PageFactory.initElements(driver, Balance.class);
	  balanceenq.bal();
	  Thread.sleep(2000);
	  
	  
	  MiniStat ministatement = PageFactory.initElements(driver, MiniStat.class);
	  ministatement.minstate();
	  Thread.sleep(2000);
	  
	  
	  CustStat customizedstat = PageFactory.initElements(driver, CustStat.class);
	  customizedstat.custstatement();
	  Thread.sleep(2000);
	  	  
	  Logout quit = PageFactory.initElements(driver, Logout.class);
	  quit.logoff();
	  Alert alt4 = driver.switchTo().alert();
	  alt4.accept();
	  
//	  ChangePassword changepass = PageFactory.initElements(driver, ChangePassword.class);
//	  changepass.changepass();
//	  Alert alt3 = driver.switchTo().alert();
//	  alt3.accept();
	  
  }
}
