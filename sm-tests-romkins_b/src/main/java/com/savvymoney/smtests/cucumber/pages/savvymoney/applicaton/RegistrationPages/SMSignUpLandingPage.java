package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;

import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import com.savvymoney.smtests.cucumber.utils.CommonUtils;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.Random;
@DefaultUrl("/ui/page/151/onboarding/sign-up")
public class SMSignUpLandingPage extends AbstractPage {

    private String inputFName = "//*[@id='firstName']";
    private String inputLName = "//*[@id='lastName']";
    private String inputEmail = "//*[@id='email']";
    private String inputPassword = "//*[@id='password']";
    private String inputConfirPassword = "//*[@id='confirmPassword']";
    private String buttonSignUp = "//*[contains(text(), 'Sign Up and Get your Score')]";

    @Override
    protected String pageIdentifierXpath() {
        return inputConfirPassword;
    }

    public void userEntersFirstName(String fname)
    {
        typeInto(getWebElement(inputFName), fname);
    }

    public void userEntersLastName(String lname)
    {
        typeInto(getWebElement(inputLName), lname);
    }

    public void userEntersEmail(String email)
    {
        StringBuilder string = new StringBuilder(email);
        string.replace(2,2, CommonUtils.getRandomString());
        typeInto(getWebElement(inputEmail), string.toString());
    }

    public void userEntersPassword(String pass)
    {
        typeInto(getWebElement(inputPassword), pass);
    }

    public void userEntersConfirmPassword(String confirmPass)
    {
        typeInto(getWebElement(inputConfirPassword), confirmPass);
    }

    public void userClicksSignUpButton()
    {
        clickOn(buttonSignUp);
    }
}
