package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_AccountLoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String expected) {
		
		logger.info("*** Starting TC_003_LoginDDT ******");
		
		try {
		
		HomePage homepage = new HomePage(driver);
		LoginPage login_page = new LoginPage(driver);
		
		homepage.clickMyAccount();
		logger.info("Clicked on my account");
		homepage.clickLoginOption();
		logger.info("Clicked on login option");
		
		logger.info("Providing user credentials");
		login_page.setEmail(email);
		login_page.setPassword(password);
		login_page.clickLoginBtn();
		logger.info("Login button clicked");
		
		MyAccountPage my_account = new MyAccountPage(driver);
		

		logger.info("Validating expected locators exists");
		boolean targetPage = my_account.isAccountPageExists();
		
		if(expected.equals("Valid")) {
			
			if(targetPage == true) {
				Assert.assertTrue(true);
				my_account.clickLogout();
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(expected.equals("Invalid")) {
			if(targetPage == true) {
				Assert.assertTrue(false);
				my_account.clickLogout();
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC_003_AccountLoginDDT ****");
		
	}
}
