package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;



public class LoginTest extends BaseTest {
	@Test
	public static void  Login() throws InterruptedException {
		
		driver.findElement(By.xpath(loc.getProperty("signin_link"))).click();
		Thread.sleep(3000);
		System.out.println(loc.getProperty("signin_link"));
		
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(prop.getProperty("login_email"));
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(prop.getProperty("login_password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();		
		
	}	
		
		
	

}
