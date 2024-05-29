package com.sep.step_definition.getting_started;

import com.sep.pages.LeftMainPage;
import com.sep.pages.StartApplicationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.ht.Le;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductLandingPage {

    LeftMainPage leftMainPage=new LeftMainPage();
    StartApplicationPage startApplicationPage=new StartApplicationPage();

  @Then("the system should display the text {string}")
    public void the_system_should_display_the_text(String secureCheckout) {
        String actualSecureText=leftMainPage.getSecureCheckout.getText();
        System.out.println(actualSecureText);
        Assertions.assertEquals(secureCheckout, actualSecureText);
    }
    @Then("the system should display the {string}")
    public void the_system_should_display_the(String programName) {
        Assertions.assertEquals(programName,leftMainPage.programName.getText());
    }
   @Then("the footer on the left side should display logo")
    public void the_footer_on_the_left_side_should_display_logo() {
        Assertions.assertTrue(leftMainPage.footerCydeoImage.isDisplayed());
    }
    @Then("the footer on the left side should display in following order")
    public void the_footer_on_the_left_side_should_display_in_following_order(List <String> leftFooterElements) {
        List <WebElement> footerElements=leftMainPage.footerElements;
        for (int i = 0; i < footerElements.size(); i++) {
            Assertions.assertEquals(leftFooterElements.get(i),footerElements.get(i).getText());
        }
}
    @Then("the footer on the right side should display {string}")
    public void the_footer_on_the_right_side_should_display(String rightFooterText) {
        String actualFooterText=startApplicationPage.footer.getText();
        Assertions.assertEquals(actualFooterText, rightFooterText);
    }
}
