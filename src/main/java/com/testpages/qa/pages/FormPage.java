package com.testpages.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@name='comments']")
	private WebElement commentsField;
	
	@FindBy(xpath="//input[@name='filename']")
	private WebElement fileInputField;
	
	

	
	public FormPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void enterFirstName(String userNameText) {
		
		userNameField.sendKeys(userNameText);
		
	}
	
	public void enterLastName(String passwordFieldText) {
		
		passwordField.sendKeys(passwordFieldText);
		
	}
	
	public void commentsField(String commentsFieldText) {
		
		commentsField.clear();
		commentsField.sendKeys(commentsFieldText);
		
	}
	
//	public void uploadFile(String filePath) {
//        fileInputField.sendKeys(filePath);
//    }
	
	
	public void MandatoryFields(String userNameText, String passwordText, String commentsFieldText) {
	    userNameField.sendKeys(userNameText);
	    passwordField.sendKeys(passwordText);
	    commentsField.sendKeys(commentsFieldText);
	    
	  
	}

}
