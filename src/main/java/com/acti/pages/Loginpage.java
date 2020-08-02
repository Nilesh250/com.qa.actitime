package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*Tester Name: A 
 * Date Created: 08/01/2020
 * Approved by: Nilesh 
 */

public class Loginpage extends DriverScript {
	@FindBy(id = "username")
	WebElement usernameTbox;
	@FindBy(name = "pwd")
	WebElement passwordTbox;
	@FindBy(id = "loginButton")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiLogo;

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	public void validateLoginFunction(String username, String password) {
		usernameTbox.sendKeys("username");
		usernameTbox.sendKeys("password");
		loginButton.click();

	}

	public boolean verifyActiLogo() {
		return actiLogo.isDisplayed();
	}

	public String VerifyLoginPageTitle() {
		return driver.getTitle();

	}
}
