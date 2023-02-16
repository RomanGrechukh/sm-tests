package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMConfirmIdentityPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMConfirmIdentityPageStepDefinition {
    @Steps
    SMConfirmIdentityPageSteps smConfirmIdentityPageSteps;

    @And("^User confirms identity with the following SSN: '(.*)'$")
    public void userConfirmsIdentityWithSSN(String ssn){
        smConfirmIdentityPageSteps.enterSSN(ssn);
        smConfirmIdentityPageSteps.clickConfirmButton();
    }

    @And("^User verifies confirm identity page is shown$")
    public void userVerifiesPageIsShown(){
        Assert.assertTrue(smConfirmIdentityPageSteps.isPageShown());
    }
}
