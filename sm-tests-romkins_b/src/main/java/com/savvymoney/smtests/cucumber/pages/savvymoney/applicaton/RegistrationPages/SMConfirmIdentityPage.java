package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SMConfirmIdentityPage extends PageObject {
    @FindBy(id = "ssn4digits")
    WebElement inputSSN;
    @FindBy(xpath = "//*[@value='Confirm My Identity']")
    WebElement buttonConfirm;

    public void enterSSN(String ssn)
    {
        typeInto(inputSSN, ssn);
    }
    public void clickConfirmButton()
    {
        clickOn(buttonConfirm);
    }

    public boolean isPageShown()
    {
        try {
            return getDriver().findElement(By.xpath("//*[@id='ssn4digits']")).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
