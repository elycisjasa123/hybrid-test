package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_AccountLoginTest extends BaseClass {

	
	@Test(groups={"Sanity", "Master"})
	void test_account_login() {
		
		logger.info("***** Starting TC_002_AccountLoginTest *****");
		HomePage homepage = new HomePage(driver);
		LoginPage login_page = new LoginPage(driver);
		try {
			homepage.clickMyAccount();
			logger.info("Clicked on my account");
			homepage.clickLoginOption();
			logger.info("Clicked on login option");
			
			logger.info("Providing user credentials");
			login_page.setEmail(rb.getString("email"));
			login_page.setPassword(rb.getString("password"));
			login_page.clickLoginBtn();
			logger.info("Login button clicked");
			
			MyAccountPage my_account = new MyAccountPage(driver);
			

			logger.info("Validating expected locators exists");
			boolean targetPage = my_account.isAccountPageExists();
			Assert.assertEquals(targetPage, true, "Invalid Login Data");
			
		}catch(Exception e) {
			logger.error("Test Failed..");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_002_AccountLoginTest *****");
			
	}
}
