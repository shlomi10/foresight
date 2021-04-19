package tests;

import org.testng.annotations.Test;
/**
 * @author Shlomi
 * @category Main Runner
 * @apiNote Main Runner for all tests
 */

@SuppressWarnings("javadoc")
public class MainRunner extends BaseTest {

	String mainSiteURL = "http://automationpractice.com/index.php";

	@Test(priority = 1, groups = { "sanity suite" }, description = "Validate login page opened")
	public void openSignInSection() {
		mainPage.getWebSite(mainSiteURL).openSignInSection();
		loginPage.loginToSystem();
		accountPage.validateCurrentPage();
	}
	
	@Test(priority = 2, groups = { "sanity suite" }, description = "Validate price calculated correctly")
	public void searchAndCalculatePrice() {
		mainPage.getWebSite(mainSiteURL).openSignInSection();
		loginPage.loginToSystem();
		accountPage.searchForItem();
		resultsPage.getOldPrice().addToCart();
	}
}
