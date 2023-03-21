package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
public static	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);	
		driver.close();
	}	
	@BeforeMethod
	public void login() throws IOException {
	Reporter.log("login",true);	
	FileInputStream fis=new FileInputStream("./data/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String url = p.getProperty("url");
	String un = p.getProperty("username");
	String pw = p.getProperty("password");
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.setLogin(un,pw);
	}
	@AfterMethod
	public void logOut() {
		Reporter.log("logOut",true);
		HomePage h=new HomePage(driver);
		h.setLogout();
	}
}
