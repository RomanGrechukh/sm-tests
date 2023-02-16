package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMConfirmIdentityPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMConfirmIdentityPageSteps {
    @Page
    SMConfirmIdentityPage smConfirmIdentityPage;

    @Step
    public void enterSSN(String ssn)
    {
        smConfirmIdentityPage.enterSSN(ssn);
    }

    @Step
    public void clickConfirmButton()
    {
        smConfirmIdentityPage.clickConfirmButton();
    }

    @Step
    public boolean isPageShown()
    {
        return smConfirmIdentityPage.isPageShown();
    }
}
