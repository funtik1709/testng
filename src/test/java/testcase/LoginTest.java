package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class LoginTest extends BaseTest {
	@Test(dataProviderClass = ReadXLSdata.class, dataProvider = "bvtdata")
	public static void Login(String username, String password) throws InterruptedException {
		driver.manage().window().maximize();

		driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
		Thread.sleep(3000);
		System.out.println(loc.getProperty("signin_link"));

		// data provider
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);

		// from config file
//		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(prop.getProperty("login_email"));
//		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(prop.getProperty("login_password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();

	}

}
