package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://tekmetest.ddirection.kz/");
		
		driver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/header/div[1]/nav/div[2]/div[2]/a/span")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("citaf36963@acuxi.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Aa12345678");
		
		driver.findElement(By.xpath("//*[@id=\"modal1\"]/div/form/div[3]/button")).click();
		
	}

}
