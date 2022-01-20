package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pom.CartPage;
import pom.InventoryPage;

public class InventorySteps {

	InventoryPage inventoryPage;
	WebDriver driver = null;

	@Given("user choose all products in inventory page")
	public void user_choose_all_products_in_inventory_page() throws InterruptedException {

		driver = new ChromeDriver();

		inventoryPage = new InventoryPage(driver);

		inventoryPage.firstProduct.click();
		inventoryPage.secondProduct.click();

		// declare javascript executer object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,200)", "");

		inventoryPage.thirdProduct.click();

		inventoryPage.fourthProduct.click();

		// Locating element by link text and store in variable "Element"
		WebElement element = driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)"));

		// Scrolling down the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);

		inventoryPage.fifthProduct.click();

		inventoryPage.sixProduct.click();

		js.executeScript("window.scrollBy(0,-1000)", "");

		// wait for 5 sec
		Thread.sleep(5000);

	}

	@When("click backet image")
	public void click_backet_image() throws InterruptedException {

		inventoryPage.moveToPaymentPage.click();

		// wait for 5 sec
		Thread.sleep(5000);
	}

	@Then("user navigate to next page to review selected products")
	public void user_navigate_to_next_page_to_review_selected_products() {

		WebElement element = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(element.toString(), "YOUR CART");
	}

}
