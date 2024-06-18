package testcase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFirstTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		 driver.manage().window().maximize();

	        driver.get("https://tekmetest.ddirection.kz/");        

	        WebElement link_doctors = driver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/header/div[1]/nav/ul/li[2]/a"));
	        link_doctors.click();

	        WebElement link_order = driver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/div/div/div[1]/div/div/button"));
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
	        email.sendKeys("jakoda.abaan@floodouts.com");

	        //b_date
	        WebElement  b_date = driver.findElement(By.xpath("//*[@id=\"date_birthdate\"]"));
	        b_date.sendKeys("19-04-1987");

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


	        // FILL THE FILES FORM

	        // jpg test
	        // WebElement id_file = driver.findElement(By.xpath("//*[@id=\"id_card\"]"));
	        // id_file.sendKeys("C:\\Users\\User\\Pictures\\test\\11.jpg");

	        
	        // WebElement diplom_file = driver.findElement(By.xpath("//*[@id=\"diplomas\"]"));
	        // diplom_file.sendKeys("C:\\Users\\User\\Pictures\\test\\12.jpg");

	        
	        // WebElement cert_file = driver.findElement(By.xpath("//*[@id=\"certificates\"]"));
	        // cert_file.sendKeys("C:\\Users\\User\\Pictures\\test\\13.jpg");

	        // pdf test
	        WebElement id_file = driver.findElement(By.xpath("//*[@id=\"id_card\"]"));
	        id_file.sendKeys("C:\\Users\\User\\Pictures\\test\\21.pdf");

	        
	        WebElement diplom_file = driver.findElement(By.xpath("//*[@id=\"diplomas\"]"));
	        diplom_file.sendKeys("C:\\Users\\User\\Pictures\\test\\22.pdf");

	        
	        WebElement cert_file = driver.findElement(By.xpath("//*[@id=\"certificates\"]"));
	        cert_file.sendKeys("C:\\Users\\User\\Pictures\\test\\23.pdf");

	        //submit_files
	        WebElement submit_files = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[4]/button"));
	        submit_files.click();
	}

}
