package demoblaze.com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
    

public class cartdefinition {

	 WebDriver driver;
	 WebDriverWait wait;
	@Given("user is on demoblaze home page")
	public void user_is_on_demoblaze_home_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.demoblaze.com/");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@When("user selects a product")
	public void user_selects_a_product() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6"))).click();
    }
	

	@When("user is redirected to product selected page")
	public void user_is_redirected_to_product_selected_page() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
	}

	@When("user clicks on Add to cart")
	public void user_clicks_on_add_to_cart() {
		 driver.findElement(By.linkText("Add to cart")).click();
	}

	@When("user accepts the alert")
	public void user_accepts_the_alert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert message: " + alert.getText());
        alert.accept();
	}

	@When("user navigates to cart page")
	public void user_navigates_to_cart_page() {
		driver.findElement(By.id("cartur")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Products']")));
	}

	@Then("product should be displayed in cart")
	public void product_should_be_displayed_in_cart() {
		 WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']")));
	     Assert.assertTrue(product.isDisplayed());
	     driver.quit();
	}

	@When("user deletes the product")
	public void user_deletes_the_product() {
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete"))).click();
	}

	@Then("cart should be empty")
	public void cart_should_be_empty() {
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='Samsung galaxy s6']")));
	     System.out.println("Cart is empty");
	     driver.quit();
	}

}
