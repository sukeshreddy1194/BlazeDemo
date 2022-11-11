package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PurchasePage {

	WebDriver driver;
	
	By totalCost = By.xpath("//p[text()='Total Cost: ']");
	By purchaseFlight = By.xpath("//input[@class='btn btn-primary']");

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void totalCostShouldBeDisplay() {
		Assert.assertTrue(driver.findElement(totalCost).isDisplayed());
	}
	
	public void clickPurchaseFlight() {
		driver.findElement(purchaseFlight).click();
	}
}
