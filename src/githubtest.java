
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class githubtest {
	private static final String priority1 = null;
	public static WebDriver driver;

	@BeforeClass
	public void launchscript() {
		System.setProperty("webdriver.chrome.driver", "C://seleniumdriver//chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\SeleniumDocs\\NewChromeDriver\\chromedriver_win32
		// (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://lathagilla.github.io/MyAssignment/");
	}

	@Test(priority = 1)
	public void verifytitle() {
		driver.findElement(By.name("user name")).sendKeys("aaa");
		driver.findElement(By.id("user email")).sendKeys("aaa@gmail.com");
		driver.findElement(By.name("Check updates")).click();
		String Actualtitle = driver.getTitle();

		Assert.assertEquals(Actualtitle, "Contact Us Form");
		String Title = driver.getTitle();
		System.out.println(Title);

	}

	@Test(priority = 2)
	public void checkingsubject() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='Subject']")).sendKeys("Qa Automation");
		driver.findElement(By.id("Message")).sendKeys("Hi, send me QA course Detailes. ");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		driver.navigate().to("https://lathagilla.github.io/MyAssignment/Contact.html?user+name=aaa");
		Thread.sleep(2000);
		String Actualtitle = driver.getTitle();

		Assert.assertEquals(Actualtitle, "Contact Us");
		String Title = driver.getTitle();
		System.out.println(Title);

	}

	@AfterClass
	public void teardown() {
		driver.close();