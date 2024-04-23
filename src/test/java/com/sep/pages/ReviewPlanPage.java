package com.sep.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPlanPage {

    @FindBy(xpath = "//form[@id='payment-form']")
    public WebElement paymentForm;

    @FindBy(xpath = "//iframe[@name='__privateStripeFrame5964']")
    public WebElement paymentFrame;


    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement cardNumberInput;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement expiryDateInput;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement cvcInput;

    @FindBy(xpath = "//select[@name = 'country']")
    public WebElement countryDropDown;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement zipCodeInput;

    @FindBy(xpath = "//p[contains(., 'By providing your card information')]")
    public WebElement byProvidingCardInformationText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Product Price')]")
    public WebElement productPriceText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Product Price')]/following-sibling::span")
    public WebElement productPriceAmount;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Installment Price')]")
    public WebElement installmentPriceText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Installment Price')]/following-sibling::span")
    public WebElement installmentPriceAmount;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Subtotal')]")
    public WebElement subtotalText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Subtotal')]/following-sibling::span")
    public WebElement subtotalAmount;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Processing')]")
    public WebElement processingFeeText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Processing')]/following-sibling::span")
    public WebElement processingFeeAmount;


    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Total')]")
    public WebElement totalText;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Total')]/following-sibling::span")
    public WebElement totalAmount;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    public WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//u[normalize-space()='Terms and Conditions']")
    public WebElement termsAndConditionsLink;

    @FindBy(xpath = "//button[@type='button']/")
    public WebElement payButton;


    @FindBy(xpath = "//span[@class='back-button']")
    public WebElement backButton;

    @FindBy(xpath = "(//p[@class = 'footer-text' and contains(text(), 'Need help?')])[3]")
    public WebElement footerText;




}
