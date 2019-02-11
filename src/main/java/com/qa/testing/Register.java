package com.qa.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register {
	
	@FindBy(id = "username")
	private WebElement user;
	
	@FindBy(id = "email")
	private WebElement mail;
	
	@FindBy(id = "password")
	private WebElement pass;
	
	@FindBy(id = "passwordConf")
	private WebElement pass2;
	
	@FindBy(className = "btn-secondary")
	private WebElement submit;
	
	public void register (String username, String email, String password) {
		user.sendKeys(username);
		mail.sendKeys(email);
		pass.sendKeys(password);
		pass2.sendKeys(password);
		submit.click();
	}	
}
