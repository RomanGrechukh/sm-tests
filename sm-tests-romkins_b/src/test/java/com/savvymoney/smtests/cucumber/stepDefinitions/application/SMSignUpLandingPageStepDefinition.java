package com.savvymoney.smtests.cucumber.stepDefinitions.application;


import com.savvymoney.smtests.cucumber.steps.application.SMSignUpLandingPageSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class SMSignUpLandingPageStepDefinition {
    @Steps
    private SMSignUpLandingPageSteps smSignUpLandingPageSteps;

    @And("^User opens sign up page$")
    public void openSignUpLandingPage() {
       smSignUpLandingPageSteps.openSignUpLandingPage();
    }

    @And("^User enters firstName, lastName, email, password, confirmPassword$")
    public void userLogsInWithUsername(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map l : list) {
           smSignUpLandingPageSteps.userEntersFirstName(l.get("firstName").toString());
           smSignUpLandingPageSteps.userEntersLastName(l.get("lastName").toString());
           smSignUpLandingPageSteps.userEntersEmail(l.get("email").toString());
           smSignUpLandingPageSteps.userEntersPassword(l.get("password").toString());
           smSignUpLandingPageSteps.userEntersConfirmPassword(l.get("confirmPassword").toString());
        }
    }

    @And("^User clicks on Sign Up button$")
    public void userLogsInWithUsername() {
        smSignUpLandingPageSteps.userClicksSignUpButton();
    }
}
