package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Shlomi
 * @category Main methods
 * @apiNote These functions are for all pages
 */

@SuppressWarnings({ "javadoc"})
public abstract class BasePage  {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	
	// constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	// function to navigate to URL
	public void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}
	
	// function to get the current URL
	public String getURLCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	// function to get back webElement
	public WebElement returnWebElement(By elem) {
		return driver.findElement(elem);
	}
	
	// function to click on element by element
	public void clickOnElement(By elem) {
		driver.findElement(elem).click();
	}
	
	// function to click on element by string
	public void clickOnElement(String xpath) {
		clickOnElement(By.xpath(xpath));
	}
	
	// function to clear field and than type text
	public void clearAndTypeTextToElem(By elem, String text) {
		WebElement textField = driver.findElement(elem);
		textField.clear();
		textField.sendKeys(text);
	}
	
	// function to get text from element by
	public String getTextFromElement(By elem) {
		return driver.findElement(elem).getText();
	}
	
	// function to get text from element by string
	public String getTextFromElement(String xpath) {
		return getTextFromElement(By.xpath(xpath));
	}
	
	// function to get text from element that visible
	public String getTextFromVisibleElement(By elem) {
		waitForElementToBeVisible(elem);
		return getTextFromElement(elem);
	}
	
	// function to get text from string element that visible
	public String getTextFromVisibleElement(String xpath) {
		return getTextFromVisibleElement(By.xpath(xpath));
	}

	// function to wait for element to be visible
	public void waitForElementToBeVisible(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}
	
	// function to wait for element to be visible and than click
	public void clickVisible(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
		clickOnElement(elem);
	}
	
	// function to wait for element to be visible and than click
	public void clickVisible(String xpath) {
		clickVisible(By.xpath(xpath));
	}
	
	// function to move courser to element
	public void mouseHooverFromElement(By elem) {
		action = new Actions(driver);
		WebElement element1 = driver.findElement(elem);
		action.moveToElement(element1).build().perform();
	}
	
	// function to move courser to element, wait for visible, scroll o element
    public void hoverOverVisibleElement(By element){
        waitForElementToBeVisible(element);
        scrollToElement(element);
        mouseHooverFromElement(element);
    }

	// function to scroll to element
	public void scrollToElement(By elemToScroll) {
		WebElement element1 = driver.findElement(elemToScroll);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
	}
	
}
