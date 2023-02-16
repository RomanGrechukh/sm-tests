package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.LoginPages;

import com.savvymoney.smtests.cucumber.exceptions.ElementNotFoundException;
import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/ui/page/1000/onboarding/sign-in")
public class SMLoginPage extends AbstractPage {

    private String inputLogin = "//*[@name='email']";
    private String inputPassword = "//*[@name='password']";
    private String buttonSignIn = "//*[@value='Sign In']";
    private String errorMessage = "//p[@class='vv-form-error-label d-flex align-items-center ']";
    private String imageBanner = "//*[@class='vv-col-md-6 text-left on-boarding-login-banner']";

    @Override
    protected String pageIdentifierXpath() {
        return inputLogin;
    }

    public void loginUsername(String userName) {
        typeInto(getWebElement(inputLogin), userName);
    }

    public void loginPassword(String password) {
        typeInto(getWebElement(inputPassword), password);
        clickOn(buttonSignIn);
    }

    public void openLoginPageForPid(String pid)
    {
        String defaultUrl = String.format("https://beta.savvymoney.com/ui/page/%s/onboarding/sign-in", pid);
        openAt(defaultUrl);
    }
    public String getErrorMessage() {
        waitFor(errorMessage);
        String error = getTextFrom(errorMessage);
        error=error.replace("error\n", "");
        return error;
    }

    public void userClicksOnBanner() {
        clickOn(imageBanner);
    }

    public boolean userVerifiesBannerIsClickable() {
        try
        {
            getWebElement(imageBanner).click();
            return true;
        }
        catch (ElementNotFoundException e)
        {
            return false;
        }
    }

    public String loginAndGetErrorMessage(String userName, String password) {
        waitFor(getWebElement(inputLogin));
        typeInto(getWebElement(inputLogin), userName);
        typeInto(getWebElement(inputPassword), password);
        clickOn(buttonSignIn);
        return getTextFrom(errorMessage);
    }
}
