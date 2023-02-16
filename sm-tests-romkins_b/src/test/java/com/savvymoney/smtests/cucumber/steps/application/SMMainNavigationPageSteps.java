package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.SMMainNavigationPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMMainNavigationPageSteps {
    @Page
    SMMainNavigationPage smMainNavigationPage;

    @Step
    public void clickOnMenuItem(String itemName)
    {
        smMainNavigationPage.clickOnMenuItem(itemName);
    }
}
