package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMForgotPasswordPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMForgotPasswordPageStepDefinition {

    @Steps
    private SMForgotPasswordPageSteps smForgotPasswordPageSteps;

    @And("^User opens forgot password page$")
    public void openLoginPage() {
        smForgotPasswordPageSteps.openForgotPasswordPage();
    }

    @And("^User enters email '(.*)'$")
    public void userEntersEmail(String email) {
        smForgotPasswordPageSteps.userEnterEmail(email);
    }

    @And("^User clicks on Submit button$")
    public void userClicksOnSubmitButton() {
        smForgotPasswordPageSteps.userClicksOnSubmitButton();
    }

    @And("^User clicks on Sign In button$")
    public void userClicksOnSignInButton() {
        smForgotPasswordPageSteps.userClicksOnSignInButton();
    }

    @And("^User verifies error message '(.*)' is displayed$")
    public void userClickOnSubmitButton(String error) {
        Assert.assertEquals(error, smForgotPasswordPageSteps.getErrorMessage());
    }

    @And("^User verifies email is sent to '(.*)'$")
    public void userVerifiesEmailIsSent(String email) {
        Assert.assertTrue(smForgotPasswordPageSteps.isEmailSent(email));
    }

    @And("^User verifies Sign In page is opened$")
    public void userVerifiesSignInPageIsOpened() {
        Assert.assertTrue(smForgotPasswordPageSteps.isLoginPageOpened());
    }

}
