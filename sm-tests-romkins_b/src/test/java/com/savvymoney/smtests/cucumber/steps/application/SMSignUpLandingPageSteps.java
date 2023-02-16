package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMSignUpLandingPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMSignUpLandingPageSteps {

    @Page
    SMSignUpLandingPage smSignUpLandingPage;

    @Step
    public void openSignUpLandingPage() {
        smSignUpLandingPage.open();
        smSignUpLandingPage.getDriver().manage().window().maximize();
    }

    @Step
    public void userEntersFirstName(String fName) {
        smSignUpLandingPage.userEntersFirstName(fName);
    }

    @Step
    public void userEntersLastName(String lName) {
        smSignUpLandingPage.userEntersLastName(lName);
    }

    @Step
    public void userEntersEmail(String email) {
        smSignUpLandingPage.userEntersEmail(email);
    }

    @Step
    public void userEntersPassword(String password) {
        smSignUpLandingPage.userEntersPassword(password);
    }

    @Step
    public void userEntersConfirmPassword(String confirmPassword) {
        smSignUpLandingPage.userEntersConfirmPassword(confirmPassword);
    }

    @Step
    public void userClicksSignUpButton() {
        smSignUpLandingPage.userClicksSignUpButton();
    }
}
