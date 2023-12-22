package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement email_txtbox;
	
	@FindBy(id="input-password")
	WebElement password_txtbox;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_btn;
	
	
	
	//Action method
	public void setEmail(String email) {
		email_txtbox.sendKeys(email);
	}
	
	public void setPassword(String password) {
		password_txtbox.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		login_btn.click();
	}
}
