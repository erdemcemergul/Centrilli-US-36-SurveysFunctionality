package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CentrilliSurveysPage {

    public CentrilliSurveysPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    public WebDriver driver;
    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement create;
    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement save;
    @FindBy(xpath = "//input[@placeholder='Survey Title']")
    public WebElement write;
    @FindBy(xpath = "//span[@name='title']")
    public WebElement title;
    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement search;
    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discard;
    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement edit;
    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement kanban;
    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement list;
    @FindBy(xpath = "//div[@class='o_thread_message_content']//p")
    public WebElement message;
    @FindBy(xpath = "(//td[@class='o_data_cell o_required_modifier'])[1]")
    public WebElement searchSurvey;

    @FindBy(xpath = "//div[@data-id='4']")
    public WebElement Permanent;
    @FindBy(xpath = "(//span[@class='fa fa-clock-o fa-lg fa-fw o_activity_color_default'])[1]")
    public WebElement openPermanent;
    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement pagerLimit;
    public void createSurvey(){

        create.click();
    }
    public void saveSurvey(){

        save.click();
    }
    public void discardSurvey(){
        discard.click();
    }
    public void editSurvey(){
        edit.click();

    }



}
