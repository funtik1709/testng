package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTestLaptop extends BaseTest{
	
	@Test

	public static void LoginLaptop() throws InterruptedException {
		// TODO Auto-generated method stub
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1059,768));
		
		driver.findElement(By.xpath(loc.getProperty("burger_button"))).click();
		
		driver.findElement(By.xpath(loc.getProperty("mobile_login_button"))).click();
		
		
		Thread.sleep(3000);	
		
		
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(prop.getProperty("login_email"));
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(prop.getProperty("login_password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		

	}

}
