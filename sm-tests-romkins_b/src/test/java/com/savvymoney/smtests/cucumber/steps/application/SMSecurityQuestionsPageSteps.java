package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMSecurityQuestionsPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;

public class SMSecurityQuestionsPageSteps {
    @Page
    SMSecurityQuestionsPage smSecurityQuestionsPage;

    @Step
    public void setAnswers(int numberOfCorrectAnswers){
       smSecurityQuestionsPage.setAnswers(numberOfCorrectAnswers);
    }

    @Step
    public void clickAccessScoreButton() {
        smSecurityQuestionsPage.clickAccessMyScore();
    }

    @Step
    public boolean isBlockedSSNTextDisplayed()
    {
        return smSecurityQuestionsPage.isBlockedSSNTextDisplayed();
    }
}
