package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;



public class MyFirsTestFW extends BaseTest {
	
	private static String edge;
	private static String firefox;

	@Test
	public static void  RegisterTest() throws InterruptedException
	{
		driver.manage().window().maximize();
			
		 WebElement link_doctors = driver.findElement(By.xpath("//*[text()='Для врачей']"));
	     link_doctors.click();
	     
	     Thread.sleep(3000);
	     
	     WebElement link_order = driver.findElement(By.xpath("//*[text()='Подать заявку']"));
	        link_order.click();
	        
	        
	     // FILL THE REGISTER FORM

	        //first_name
	        WebElement first_name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	        first_name.sendKeys("Иван");

	        //last_name 
	        WebElement last_name = driver.findElement(By.xpath("//*[@id=\"surname\"]"));
	        last_name.sendKeys("Иванов");

	        //middle_name
	        WebElement middle_name = driver.findElement(By.xpath("//*[@id=\"patronymic\"]"));
	        middle_name.sendKeys("Иванович");

	        //select_sex
	        Select select_sex = 
	        new Select
	        (driver.findElement
	        (By.xpath("//*[@id=\"sex\"]")));
	        select_sex.selectByVisibleText("Мужской");

	        //iin
	        WebElement  iin = driver.findElement(By.xpath("//*[@id=\"iin\"]"));
	        iin.sendKeys("850527361128");

	        //phone
	        WebElement  phone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
	        phone.sendKeys("+77474564850");

	        //email
	        WebElement  email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	        email.sendKeys(prop.getProperty("reg_email"));
    
              
	        String browserName = (loc.getProperty("browser"));
	        
	        //b_date
	        
            //edge
//	        WebElement  b_date = driver.findElement(By.xpath("//*[@id=\"date_birthdate\"]"));
//		    b_date.sendKeys("12-07-1990");
	        
	        //chrome and firefox
        	WebElement  b_date = driver.findElement(By.xpath("//*[@id=\"date_birthdate\"]"));
	        b_date.sendKeys("1987-07-15");
	        
    	    
	       
	        

	        //select_region
	        Select select_region = new Select(driver.findElement(By.xpath("//*[@id=\"area_id\"]")));
	        select_region.selectByVisibleText("Карагандинская область");

	        //select_city
	        Select select_city = new Select(driver.findElement(By.xpath("//*[@id=\"city_id\"]")));
	        select_city.selectByVisibleText("Караганда");

	        //agree
	        WebElement checkbox = driver.findElement(By.id("agree"));
	        checkbox.click();

	        // submit
	        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[12]/button"));
	        submit.click();
	        Thread.sleep(2000);

	        // FILL THE FILES FORM	        

	        // pdf test
	        WebElement id_file = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[1]/input"));
	        id_file.sendKeys("C:\\Users\\User\\Pictures\\test\\21.pdf");
	        Thread.sleep(2000);
	        
	        WebElement diplom_file = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[2]/input"));
	        diplom_file.sendKeys("C:\\Users\\User\\Pictures\\test\\22.pdf");
	        Thread.sleep(2000);
	        
	        WebElement cert_file = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[3]/input"));
	        cert_file.sendKeys("C:\\Users\\User\\Pictures\\test\\23.pdf");
	        Thread.sleep(2000);
	        //submit_files
	        WebElement submit_files = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[4]/button"));
	        submit_files.click();   
		
	}
	
}
