package com.sep.step_definition.getting_started;

import com.sep.pages.BasePage;
import com.sep.pages.StartApplicationPage;
import com.sep.utilities.BrowserUtils;
import com.sep.utilities.DriverUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.groovy.util.JavaShell;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class PersonalDetails extends BasePage {
    private StartApplicationPage startApplicationPage = new StartApplicationPage();
    WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(10));



    @When("user enter {string} into the First Name field")
    public void user_enter_into_the_first_name_field(String firstName) {
        if(firstName.isEmpty()) {
            startApplicationPage.firstNameInputBox.clear();
        }else {
            startApplicationPage.firstNameInputBox.clear();
            startApplicationPage.firstNameInputBox.sendKeys(firstName);
        }
    }
    @When("user enter {string} into the Last Name field")
    public void user_enter_into_the_last_name_field(String lastName) {
        if(lastName.isEmpty()) {
            startApplicationPage.lastNameInputBox.clear();
        }else {
            startApplicationPage.lastNameInputBox.clear();
            startApplicationPage.lastNameInputBox.sendKeys(lastName);
        }

    }
    @When("user enter {string} into the Email Address field")
    public void user_enter_into_the_email_address_field(String email) {
        startApplicationPage.emailInputBox.clear();
        startApplicationPage.emailInputBox.sendKeys(email);
    }
    @When("user enter {string} into the Phone field")
    public void user_enter_into_the_phone_field(String phone) {
        if(phone.isEmpty()) {
            startApplicationPage.phoneNumberInputBox.clear();
        }else {
            startApplicationPage.phoneNumberInputBox.clear();
            startApplicationPage.phoneNumberInputBox.sendKeys(phone);
        }
    }
    @When("user select from the {string} dropdown")
    public void user_select_from_the_dropdown(String howDidYouHearAboutUs) {
        BrowserUtils.sleep(2);

        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", startApplicationPage.howDidYouHearAboutUsDropDown);
        BrowserUtils.sleep(2);

        wait.until(ExpectedConditions.elementToBeClickable(startApplicationPage.howDidYouHearAboutUsDropDown)).click();
        //startApplicationPage.howDidYouHearAboutUsDropDown.click();
        BrowserUtils.sleep(2);
        List<WebElement> options = DriverUtils.getDriver().findElements(By.xpath("//mat-option/span"));

        for (WebElement option : options) {
            if(option.getText().equals(howDidYouHearAboutUs)) {

                System.out.println("option.getText() = " + option.getText());
                System.out.println("howDidYouHearAboutUs = " + howDidYouHearAboutUs);
                option.click();
                break;
            }
       }

    }
    @When("For only Teens plan the user should be able to enter Valid parent fields values.")
    public void for_only_teens_plan_the_user_should_be_able_to_enter_valid_parent_fields_values() {

        Map parent_Details = new HashMap<>();
        parent_Details.put("First Name", "laila");
        parent_Details.put("Last Name", "mjd");
        parent_Details.put("Email Address", "laila@example.com");
        parent_Details.put("Phone", "12345678");

        if(DriverUtils.getDriver().getCurrentUrl().contains("jfft")){

            startApplicationPage.parentFirstNameInputBox.sendKeys(parent_Details.get("First Name").toString());
            startApplicationPage.parentLastNameInputBox.sendKeys(parent_Details.get("Last Name").toString());
            startApplicationPage.parentEmailAddressInputBox.sendKeys(parent_Details.get("Email Address").toString());
            startApplicationPage.parentPhoneNumberInputBox.sendKeys(parent_Details.get("Phone").toString());
        }

    }
    @Then("the user should be able to click Next button and land in the payment plan page.")
    public void the_user_should_be_able_to_click_next_button_and_land_in_the_payment_plan_page() {
        BrowserUtils.sleep(4);
        wait.until(ExpectedConditions.elementToBeClickable(startApplicationPage.nextButton)).click();
        BrowserUtils.sleep(4);
    }

    @And("For only Teens plan the user should be able to enter invalid parent fields values.")
    public void forOnlyTeensPlanTheUserShouldBeAbleToEnterInvalidParentFieldsValues() {

        if(DriverUtils.getDriver().getCurrentUrl().contains("jfft")){

            startApplicationPage.parentFirstNameInputBox.sendKeys("%%%");
            startApplicationPage.parentLastNameInputBox.sendKeys("  ");
            startApplicationPage.parentEmailAddressInputBox.sendKeys("@@");
            startApplicationPage.parentPhoneNumberInputBox.sendKeys("hhh");
        }
    }

    @Then("the Next button should be disabled.")
    public void theNextButtonShouldBeDisabled() {
        WebElement element = DriverUtils.getDriver().findElement(By.cssSelector(".stepper-horizontal .step.editing .step-circle"));
        String expectedColor = element.getCssValue("background-color");
        BrowserUtils.clickWithJS(startApplicationPage.nextButton);
        BrowserUtils.sleep(2);
        System.out.println("startApplicationPage.isNotClickable(startApplicationPage.nextButton) = " + startApplicationPage.isNotClickable(startApplicationPage.nextButton));

      String actualColor = element.getCssValue("background-color");
        assertEquals(expectedColor, actualColor);
        System.out.println("expectedColor = " + expectedColor);
        System.out.println("actualColor = " + actualColor);
        BrowserUtils.sleep(2);
    }

    WebElement enter_personal_details = DriverUtils.getDriver().findElement(By.xpath("//b[.='Enter personal details']"));
    @When("the user delete the values of the first name fields and should see the complaints of it in red color.")
    public void the_user_delete_the_values_of_the_first_name_fields_and_should_see_the_complaints_of_it_in_red_color() {
        String initialColor = startApplicationPage.firstNameInputBox.getCssValue("color");
        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
        js.executeScript("arguments[0].value = null;", startApplicationPage.firstNameInputBox);
        BrowserUtils.sleep(2);

        js.executeScript("arguments[0].scrollIntoView(true);", startApplicationPage.howDidYouHearAboutUsDropDown);
        BrowserUtils.sleep(2);
        String changedColor = startApplicationPage.firstNameInputBox.getCssValue("color");

        BrowserUtils.sleep(2);
        // Verify if the color changed from blue to red
        if (!initialColor.equals(changedColor)) {
            System.out.println("First Name Field color changed from blue to red. and my test is Passing"+ initialColor +"  vs "+ changedColor);
        } else {
            System.out.println("First Name Field color did not change or change was not detected.my test is Failing"+ initialColor +"  vs "+ changedColor);
        }


    }
    @When("the user delete the values of the last name fields and should see the complaints of it in red color.")
    public void the_user_delete_the_values_of_the_last_name_fields_and_should_see_the_complaints_of_it_in_red_color() {
        String initialColor = startApplicationPage.lastNameInputBox.getCssValue("color");
        startApplicationPage.lastNameInputBox.clear();
        BrowserUtils.sleep(6);
        // Find the label element whose color you want to verify (replace with appropriate locator)
        WebElement label = DriverUtils.getDriver().findElement(By.className("ng-tns-c1798928316-0"));

        // Get the color of the label after clearing the input box
        String labelColor = label.getCssValue("color");

        // Verify if the label color changed to red
        if (labelColor.contains("rgba(255, 0, 0")) {
            System.out.println("Label color changed to red. Test Passed.");
        } else {
            System.out.println("Label color did not change to red. Test Failed.");
        }
        String changedColor = startApplicationPage.lastNameInputBox.getCssValue("color");

        // Verify if the color changed from blue to red
        if (!initialColor.equals(changedColor)) {
            System.out.println("Last Name Field color changed from blue to red. and my test is Passing");
        } else {
            System.out.println("Last Name Field color did not change or change was not detected.my test is Failing");
        }

    }
    @When("the user delete the values of the email fields and should see the complaints of it in red color.")
    public void the_user_delete_the_values_of_the_email_fields_and_should_see_the_complaints_of_it_in_red_color() {
        String initialColor = startApplicationPage.emailInputBox.getCssValue("color");
        startApplicationPage.emailInputBox.clear();
        startApplicationPage.emailInputBox.sendKeys("@@@");
        BrowserUtils.sleep(6);
        String changedColor = startApplicationPage.emailInputBox.getCssValue("color");

        // Verify if the color changed from blue to red
        if (!initialColor.equals(changedColor)) {
            System.out.println("Email Field color changed from blue to red. and my test is Passing");
        } else {
            System.out.println("Email Field color did not change or change was not detected.my test is Failing");
        }
    }
    @When("the user delete the values of the phone fields and should see the complaints of it in red color.")
    public void the_user_delete_the_values_of_the_phone_fields_and_should_see_the_complaints_of_it_in_red_color() {
        String initialColor = startApplicationPage.phoneNumberInputBox.getCssValue("color");
        startApplicationPage.phoneNumberInputBox.clear();
        startApplicationPage.phoneNumberInputBox.sendKeys("jjjj");

        BrowserUtils.sleep(6);
        String changedColor = startApplicationPage.phoneNumberInputBox.getCssValue("color");
        String textdecorationcolor = startApplicationPage.phoneNumberInputBox.getCssValue("text-decoration-color");
        String outlineColor = startApplicationPage.phoneNumberInputBox.getCssValue("outline-color");
        System.out.println("initialColor = " + initialColor);
        System.out.println("textdecorationcolor = " + textdecorationcolor);
        System.out.println("outlineColor = " + outlineColor);
        System.out.println("changedColor = " + changedColor);
        
        if (!initialColor.equals(changedColor)) {
            System.out.println("Phone Field color changed from blue to red. and my test is Passing");
        } else {
            System.out.println("Phone Field color did not change or change was not detected.my test is Failing");
        }
    }
    @When("For only Teens plan when the user click on next button and should be able to see all the missing parent fields in red color.")
    public void for_only_teens_plan_when_the_user_click_on_next_button_and_should_be_able_to_see_all_the_missing_parent_fields_in_red_color() {

        if(DriverUtils.getDriver().getCurrentUrl().contains("jfft")){

            WebElement parentFirstNameInputBox = DriverUtils.getDriver().findElement(By.xpath("//input[@id='mat-input-4']"));
            WebElement parentLastNameInputBox = DriverUtils.getDriver().findElement(By.xpath("//input[@id='mat-input-5']"));
            WebElement parentEmailAddressInputBox = DriverUtils.getDriver().findElement(By.xpath("//input[@id='mat-input-6']"));
            WebElement parentPhoneNumberInputBox = DriverUtils.getDriver().findElement(By.xpath("//input[@id='mat-input-7']"));

            parentFirstNameInputBox.clear();
            parentLastNameInputBox.clear();
            parentEmailAddressInputBox.clear();
            parentPhoneNumberInputBox.clear();

            String parentFirstNameInitialColor = parentFirstNameInputBox.getCssValue("color");
            String parentLastNameInitialColor = parentLastNameInputBox.getCssValue("color");
            String parentEmailAddressInitialColor = parentEmailAddressInputBox.getCssValue("color");
            String parentPhoneNumberInitialColor = parentPhoneNumberInputBox.getCssValue("color");

            System.out.println("parentFirstNameInitialColor = " + parentFirstNameInitialColor);
            System.out.println("parentLastNameInitialColor = " + parentLastNameInitialColor);
            System.out.println("parentEmailAddressInitialColor = " + parentEmailAddressInitialColor);
            System.out.println("parentPhoneNumberInitialColor = " + parentPhoneNumberInitialColor);

        }

    }


}
