package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.LoginPages.SMForgotPasswordPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMForgotPasswordPageSteps {

    @Page
    SMForgotPasswordPage smForgotPasswordPage;

    @Step
    public void openForgotPasswordPage() {
        smForgotPasswordPage.open();
    }

    @Step
    public void userEnterEmail(String email) {
        smForgotPasswordPage.userEntersEmail(email);
    }

    @Step
    public void userClicksOnSubmitButton() {
        smForgotPasswordPage.userClicksOnSubmitButton();
    }

    @Step
    public void userClicksOnSignInButton() {
        smForgotPasswordPage.userClicksOnSignInButton();
    }

    @Step
    public String getErrorMessage() {
         return smForgotPasswordPage.getErrorMessage();
    }

    @Step
    public boolean isEmailSent(String email) {
        return smForgotPasswordPage.isEmailSent(email);
    }

    @Step
    public boolean isLoginPageOpened() {
        return smForgotPasswordPage.isLoginPageOpened();
    }
}
