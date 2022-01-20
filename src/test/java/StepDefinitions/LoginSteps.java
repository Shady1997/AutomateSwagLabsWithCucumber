package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pom.LoginPage;

public class LoginSteps {

	WebDriver driver = null;
	LoginPage loginPage;

	@Given("user is in login page")
	public void user_is_in_login_page() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@When("user add valid username and password")
	public void user_add_valid_username_and_password() {

		loginPage = new LoginPage(driver);

		loginPage.userName.sendKeys("standard_user");

		loginPage.userPassword.sendKeys("secret_sauce");
	}

	@When("click login button")
	public void click_login_button() throws InterruptedException {

		loginPage = new LoginPage(driver);

		loginPage.loginButton.click();
		
		Thread.sleep(5000);
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {

		WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(element.toString(), "PRODUCTS");
	}
}
