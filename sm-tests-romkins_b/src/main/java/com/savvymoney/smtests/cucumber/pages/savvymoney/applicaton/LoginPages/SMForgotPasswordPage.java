package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.LoginPages;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/ui/page/181/onboarding/forgot-password")
public class SMForgotPasswordPage extends AbstractPage {

    private String buttonSubmit = "//*[@value='Submit']";
    private String fieldEmail = "//*[@name='email']";
    private String errorMessageDisplayed = "//*[@class='vv-form-error-label d-flex align-items-center ']";
    private String emailSentTitle = "//*[contains(text(),'E-mail sent')]";
    private String emailSentEmailValue = "//*[contains(text(),'E-mail sent')]/following-sibling::p/b";
    private String signInButton = "//*[@class='text-center']/*[contains(text(), 'Sign In')]";

    @Override
    protected String pageIdentifierXpath() {
        return buttonSubmit;
    }

    public void userEntersEmail(String email)
    {
        typeInto(getWebElement(fieldEmail), email);
    }

    public void userClicksOnSubmitButton()
    {
        clickOn(buttonSubmit);
    }

    public void userClicksOnSignInButton()
    {
        clickOn(signInButton);
    }

    public String getErrorMessage()
    {
        waitFor(getWebElement(errorMessageDisplayed));
        String error = getWebElement(errorMessageDisplayed).getText().replace("error\n", "");
        return error;
    }

    public boolean isEmailSent(String email)
    {
        waitFor(getWebElement(emailSentTitle));
        if (getWebElement(emailSentTitle).isDisplayed() && getWebElement(emailSentEmailValue).getText().equals(email))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isLoginPageOpened()
    {
        String url = getDriver().getCurrentUrl();
        String signIn = "sign-in";
        if(url.substring(url.length() - signIn.length()).equals(signIn))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
