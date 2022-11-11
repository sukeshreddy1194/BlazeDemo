package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VacationPage {

	WebDriver driver;	
	
	public VacationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void urlShouldContainsText(String text) {
		String currentUrl = driver.getCurrentUrl();
		boolean actual = currentUrl.contains(text);
		Assert.assertTrue(actual);
		driver.navigate().back();
	}
}
