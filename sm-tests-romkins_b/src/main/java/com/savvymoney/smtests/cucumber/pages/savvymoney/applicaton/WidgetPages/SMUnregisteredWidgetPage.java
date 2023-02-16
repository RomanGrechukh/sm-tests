package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.WidgetPages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SMUnregisteredWidgetPage extends PageObject {
    @FindBy (xpath = "//*[contains(text(), 'Check your score')]")
    WebElement buttonCheckScore;

    public void clickCheckYourScoreButton()
    {
        waitFor(ExpectedConditions.elementToBeClickable(buttonCheckScore));
        buttonCheckScore.click();
    }

    public boolean isWidgetShown()
    {
        waitFor(ExpectedConditions.elementToBeClickable(buttonCheckScore));
        try {
            return buttonCheckScore.isDisplayed();
        }
        catch(NoSuchElementException e)
        {
            return false;
        }
    }
}
