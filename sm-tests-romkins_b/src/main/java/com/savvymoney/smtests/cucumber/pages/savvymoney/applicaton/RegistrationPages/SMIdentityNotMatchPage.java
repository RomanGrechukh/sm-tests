package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SMIdentityNotMatchPage extends PageObject {
    private String errorText = "//*[@class='vv-text-01 vv-message-description']/span";

    public boolean isErrorTextShown()
    {
        try {
            getDriver().findElement(By.xpath(errorText)).isDisplayed();
            return true;
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean isUrlCorrect()
    {
        if(getDriver().getCurrentUrl().contains("IDENTITY_NOT_MATCH"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
