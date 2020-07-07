package assignment.aaa;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AAALifeFormChecker {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	private String iZip;
	private String iEmail;

	public AAALifeFormChecker(String iZip, String iEmail) {
		this.iZip = iZip;
		this.iEmail = iEmail;
	}

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void aaaLifeValidateQuotePage() throws InterruptedException {
		driver.get("https://www.aaalife.com/term-life-insurance-quote-input");
		driver.manage().window().maximize();
		{
			WebElement element = driver.findElement(By.linkText("Products"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.id("zip")).click();
		driver.findElement(By.id("zip")).click();
		{
			WebElement element = driver.findElement(By.id("zip"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		driver.findElement(By.id("zip")).sendKeys(iZip);
		driver.findElement(By.id("gender")).click();
		{
			WebElement dropdown = driver.findElement(By.id("gender"));
			dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
		}
		driver.findElement(By.id("gender")).click();
		driver.findElement(By.id("month")).click();
		{
			WebElement dropdown = driver.findElement(By.id("month"));
			dropdown.findElement(By.xpath("//option[. = 'September']")).click();
		}
		driver.findElement(By.id("month")).click();
		driver.findElement(By.id("day")).click();
		{
			WebElement dropdown = driver.findElement(By.id("day"));
			dropdown.findElement(By.xpath("//option[. = '15']")).click();
		}
		driver.findElement(By.id("day")).click();
		driver.findElement(By.id("year")).click();
		{
			WebElement dropdown = driver.findElement(By.id("year"));
			dropdown.findElement(By.xpath("//option[. = '1995']")).click();
		}
		driver.findElement(By.id("year")).click();
		driver.findElement(By.cssSelector(".formStyle:nth-child(1)")).click();
		driver.findElement(By.id("isMemberNo")).click();
		driver.findElement(By.id("contact_email")).click();
		driver.findElement(By.id("contact_email")).sendKeys(iEmail);
		driver.findElement(By.id("contact_email")).click();

		Select selectFeet = new Select(driver.findElement(By.id("feet")));
		selectFeet.selectByVisibleText("5");

		Select selectInches = new Select(driver.findElement(By.id("inches")));
		selectInches.selectByVisibleText("4");

		driver.findElement(By.id("weight")).sendKeys("119");
		driver.findElement(By.id("nicotineUse")).click();
		{
			WebElement dropdown = driver.findElement(By.id("nicotineUse"));
			dropdown.findElement(By.xpath("//option[. = 'Never']")).click();
		}
		driver.findElement(By.id("nicotineUse")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("rateYourHealth")).click();
		{
			WebElement dropdown = driver.findElement(By.id("rateYourHealth"));
			dropdown.findElement(By.xpath("//option[. = 'Good']")).click();
		}
		driver.findElement(By.id("rateYourHealth")).click();
		driver.findElement(By.id("coverageAmount")).click();
		{
			WebElement dropdown = driver.findElement(By.id("coverageAmount"));
			dropdown.findElement(By.xpath("//option[. = '$750,000']")).click();
		}
		driver.findElement(By.id("coverageAmount")).click();
		driver.findElement(By.id("termLength")).click();
		{
			WebElement dropdown = driver.findElement(By.id("termLength"));
			dropdown.findElement(By.xpath("//option[. = '30 Years']")).click();
		}
		driver.findElement(By.id("termLength")).click();
		driver.findElement(By.cssSelector(".panel-panel3")).click();
		driver.findElement(By.id("seeQuote")).click();
		Thread.sleep(2000);

		try {
			String parentEle = driver.findElement(By.cssSelector(".inlineValidation")).getText();
			if (parentEle.isEmpty()) {
				System.out.println(" ");
			} else {
				Assert.fail("Check your input and resubmit");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
	}
}
