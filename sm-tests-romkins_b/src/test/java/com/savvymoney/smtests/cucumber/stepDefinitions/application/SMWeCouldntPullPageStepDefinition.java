package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMWeCouldntPullPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMWeCouldntPullPageStepDefinition {
    @Steps
    SMWeCouldntPullPageSteps smWeCouldntPullPageSteps;

    @And("^User verifies We couldn't pull your report page is opened$")
    public void userVerifiesWeCouldntPageIsOpened() {
        Assert.assertTrue(smWeCouldntPullPageSteps.textTitleIsVisible());
    }
    @And("^User clicks on verify again button$")
    public void userClicksOnVerifyAgainButton() {
        smWeCouldntPullPageSteps.clickOnVerifyAgainButton();
    }
}
