package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	// Elements
	@FindBy(name="firstname")
	WebElement firstname_txtbox;
	
	
	@FindBy(name="lastname")
	WebElement lastname_txtbox;
	
	
	@FindBy(name="email")
	WebElement email_txtbox;
	
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	
	@FindBy(xpath="//div[contains(@class, 'form-check')]/input[@value='0' and @type='radio']")
	WebElement radio_news_letter_no;
	
	@FindBy(xpath="//div[contains(@class, 'form-check')]/input[@value='1' and @type='radio']")
	WebElement radio_news_letter_yes;
	
	
	@FindBy(name="agree")
	WebElement is_agree_checkbox;
	
	@FindBy(how=How.CSS, using="button[type='submit']")
	WebElement continue_registration;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been CReated!']")
	WebElement msgConfirmation;
	
	
	// Action Methods
	public void setFirstName(String firstname) {
		firstname_txtbox.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		lastname_txtbox.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		email_txtbox.sendKeys(email);
	}
	
	public void setPassword(String password) {
		password_txtbox.sendKeys(password);
	}
	
	public void disableNewsletterNotif() {
		radio_news_letter_no.click();
	}
	
	public void enableNewsletterNotif() {
		radio_news_letter_yes.click();
	}
	
	public void checkAgreePolicy() {
		if(!is_agree_checkbox.isSelected()) {
			is_agree_checkbox.click();
		}
	}
	
	public void registrationButtonClicked() {
		continue_registration.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch (Exception e){
			return (e.getMessage());
		}
	}
	
	
}
