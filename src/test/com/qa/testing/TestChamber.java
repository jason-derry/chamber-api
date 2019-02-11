package com.qa.testing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestChamber {
	
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jason\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void testRegisterLogin() throws InterruptedException {
		driver.get(Constants.URL + "/register");
		Register register = PageFactory.initElements(driver, Register.class);
		register.register(Constants.USER, Constants.EMAIL, Constants.PASS);
	}
}
