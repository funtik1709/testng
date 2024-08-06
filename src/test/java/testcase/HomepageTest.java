package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;
import base.BaseTest;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

class HomepageTest extends BaseTest {

	@Test
	public static void logoCheck() throws InterruptedException {

		WebElement logo = driver.findElement(By.xpath("//div[@class='logo']//child::img"));

		int logoWidth = logo.getSize().getWidth();
		int logoHeight = logo.getSize().getHeight();

		System.out.println(logoWidth);
		System.out.println(logoHeight);
		assertEquals(logoWidth, 156);
		assertEquals(logoHeight, 42);
		driver.quit();
	}

	@Test
	public static void MenuLinksTest() throws InterruptedException {

		String aboutLink = driver.findElement(By.xpath("//a[@href='/aboutUs']")).getAttribute("innerHTML");
		String doctorsLink = driver.findElement(By.xpath("//a[@href='/forDoctors']")).getAttribute("innerHTML");
		String patientsLink = driver.findElement(By.xpath("//a[@href='/forPatients']")).getAttribute("innerHTML");
		String contactsLink = driver.findElement(By.xpath("//a[@href='/contacts']")).getAttribute("innerHTML");

		String aboutText = "О нас";
		String doctorsText = "Для врачей";
		String patientsText = "Для пациентов";
		String contactsText = "Контакты";

		System.out.println(aboutLink);

		assertEquals(extension.noLineBreaker(aboutText), extension.noLineBreaker(aboutLink));
		assertEquals(extension.noLineBreaker(doctorsText), extension.noLineBreaker(doctorsLink));
		assertEquals(extension.noLineBreaker(patientsText), extension.noLineBreaker(patientsLink));
		assertEquals(extension.noLineBreaker(contactsText), extension.noLineBreaker(contactsLink));

		driver.quit();
	}

	@Test
	public static void langSwitcherTest() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		WebElement langSwitcher = driver.findElement(By.xpath("//div[@class='lang']"));
		langSwitcher.click();

		WebElement kazLink = driver.findElement(By.xpath("//a[@href='/kz']"));

		js.executeScript("arguments[0].click();", kazLink);

		String main_title = driver.findElement(By.xpath("//h1[contains(text(), \"Үздік дәрігерлер \")]")).getText();
		String text = "Үздік дәрігерлер \r\n" + " сіздің денсаулығыңыз үшін";

		assertEquals(extension.noLineBreaker(text), extension.noLineBreaker(main_title));

		driver.quit();

	}

	@Test
	public static void loginButtonTest() throws InterruptedException {

		WebElement loginButton = driver.findElement(By.xpath("//a[@class='button__item']"));
		loginButton.click();

		Thread.sleep(2000);

		String loginTab = driver.findElement(By.xpath("//div[@class='modal__links']//child::button[1]"))
				.getAttribute("innerHTML");
		System.out.println(loginTab);
		assertEquals(loginTab, "Логин");

		WebElement closeBtn = driver.findElement(By.xpath("//div[@class='close-line__wrap']"));
		closeBtn.click();

		driver.quit();
	}

	////////// Hero block //////////////

	final static TextExtension extension = new TextExtension();

	@Test
	public static void HomepageSmokeTest() throws InterruptedException {

		String main_title = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div/div/div[1]/h1"))
				.getText();
		String text = "Лучшие врачи \r\n" + " для вашего здоровья";

		assertEquals(extension.noLineBreaker(text), extension.noLineBreaker(main_title));
		driver.quit();
	}

	@Test
	public static void HowItWorks() throws InterruptedException {

		// How It Works
		WebElement HIW_button = driver.findElement(By.xpath("//a[@href='/#howItWorks']"));
		HIW_button.click();
		WebElement HIW_title = driver.findElement(By.xpath("//div[@id='howItWorks']//child::h1"));
		String HIW_title_text = HIW_title.getAttribute("innerHTML");
		System.out.println(HIW_title_text);
		Thread.sleep(2000);
		assertEquals(HIW_title_text, "Как это работает");
		driver.quit();
	}

	@Test
	public static void Advantages() throws InterruptedException {

		// How It Works
		WebElement adv_button = driver.findElement(By.xpath("//a[@href='/#advantages']"));
		adv_button.click();
		WebElement adv_title = driver.findElement(By.xpath("//div[@id='advantages']//child::h1"));
		String adv_title_text = adv_title.getAttribute("innerHTML");
		System.out.println(adv_title_text);
		Thread.sleep(2000);
		assertEquals(adv_title_text, "Преимущества");
		driver.quit();
	}

	@Test
	public static void docList() throws InterruptedException {

		// How It Works
		WebElement doc_button = driver.findElement(By.xpath("//a[@href='/#doctors']"));
		doc_button.click();
		WebElement doc_title = driver.findElement(By.xpath("//div[@id='doctors']//child::h1"));
		String doc_title_text = doc_title.getAttribute("innerHTML");
		System.out.println(doc_title_text);
		Thread.sleep(2000);
		assertEquals(doc_title_text, "Врачи");
		driver.quit();
	}

	@Test
	public static void FAQ() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement question = driver
				.findElement(By.xpath("//div[text()='Что такое Tekme и какая у вас специализация?']"));

		js.executeScript("window.scrollBy(470, 2600)");

		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", question);

		String verifyText = driver
				.findElement(By.xpath(
						"//div[text()='Что такое Tekme и какая у вас специализация?']/following::div//child::li[1]"))
				.getAttribute("innerHTML");

		System.out.println(extension.toUppercase(verifyText));

		assertNotNull(verifyText);

		driver.quit();
	}

	@Test
	public static void footerText() throws InterruptedException {
		// Юридическая информация
		WebElement info = driver.findElement(By.xpath("//h2[text()='Юридическая информация']"));

		String infoText = info.getText();

		System.out.println(infoText);

		assertEquals(infoText, "Юридическая информация");

		// Способы оплаты

		WebElement payment = driver.findElement(By.xpath("//h2[text()='Способы оплаты']"));
		String paymentText = payment.getText();

		assertEquals(paymentText, "Способы оплаты");	
		

		// Контакты

		WebElement contacts = driver.findElement(By.xpath("//h2[text()='Контакты']"));
		WebElement contactPhone = driver.findElement(By.xpath("//a[@class='footer__phone']"));

		String contactsText = contacts.getText();
		String phone = contactPhone.getAttribute("innerHTML");
		assertEquals(contactsText, "Контакты");

		assertEquals(phone, "+7 (771) 533-81-56");

		// Социальные сети https://www.instagram.com/texme.kz/

		WebElement socialMedia = driver.findElement(By.xpath("//h2[text()='Социальные сети']"));

		String socialMediaText = socialMedia.getText();

		assertEquals(socialMediaText, "Социальные сети");

		WebElement instagram = driver.findElement(By.xpath("//div[@class='footer__socials']//child::a[1]"));

		String instagramLink = instagram.getAttribute("href");

		System.out.println(instagramLink);

		assertEquals(instagramLink, "https://www.instagram.com/texme.kz/");

		driver.quit();

	}
	
	

}
