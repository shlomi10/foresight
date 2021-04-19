package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Shlomi
 * @category Results page
 * @apiNote These functions are to test the reuslts page
 */
@SuppressWarnings("javadoc")
public class ResultsPage extends BasePage {

	// constructor
	public ResultsPage(WebDriver driver) {
		super(driver);
	}
	
	String product = "//li[contains(@class,'first-in-line')]";
	String rightBlock = "//div[@class='right-block']";
	String fullPrice = product + rightBlock + "//span[@class='old-price product-price']";
	String percentOff = product + rightBlock + "//span[@class='price-percent-reduction']";
	String addToCartBtn = "//*[contains(@class,'add_to_cart_button')]";
	String addProductToCartBtn = product + rightBlock + addToCartBtn; 
	
	String oldPrice;
	double oldPriceDouble;
	String percent;
	int percentint;
	double actualPrice;

	By currentPrice = By.xpath("//div[@id='layer_cart']//span[@id='layer_cart_product_price']");
	
	// get percent and old price of item
	public ResultsPage getOldPrice() {
		oldPrice = getTextFromVisibleElement(fullPrice).trim().replace("$", "");
		percent = getTextFromVisibleElement(percentOff).trim().replace("-", "").replace("%", "");
		return this;
	}
	
	// calculate the discount price
	public ResultsPage addToCart() {
		hoverOverVisibleElement(By.xpath(percentOff));
		clickVisible(addProductToCartBtn);
		oldPriceDouble = Double.parseDouble(oldPrice);
		percentint = Integer.parseInt(percent);
		double expectedPrice = Math.round((oldPriceDouble - (oldPriceDouble * percentint/100))*100)/100.0;
		actualPrice = Double.parseDouble(getTextFromVisibleElement(currentPrice).trim().replace("$", ""));
		assertEquals(actualPrice, expectedPrice, "Discount is not calculated correctly  ");
		return this;
	}	
}
