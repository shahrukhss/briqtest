package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class StepDefinition {

	private WebDriver driver;


	@Given("^user wants crane details for \"([^\"]*)\"$")
	public void user_wants_crane_details_for(String cityName) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setCapability(CapabilityType.SUPPORTS_ALERTS, false);
		options.setCapability("autoGrantPermissions", true);
		driver = new ChromeDriver();
		String urlString = String.format("https://www.bizjournals.com/%s/feature/crane-watch", cityName);
		driver.get(urlString);
		driver.manage().window().maximize();
	}
	@Given("^user clicks on view on the map button$")
	public void user_clicks_on_view_on_the_map_button() throws Throwable {
		driver.findElement(By.xpath("//a[@data-ct=\"OPT: View Map Asset\"][1]")).click();
		Thread.sleep(10000);
		System.out.println(driver.findElement(By.xpath("//*[@id='map']/div/div/div/*[local-name() = 'svg']/*/*[local-name() = 'image'][1]")).isDisplayed());

//		List<WebElement> cranesList = driver.findElements(By.xpath("//*[@id='map']/div/div/div/*[local-name() = 'svg']/*/*[local-name() = 'image']"));
//		System.out.println(cranesList.size());
//		int count = 1;
//		for (WebElement crane : cranesList
//			 ) {
//			count++;
//		}
//		System.out.println(String.format("found %s cranes in this city", count));
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		Thread.sleep(5000);
		//*[@id="map_gc"]
		driver.quit();
	}

	/*@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@When("^user enters username$")
	public void user_enters_username() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("8149444705");
	}

	@When("^user enters password$")
	public void user_enters_password() throws Throwable {
		driver.findElement(By.id("pass")).sendKeys("Radhey123$");
	}

	@And("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.id("loginbutton")).click();
		driver.close();
	}

    @When("^user enters username '(\\d+)'$")
    public void user_enters_username(String username) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(username);
    }

    @When("^user enters password \"([^\"]*)\"$")
    public void user_enters_password(String password) throws Throwable {
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("a")).getCssValue("ac");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/abcd"));

    }
*/
}
