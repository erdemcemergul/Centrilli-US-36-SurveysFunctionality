package com.cydeo.step_definition;

import com.cydeo.pages.CentrilliLogin;
import com.cydeo.pages.CentrilliSurveysPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Centrilli_StepDefinition {
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
    public String expect ="";
    public String expect2 ="";
    public boolean expect3=false;

    CentrilliLogin login=new CentrilliLogin();
    CentrilliSurveysPage surveys=new CentrilliSurveysPage();
    private int limit;
    WebElement waitwrite= surveys.write;
    @Given("user is on the surveys module page of web table app")
    public void user_is_on_the_surveys_module_page_of_web_table_app() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("centrilli.url"));
        login.loginWithConfig();
       Thread.sleep(5000);

       // driverPool.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        login.enterSurveys();
        Thread.sleep(4000);


    }
    @When("user click the Create Button")
    public void user_click_the_create_button() throws InterruptedException {

        surveys.createSurvey();
        Thread.sleep(5000);
    }
    @When("user write any {string} on Title label")
    public void user_write_any_on_title_label(String string) throws InterruptedException {
        surveys.write.click();
        wait.until(ExpectedConditions.visibilityOf(waitwrite));
        surveys.write.clear();
        wait.until(ExpectedConditions.visibilityOf(waitwrite));
   surveys.write.sendKeys(string);
   expect =string;
    }
    @When("user click the Save Button")
    public void user_click_the_save_button() throws InterruptedException {
       // WebElement waitwrite= surveys.write;
        wait.until(ExpectedConditions.visibilityOf(waitwrite));
        expect2=surveys.write.getAttribute("class");
        surveys.saveSurvey();
        Thread.sleep(5000);
    }
    @Then("user should create a survey")
    public void user_should_create_a_survey() {
        boolean actual=surveys.edit.isDisplayed();
        Assert.assertTrue(actual);
    }

    @Then("user should not create a survey")
    public void user_should_not_create_a_survey() {
       // WebElement waitwrite= surveys.write;
        wait.until(ExpectedConditions.visibilityOf(waitwrite));
        //WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));

     String actual=surveys.write.getAttribute("class");
     Assert.assertNotEquals(expect2,actual);
    }


    @When("user click the Discard Button")
    public void user_click_the_discard_button() throws InterruptedException {
     //   expect3=surveys.create.isDisplayed();
        surveys.discardSurvey();
        Thread.sleep(5000);
    }
    @Then("user should cancel the process")
    public void user_should_cancel_the_process() {
      boolean actual=surveys.create.isEnabled();
      Assert.assertTrue(actual);
    }



    @When("user click the Edit Button")
    public void user_click_the_edit_button() throws InterruptedException {
    surveys.editSurvey();
    Thread.sleep(3000);
    }

    @Then("user should see the page title is changed to the new survey name after user create the survey")
    public void user_should_see_the_page_title_is_changed_to_the_new_survey_name_after_user_create_the_survey() {
        String actual=surveys.title.getText();
        Assert.assertEquals(expect,actual);
    }




    @Then("user should see Survey created message is displayed at the bottom of the page \\(after creating a new survey)")
    public void user_should_see_survey_created_message_is_displayed_at_the_bottom_of_the_page_after_creating_a_new_survey() {
        String expect="Survey created";
        String actual=surveys.message.getText();
        Assert.assertEquals(expect,actual);
    }


    @When("user click the List button")
    public void user_click_the_list_button() throws InterruptedException {
        login.enterSurveys();
        Thread.sleep(7000);

        surveys.list.click();
        Thread.sleep(4000);
        String lim=surveys.pagerLimit.getText();
        limit=Integer.parseInt(lim);


    }
    @When("user write new created {string} under permanent survey list by using search box.")
    public void user_write_new_created_under_permanent_survey_list_by_using_search_box(String string) throws InterruptedException {

        surveys.search.sendKeys(string);
        surveys.search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }
    @Then("user should find the new created survey")
    public void user_should_find_the_new_created_survey() {
    String actual=surveys.searchSurvey.getText();
    Assert.assertEquals(expect,actual);
    }





    @When("user click the Kanban button")
    public void user_click_the_kanban_button() throws InterruptedException {

        surveys.kanban.click();
        surveys.Permanent.click();
        Thread.sleep(4000);



    }
    @Then("user should see the data like as Kanban type")
    public void user_should_see_the_data_like_as_kanban_type() {
        boolean actual=surveys.openPermanent.isDisplayed();
        Assert.assertTrue(actual);
    }





    @Then("user should see the data like as List type")
    public void user_should_see_the_data_like_as_list_type() {
        boolean actual=surveys.pagerLimit.isDisplayed();
        Assert.assertTrue(actual);
    }






    @Then("user should see the number of surveys increased 1")
    public void user_should_see_the_number_of_surveys_increased() throws InterruptedException {

        login.enterSurveys();
        Thread.sleep(7000);
        surveys.list.click();
        Thread.sleep(3000);
        String lim=surveys.pagerLimit.getText().toString();
      int  actuallimit=0;
      actuallimit=Integer.parseInt(lim);
         int oldlimit= 0;
      oldlimit=limit+1;
      if (oldlimit == actuallimit)
      expect3=true;
      else
          expect3=false;
      Assert.assertTrue(expect3);





}}
