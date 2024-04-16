package com.sep.pages;

import com.sep.utilities.ConfigurationReader;
import com.sep.utilities.web.DriverUtils;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }


    public void logIn(String programCode){
        String url = "https://" + System.getenv("username") + ":" + System.getenv("password")
                + "@qa.sep.tdtm.cydeo.com/" + programCode;
        DriverUtils.getDriver().get(url);


    }

}

//"https://" + System.getenv("username") + ":" + System.getenv("upassword")
//                + "@qa.sep.tdtm.cydeo.com/" + programCode;