package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Shlomi
 * @category Account page
 * @apiNote These functions are to test the Account page
 */

@SuppressWarnings({ "javadoc" })
public class AccountPage extends BasePage {

	// constructor
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	By currentPage = By.xpath("//span[@class='navigation_page']");
	By searchField = By.id("search_query_top");
	String itemToSearch = "Printed Summer Dress";
	By searchBTN = By.xpath("//button[@name='submit_search']");
	By searchPageValidation = By.cssSelector(".navigation_page");
	
	//validate current page
	public AccountPage validateCurrentPage() {
		assertEquals(getTextFromElement(currentPage), "My account", "user didn't landed at account page");
		return this;
	}
	// search for "Printed Summer Dress"
	public AccountPage searchForItem() {
		clearAndTypeTextToElem(searchField, itemToSearch);
		clickOnElement(searchBTN);
		assertEquals(getTextFromElement(searchPageValidation), "Search","User didn't landed at search page");
		return this;
	}

}
