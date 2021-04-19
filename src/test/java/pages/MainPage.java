package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Shlomi
 * @category Main page
 * @apiNote These is the main page functions 
 */

@SuppressWarnings({ "javadoc" })
public class MainPage extends BasePage {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	By signInBTN = By.className("login");
	By authenticationTitle = By.xpath("//h1[@class='page-heading']");

	// navigate to webSite
	public MainPage getWebSite(String siteURL) {
		navigateToURL(siteURL);
		return this;
	}

	//open the main page
	public MainPage openSignInSection() {
		clickVisible(signInBTN);
		String authenticationString =  getTextFromVisibleElement(authenticationTitle);
		Assert.assertEquals(authenticationString.toLowerCase(), "authentication", "User is not logged in");
		return this;
	}


}
