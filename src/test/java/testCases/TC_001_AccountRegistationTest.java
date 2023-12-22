package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistationTest extends BaseClass {


	
	
	@Test(groups= {"Regression", "Master"})
	void test_account_Registration() {

		logger.debug("Application logs....");
		logger.info("***** Starting TC_OO1_AccountRegistrationTest ******");
		
		
		HomePage homepage = new HomePage(driver);
		AccountRegistrationPage registrationpage = new AccountRegistrationPage(driver);
		
		try {
		homepage.clickMyAccount();
		logger.info("Clicked on my account");
		homepage.clickRegisterOption();
		logger.info("Clicked on registration option");
		
		logger.info("Providing Customer data");
		registrationpage.setFirstName(randomString());
		registrationpage.setLastName(randomString());
		registrationpage.setEmail(randomAlphaNumeric() +"@example.com");
		registrationpage.setPassword(randomAlphaNumeric());
		registrationpage.checkAgreePolicy();
		
		Thread.sleep(5000);
		registrationpage.registrationButtonClicked();
		logger.info("Clicking the registration button");
		
		String confirm_message = registrationpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confirm_message, "Your Account Has Been Created!", "Not getting expected message");
		}catch (Exception e) {
			logger.error("Test Failed..");
			Assert.fail();
		}
		
		logger.info("***** Finished the TC_OO1_AccountRegistrationTest *****");
	}
	
	
	
}
