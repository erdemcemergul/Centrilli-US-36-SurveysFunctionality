package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.cydeo.utilities.Driver.driverPool;

public class CentrilliLogin {

    public CentrilliLogin(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='login']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[15]/a/span")
    public WebElement module;




    public void loginWithConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("centrilli.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("centrilli.password"));
        loginButton.click();

    }
    public void enterSurveys(){
        module.click();

    }
}
