package com.testpages.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.testpages.qa.pages.FormPage;
import com.testpages.qa.base.Base;

public class FormTest extends Base {
    FormPage formPage;
    WebDriver driver;

    public FormTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        formPage = new FormPage(driver); // Create an instance of FormPage
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void verifyMandatoryFields() {
      
         formPage.MandatoryFields("John", "Password123", "This is a comment");
        
        
    }
}
