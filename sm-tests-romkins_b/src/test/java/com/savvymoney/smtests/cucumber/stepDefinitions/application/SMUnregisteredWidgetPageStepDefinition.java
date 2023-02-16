package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage.GeneralPage;
import com.savvymoney.smtests.cucumber.steps.application.SMUnregisteredWidgetPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMUnregisteredWidgetPageStepDefinition {
    @Steps
    SMUnregisteredWidgetPageSteps smUnregisteredWidgetPageSteps;
    @Steps
    GeneralPage generalPage;

    @And("^User clicks on check your score button$")
    public void userClicksOnCheckYourScoreButton() {
        smUnregisteredWidgetPageSteps.clickCheckYourScoreButton();
    }

    @And("^User verifies unregistered widget is shown$")
    public void userVerifiesUnregisteredWidgetIsShown() {
        Assert.assertTrue( smUnregisteredWidgetPageSteps.isWidgetShown());
    }
}
