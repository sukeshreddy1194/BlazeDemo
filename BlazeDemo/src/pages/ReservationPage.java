package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservationPage {

	WebDriver driver;
	
	By price = By.xpath("//tbody/tr/td[6]");

	public ReservationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickFlightWithLowestPrice() {
		List<WebElement> list = driver.findElements(price);
		List<String> newList = new ArrayList<String>();
		for(WebElement ele:list) {
			newList.add(ele.getText());
		}
		Collections.sort(newList);
		
		for(WebElement ele:list) {
			if(ele.getText().equals(newList.get(0))) {
				String formatXpath = "//td[text()='"+newList.get(0)+"']/../td";
				driver.findElement(By.xpath(formatXpath)).click();
				break;
			}
		}
	}
	
	
	
}
