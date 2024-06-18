package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;



public class LoginTest extends BaseTest {
	@Test
	public static void  Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[text()='Личный кабинет']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(prop.getProperty("login_email"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("login_password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"modal1\"]/div/form/div[3]/button")).click();
		
	}	
		
		
	

}
