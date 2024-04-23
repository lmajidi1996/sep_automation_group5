package com.sep.step_definition.getting_started;

import com.sep.pages.BasePage;
import com.sep.pages.LeftMainPage;
import com.sep.pages.StartApplicationPage;
import com.sep.utilities.QaDataReader;
import com.sep.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UITest {

    private StartApplicationPage startApplicationPage = new StartApplicationPage();
    private LeftMainPage leftMainPage = new LeftMainPage();

    @Given("the user is on the checkout page of {string}")
    public void the_user_is_on_the_checkout_page_of(String string) {
        new BasePage().logIn(string);
    }


    @Then("the product name {string} should be displayed on the information card")
    public void the_product_name_should_be_displayed_on_the_information_card(String string) {
        BrowserUtils.waitForVisibility(startApplicationPage.programNameOnInfoCard, 10);
        assert startApplicationPage.programNameOnInfoCard.isDisplayed();
        BrowserUtils.waitForTextToBePresentInElement(startApplicationPage.programNameOnInfoCard,string, 10);
        assert startApplicationPage.programNameOnInfoCard.getText().contains(string);

    }

    @Then("the product name on the information card matches {string} on the left side of the screen")
    public void the_product_name_on_the_information_card_matches_on_the_left_side_of_the_screen(String string) {
        BrowserUtils.waitForTextToBePresentInElement(startApplicationPage.programNameOnInfoCard,string, 10);
        assert leftMainPage.programName.getText().equals(string);
    }

    @Then("the price {string} should be displayed")
    public void the_price_should_be_displayed(String string) {
        BrowserUtils.waitForVisibility(startApplicationPage.programPrice, 10);
        assert startApplicationPage.programPrice.isDisplayed();
        BrowserUtils.waitForTextToBePresentInElement(startApplicationPage.programPrice, string, 10);
        assert startApplicationPage.programPrice.getText().contains(string);
    }

    @Then("the text indicating a {string} should be displayed")
    public void the_text_indicating_a_should_be_displayed(String string) {
        BrowserUtils.waitForVisibility(startApplicationPage.flexiblePaymentsPlanAvailableText, 10);
        assert startApplicationPage.flexiblePaymentsPlanAvailableText.isDisplayed();
        BrowserUtils.waitForTextToBePresentInElement(startApplicationPage.flexiblePaymentsPlanAvailableText, string, 10);
        assert startApplicationPage.flexiblePaymentsPlanAvailableText.getText().equals(string);
    }

    @Then("the Program Start Date should be displayed")
    public void the_program_start_date_should_be_displayed() {
        BrowserUtils.waitForVisibility(startApplicationPage.programStartDate, 10);

        assert startApplicationPage.programStartDate.getText().contains(
                BrowserUtils.abbreviateMonth(QaDataReader.getSingleProduct("rfep").getStartDate())
        );
    }

    @Then("the We offer refund policy until the end date should be displayed")
    public void the_we_offer_refund_policy_until_the_end_date_should_be_displayed() {
        BrowserUtils.waitForVisibility(startApplicationPage.refundEndDate, 10);

        assert startApplicationPage.refundEndDate.getText().contains(
                BrowserUtils.abbreviateMonth(QaDataReader.getSingleProduct("rfep").getRefundDate())
        );
    }


}
