package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Shlomi
 * @category Login page
 * @apiNote These functions are to test the login page
 */

@SuppressWarnings("javadoc")
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	By emailField = By.id("email");
	By passwordField = By.id("passwd");
	By signInBTN = By.id("SubmitLogin");
	String email = "reg@givmail.com";
	String pwd = "12345";
	
	//open the main page
	public LoginPage loginToSystem() {
		clearAndTypeTextToElem(emailField, email);
		clearAndTypeTextToElem(passwordField, pwd);
		clickVisible(signInBTN);
		return this;
	}

}