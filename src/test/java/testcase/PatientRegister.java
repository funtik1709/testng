package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class PatientRegister extends BaseTest { 
	@Test
	public static void PatientRegisterTest() throws InterruptedException {
		// set max window size
		driver.manage().window().maximize();
		
		//get patients page
		WebElement link_patients = driver.findElement(By.xpath("//*[text()=\"Для пациентов\"]"));
		link_patients.click();
		
		//open modal window
		WebElement cabinet_link = driver.findElement(By.xpath("//*[text()=\"Личный кабинет\"]"));
		cabinet_link.click();
		
		//switch to register tab
		WebElement register_tab = driver.findElement(By.xpath("//*[text()=\"Регистрация\"]"));
		register_tab.click();
		
		//FILL THE FORM
		
		//name
		WebElement patient_name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		patient_name.sendKeys("Слава");
		
		//lastname
		WebElement patient_lastname = driver.findElement(By.xpath("//*[@id=\"surname\"]"));
		patient_lastname.sendKeys("Славин");
		
		//middlename
		WebElement patient_middlename = driver.findElement(By.xpath("//*[@id=\"patronymic\"]"));
		patient_middlename.sendKeys("Вальерянович");
		
		//phone
		WebElement patient_phone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		patient_phone.sendKeys("+77474564850");
		
		//email
		WebElement patient_email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		patient_email.sendKeys(prop.getProperty("pat_email"));
		
		//b_date
		WebElement patient_bdate = driver.findElement(By.xpath("//*[@id=\"date_birthdate\"]"));
		patient_bdate.sendKeys("19-09-1978");
		
		// select_region
		Select select_region = new Select(driver.findElement(By.xpath("//*[@id=\"area_id\"]")));
		select_region.selectByVisibleText("Акмолинская область");

		// select_city
		Select select_city = new Select(driver.findElement(By.xpath("//*[@id=\"city_id\"]")));
		select_city.selectByVisibleText("Кокшетау");
		
		// select_gender
		Select select_gender = new Select(driver.findElement(By.xpath("//*[@id=\"sex\"]")));
		select_gender.selectByVisibleText("Мужской");
		
		//password
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("Aa123456$");
		
		//confirm password
		WebElement confirm_password = driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]"));
		confirm_password.sendKeys("Aa123456$");
		
		// accept terms
		WebElement checkbox = driver.findElement(By.id("agree"));
		checkbox.click();
		
		//submit
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"modal1\"]/div/form/div[13]/button"));
		submit.click();
		
	}
}
