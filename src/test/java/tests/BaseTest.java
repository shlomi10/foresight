package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AccountPage;
import pages.MainPage;
import pages.ResultsPage;
import pages.LoginPage;
import utilities.ExtentListener;

@SuppressWarnings({"javadoc", "unused"})
public class BaseTest {

	WebDriver driver;
	MainPage mainPage;
	AccountPage accountPage;
	LoginPage loginPage;
	ResultsPage resultsPage;
	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(String browser) {
		
		WebDriverManager.chromedriver().setup();
		try {
			WebDriverManager.chromedriver().setup();
			if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
		}catch (Exception e) {
			System.out.println("You enter wrong browser");
		}
		
		// maximize the browser window
		driver.manage().window().maximize();

		//initiate pages
		mainPage = new MainPage(driver);
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		resultsPage = new ResultsPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
