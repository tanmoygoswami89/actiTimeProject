package com.actitime.testscript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("CreateCustomer",true);
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String customerName = wb.getSheet("CreateCustomer").getRow(1).getCell(3).getStringCellValue();
		String customerDescp = wb.getSheet("CreateCustomer").getRow(1).getCell(4).getStringCellValue();
		HomePage h=new HomePage(driver);
		h.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOpt().click();
		t.getEnterCustomerNameTbx().sendKeys(customerName);
		t.getEnterCustomerDescrition().sendKeys(customerDescp);
		t.getSelectCustomerDD().click();
		t.getOurCompanyTx().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(4000);
		String actualCustomer = t.getActualCustomerCreated().getText();
		Assert.assertEquals(actualCustomer, customerName);
	}
	
	
}
