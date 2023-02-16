package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.OfferPages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

public class SMNewAutoLoansPage extends PageObject {
    private String title = "//div[@class='vv-title h1']";

    public boolean isTitleVisible()
    {
        try{
            getDriver().findElement(By.xpath(title)).isDisplayed();
            return true;
        }
       catch(NoSuchElementException e)
        {
            return false;
        }
    }
}
