package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	
	
	@BeforeTest	
	public void setUp() throws IOException {
		
		if(driver==null) {			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.get(prop.getProperty("testurl"));
			
			driver.manage().window().maximize();
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			// import geckodriver bellow
			
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Teardown successful");
		
	}
	
}
