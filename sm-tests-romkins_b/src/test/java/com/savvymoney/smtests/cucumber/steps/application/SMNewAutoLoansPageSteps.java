package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.OfferPages.SMNewAutoLoansPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMNewAutoLoansPageSteps {
    @Page
    SMNewAutoLoansPage smNewAutoLoansPage;

    @Step
    public boolean isTitleVisible()
    {
        return smNewAutoLoansPage.isTitleVisible();
    }

}
