package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.LoginPages.SMLoginPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SMLoginPageSteps {

    @Page
    SMLoginPage smLoginPage;

    @Step
    public void openLoginPage() {
        smLoginPage.open();
    }

    @Step
    public void openLoginPageForPid(String pid) {
        smLoginPage.openLoginPageForPid(pid);
    }

    @Step
    public void userClicksOnBanner() {
        smLoginPage.userClicksOnBanner();
    }

    @Step
    public boolean userVerifiesBannerIsClickable() {
        return smLoginPage.userVerifiesBannerIsClickable();
    }

    @Step
    public void loginUsername(String userName) {
        smLoginPage.loginUsername(userName);
    }

    @Step
    public void loginPassword(String userName) {
        smLoginPage.loginPassword(userName);
    }

    @Step
    public String getErrorMessage() {
       return smLoginPage.getErrorMessage();
    }

    @Step
    public String loginAndGetErrorMessage(String b, String f) {
        return smLoginPage.loginAndGetErrorMessage(b, f);
    }

}
