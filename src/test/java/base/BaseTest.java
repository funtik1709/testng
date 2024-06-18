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
	public static FileReader fr;
	
	
	@BeforeTest	
	public void setUp() throws IOException {
		
		if(driver==null) {
			FileReader fr = new FileReader("C:\\Users\\User\\Desktop\\QA_TUTORIAL\\eclipse\\TestAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
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
	
//	@AfterTest
//	public void tearDown() {
//		driver.close();
//		System.out.println("Teardown successful");
//		
//	}
	
}
