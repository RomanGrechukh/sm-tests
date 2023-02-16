package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMIdentityNotMatchPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMIdentityNotMatchStepDefinition {
    @Steps
    SMIdentityNotMatchPageSteps smIdentityNotMatchPageSteps;

    @And("^User verifies Identity not match page is shown$")
    public void userVerifiesIdentityNotMatchPageIsShown() {
       Assert.assertTrue(smIdentityNotMatchPageSteps.isErrorTextShown());
       Assert.assertTrue(smIdentityNotMatchPageSteps.isUrlCorrect());
    }
}
