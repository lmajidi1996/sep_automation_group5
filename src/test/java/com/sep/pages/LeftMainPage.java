package com.sep.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftMainPage extends BasePage {

    @FindBy(xpath = "(//img[@src = 'assets/images/logo.svg'])[2]")
    public WebElement cydeoImageAtLeftWindow;

    @FindBy(xpath = "(//img[@src = 'assets/images/logo.svg'])[2]")
    public WebElement secureCheckout;

    @FindBy(xpath = "//a[contains(@href, 'https://cydeo.com/')]")
    public List<WebElement> footerOnLeft;

    @FindBy(xpath = "//p[@class='course-name']/a")
    public WebElement programNameOnLeftWindow;

}
