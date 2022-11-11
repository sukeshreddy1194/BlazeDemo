package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.CommonMethods;

public class HomePage extends CommonMethods{
	
	WebDriver driver;

	By header = By.tagName("h1");
	By vacationLink = By.xpath("//a[text()='destination of the week! The Beach!']");
	By departureCity = By.xpath("//select[@name='fromPort']");
	By destinationCity = By.xpath("//select[@name='toPort']");
	By findFlights = By.xpath("//input[@class='btn btn-primary']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void headerShouldHaveText(String headerText) {
		String actual = driver.findElement(header).getText();
		Assert.assertEquals(actual, headerText);
	}
	
	public void clickOnVacationLink() {
		driver.findElement(vacationLink).click();
	}
	
	public void selectDepartureCityWithText(String text) {
		WebElement element = driver.findElement(departureCity);
		HomePage.selectDropdownValueUsingText(element, text);
	}
	
	public void selectDestinationCityWithText(String text) {
		WebElement element = driver.findElement(destinationCity);
		HomePage.selectDropdownValueUsingText(element, text);
	}
	
	public void clickOnFindFlights() {
		driver.findElement(findFlights).click();
	}
}
