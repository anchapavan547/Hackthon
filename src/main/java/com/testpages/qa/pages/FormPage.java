package com.testpages.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//textarea[@name='comments']")
	private WebElement commentsField;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileInputField;

	@FindBy(xpath = "//input[@type='checkbox'][@name='checkboxes[]']")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@type='radio' and @name='radioval' and @value='rd2']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//select[@name='multipleselect[]']")
    private WebElement multiSelectDropdown;
	
	@FindBy(xpath = "//select[@name='dropdown']")
    private WebElement Dropdown;
	
	@FindBy(xpath = "//input[@type='submit' and @name='submitbutton' and @value='submit' and contains(@class, 'styled-click-button')]")
	private WebElement submitButton;
	

	public FormPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void MandatoryFields(String userNameText, String passwordText, String commentsFieldText) {
		userNameField.sendKeys(userNameText);
		passwordField.sendKeys(passwordText);
		commentsField.clear();
		commentsField.sendKeys(commentsFieldText);

	}

	public void uploadFile(String filePath) {
		String absoluteFilePath = System.getProperty("user.dir") + filePath;
		fileInputField.sendKeys(absoluteFilePath);
	}

	public void selectCheckbox() {
		if (!checkbox.isSelected()) {
			checkbox.click();
		}

	}
	
	public void selectRadioButton() {
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }
	
	public void selectMultiSelectOption(int index) {
        multiSelectDropdown.click();
        String optionXPath = String.format("//select[@name='multipleselect[]']/option[%d]", index);
        WebElement option = driver.findElement(By.xpath(optionXPath));
        option.click();
    }
	
	public void selectDropdownOptionByIndex(int index) {
        Select dropdown = new Select(Dropdown);
        dropdown.selectByIndex(index);
    }
	
	public void submitForm() {
	    submitButton.click();
	}

	
}
