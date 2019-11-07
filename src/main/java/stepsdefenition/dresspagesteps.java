package stepsdefenition;

import java.security.PublicKey;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.DressPage;
import steps.basepage;

public class dresspagesteps {

	DressPage dp;
	
	public dresspagesteps() {
		dp=new DressPage();
	}

	@Given("^User lanuch the application$")
	public void user_lanuch_the_application() throws Throwable {
		dp=new DressPage();
	}

	@Then("^User should see the same number of products count matching with the product header count displayed$")
	public void user_should_see_the_same_number_of_products_count_matching_with_the_product_header_count_displayed() throws Throwable {
		Assert.assertTrue("FailedMissMatchCount", dp.getCountFromHeader()==dp.getProductsSize());

	}

	@When("^the click on Add to cart button for the product \"(.*?)\"$")
	public void the_click_on_Add_to_cart_button_for_the_product(String arg1) throws Throwable {
		dp.clickproduct(arg1);
	}

	@Then("^the product should added to cart page$")
	public void the_product_should_added_to_cart_page() throws Throwable {
		Assert.assertTrue("Failed: Not added",dp.verifyCheckoutButton());
		basepage.driver.navigate().refresh();	
		
	}



}
