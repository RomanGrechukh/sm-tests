package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;

public class SMWeCouldntPullPage extends AbstractPage {

    private String verifyAgainButton = "//*[@class='vv-btn vv-btn-big d-inline-block mt-3 w-100 vv-message-button']";

    @Override
    protected String pageIdentifierXpath() {
        return verifyAgainButton;
    }

    public boolean textTitleIsVisible() {
        waitFor(getWebElement(verifyAgainButton));
        return getWebElement(verifyAgainButton).isDisplayed();
    }

    public void clickOnVerifyAgainButton() {
        getWebElement(verifyAgainButton).click();
    }
}
