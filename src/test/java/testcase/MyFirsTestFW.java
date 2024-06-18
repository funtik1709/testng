package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;



public class MyFirsTestFW extends BaseTest {
	
	@Test
	public static void  RegisterTest()
	{
		
			
		 WebElement link_doctors = driver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/header/div[1]/nav/ul/li[2]/a"));
	     link_doctors.click();
	        
		
		
	}
	
}
