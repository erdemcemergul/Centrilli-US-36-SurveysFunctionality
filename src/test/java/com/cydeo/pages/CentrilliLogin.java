package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.cydeo.utilities.Driver.driverPool;

public class CentrilliLogin {

    public CentrilliLogin() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='login']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "(//a[@class='oe_menu_toggler'])[11]")
    public WebElement module;
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement dropdown;





    public void loginWithConfig() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("centrilli.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("centrilli.password"));
        loginButton.click();

    }

    public void enterSurveys() throws InterruptedException {

        if (module.isDisplayed())
            module.click();
        else if(!module.isDisplayed()) {
            dropdown.click();
            Thread.sleep(1500);
            module.click();

            }
        }
    }
