package com.sep.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartApplicationPage extends BasePage {

    @FindBy(xpath = "(//div[@class = 'step-title'])[1]")
    public WebElement startApplicationText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[2]")
    public WebElement paymentPlanText;

    @FindBy(xpath = "(//div[@class = 'step-title'])[3]")
    public WebElement reviewText;

    @FindBy(css = "div.step:nth-of-type(1)")
    public WebElement startApplicationStep;

    @FindBy(css = "div.step:nth-of-type(2)")
    public WebElement paymentPlanStep;

    @FindBy(css = "div.step:nth-of-type(3)")
    public WebElement reviewStep;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//mat-label[text()='How did you hear about us?']")
    public WebElement howDidYouHearAboutUsDropDown;


    @FindBy(xpath = "//*[text()='Google']")
    public WebElement googleOption;

    @FindBy(xpath = "//p[text() = 'Flexible payments plan available']")
    public WebElement flexiblePaymentsPlanAvailable;

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

    @FindBy(xpath = "//button[@class = 'next-button']")
    public WebElement nextButton;


}
