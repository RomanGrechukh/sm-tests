package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMNewAutoLoansPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMNewAutoLoansPageStepDefinition {
    @Steps
    SMNewAutoLoansPageSteps smNewAutoLoansPageSteps;

    @And("^User verifies title is visible$")
    public void userVerifiesTitleIsVisible(){
       Assert.assertTrue(smNewAutoLoansPageSteps.isTitleVisible());
    }
}
