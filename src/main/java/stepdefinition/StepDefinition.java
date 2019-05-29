package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import props.CraneDetails;
import props.ExportData;

import java.io.File;
import java.util.*;


public class StepDefinition {

	private WebDriver driver;
	static String cityName;

	@Given("^user wants crane details for \"([^\"]*)\"$")
	public void user_wants_crane_details_for(String cityName) {
		this.cityName = cityName;
		System.out.println("This is setup method");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		ChromeOptions options =  new ChromeOptions();
		//options.addArguments("disable-infobars");
//		options.setCapability(CapabilityType.SUPPORTS_ALERTS, false);
		//options.setCapability("autoGrantPermissions", true);
		driver = new ChromeDriver();

		String urlString = String.format("https://www.bizjournals.com/%s/feature/crane-watch", cityName);
		driver.get(urlString);
		driver.manage().window().maximize();
	}
	@Given("^user clicks on view on the map button$")
	public void user_clicks_on_view_on_the_map_button() throws Throwable {
		driver.findElement(By.xpath("//a[@data-ct=\"OPT: View Map Asset\"][1]")).click();
		Thread.sleep(1000);

		WebElement mapEle = driver.findElement(By.xpath("//*[@id=\"boundary0\"]/article/div[1]/div/div/iframe"));
		driver.navigate().to(mapEle.getAttribute("src"));
		Thread.sleep(10000);




//		System.out.println("element exists : "+ driver.findElement(By.xpath("//*[@id='map']/div/div/div/*[local-name() = 'svg']/*/*[local-name() = 'image'][1]")).isDisplayed());
//		Thread.sleep(5000);
		List<WebElement> cranesList = driver.findElements(By.xpath("//*[@id='map']/div/div/div/*[local-name() = 'svg']/*/*[local-name() = 'image']"));
		System.out.println("these many number of cranes in area: "+ cranesList.size());
		int count = 0;
		Map<String, String> craneDetails = new HashMap<String, String>();
		List<CraneDetails> details = new ArrayList<CraneDetails>();
		CraneDetails individual_Crane = new CraneDetails();

		List<WebElement> attributes;
		List<WebElement> values;

		Actions a = new Actions(driver);
		for (WebElement crane : cranesList
			 ) {
			Thread.sleep(500);
			a.moveToElement(crane).click().build().perform();
			Thread.sleep(500);

			attributes = driver.findElements(By.xpath("//table[@class='attrTable']/tbody/tr/td[1]"));
			values = driver.findElements(By.xpath("//table[@class='attrTable']/tbody/tr/td[2]"));


			if(attributes.size() == values.size()){
				for(int i = 0; i < attributes.size(); i++){
					craneDetails.put(attributes.get(i).getText(), values.get(i).getText());
				}
				//write to exel
//				ExportData.writeToExcel(craneDetails);
			}
			else{
				throw new Exception("There is some desrepancy in crane details");
			}
		}

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
