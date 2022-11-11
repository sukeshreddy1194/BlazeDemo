package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	/*WebDriver driver;
	
	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}*/

	public static void selectDropdownValueUsingText(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}
}
