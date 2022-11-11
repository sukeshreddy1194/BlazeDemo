package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	By idValue = By.xpath("//td[text()='Id']/following-sibling::td");
	
	public void getValueOfId() {
		String idVal = driver.findElement(idValue).getText();
		System.out.println("The ID value after the purchase is here "+idVal);
	}
}
