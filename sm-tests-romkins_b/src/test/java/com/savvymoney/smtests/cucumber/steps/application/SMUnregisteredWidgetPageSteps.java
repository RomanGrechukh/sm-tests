package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.WidgetPages.SMUnregisteredWidgetPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMUnregisteredWidgetPageSteps {
    @Page
    SMUnregisteredWidgetPage smUnregisteredWidgetPage;

    @Step
    public void clickCheckYourScoreButton()
    {
        smUnregisteredWidgetPage.clickCheckYourScoreButton();
    }

    @Step
    public boolean isWidgetShown()
    {
       return smUnregisteredWidgetPage.isWidgetShown();
    }
}
