package com.savvymoney.smtests.cucumber.steps.application;


import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMWeCouldntPullPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMWeCouldntPullPageSteps {
    @Page
    SMWeCouldntPullPage smWeCouldntPullPage;

    @Step
    public boolean textTitleIsVisible() {
        return smWeCouldntPullPage.textTitleIsVisible();
    }

    @Step
    public void clickOnVerifyAgainButton() {
        smWeCouldntPullPage.clickOnVerifyAgainButton();
    }
}
