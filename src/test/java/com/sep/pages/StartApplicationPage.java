package com.sep.pages;

import com.sep.utilities.BrowserUtils;
import com.sep.utilities.DriverUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartApplicationPage extends BasePage {

    @FindBy(xpath = "(//div[@class = 'step-title'])[1]")
    public WebElement startApplicationText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[2]")
    public WebElement paymentPlanText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[3]")
    public WebElement reviewText;

    @FindBy(xpath = "(//*[@class='step-circle'])[1]")
    public WebElement startApplicationStepCircle;

    @FindBy(xpath = "(//*[@class='step-circle'])[2]")
    public WebElement paymentPlanStepCircle;

    @FindBy(xpath = "(//*[@class='step-circle'])[3]")
    public WebElement reviewStepCircle;


    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    public WebElement lastNameInputBox;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public WebElement phoneNumberInputBox;

    @FindBy(xpath = "//mat-label[text()='How did you hear about us?']")
    public WebElement howDidYouHearAboutUsDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Email')]")
    public WebElement emailOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Facebook')]")
    public WebElement facebookOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Google')]")
    public WebElement googleOption;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Instagram')]")
    public WebElement instagramOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'LinkedIN')]")
    public WebElement linkedInOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Twitter')]")
    public WebElement twitterOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Referred by a friend')]")
    public WebElement referredByFriedOptionFromDropDown;

    @FindBy(xpath = "//mat-option/span[contains(text(), 'Other')]")
    public WebElement otherOptionFromDropDown;


    @FindBy(xpath = "//p[text() = 'Flexible payments plan available']")
    public WebElement flexiblePaymentsPlanAvailableText;

    @FindBy(xpath = "//div[contains(text(), 'Program Start Date')]/b[@class='info-value']")
    public WebElement programStartDate;

    @FindBy(xpath = "(//b[@class='info-value'])[2]")
    public WebElement refundEndDate;

    @FindBy(xpath = "//p[@class='program-title primary-color']")
    public WebElement programNameOnInfoCard;

    @FindBy(xpath = "//div[@class='col-sm']/b[@class = 'info-primary']")
    public WebElement programPrice;


    @FindBy(xpath = "//p[@class = 'footer-text' and contains(text(), 'Need help?')]")
    public WebElement footer;

    @FindBy(xpath = "//button[@class = 'next-button'][contains(text(), 'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='mat-input-4']")
    public WebElement parentFirstNameInputBox;

    @FindBy(xpath = "//input[@id='mat-input-5']")
    public WebElement parentLastNameInputBox;

    @FindBy(xpath = "//input[@id='mat-input-6']")
    public WebElement parentEmailAddressInputBox;

    @FindBy(xpath = "//input[@id='mat-input-7']")
    public WebElement parentPhoneNumberInputBox;

    public boolean isNotClickable( WebElement element) {

        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(3));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return false;
        }catch (TimeoutException e){
            return true;
        }

    }



}
