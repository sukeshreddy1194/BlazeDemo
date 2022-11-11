package tests;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservationPage;
import pages.VacationPage;
import testData.DataSupplier;

public class PurchaseFlight extends DataSupplier{

	WebDriver driver;
	
	HomePage homePage;
	PurchasePage purchasePage;
	ReservationPage reservationPage;
	VacationPage vacationPage;
	ConfirmationPage confirmationPage;
	
	public StringBuffer verificationErrors = new StringBuffer();
	
	String driverPath = "..\\BlazeDemo\\BlazeDemo\\Driver\\Older\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://blazedemo.com/index.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void purchaseLowestPricedFlight() {
		homePage = new HomePage(driver);
		purchasePage = new PurchasePage(driver);
		reservationPage = new ReservationPage(driver);
		vacationPage = new VacationPage(driver);
		confirmationPage = new ConfirmationPage(driver);
		
		homePage.headerShouldHaveText(WELCOME_TO_THE_SIMPLE_TRAVEL_AGENCY);
		homePage.clickOnVacationLink();
		vacationPage.urlShouldContainsText(VACATION);
		homePage.selectDepartureCityWithText(MEXICO_CITY);
		homePage.selectDestinationCityWithText(LONDON);
		homePage.clickOnFindFlights();
		reservationPage.clickFlightWithLowestPrice();
		purchasePage.totalCostShouldBeDisplay();
		purchasePage.clickPurchaseFlight();
		confirmationPage.getValueOfId();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
		}
	}
}
