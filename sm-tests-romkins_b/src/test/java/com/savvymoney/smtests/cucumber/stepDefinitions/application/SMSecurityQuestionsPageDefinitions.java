package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMSecurityQuestionsPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SMSecurityQuestionsPageDefinitions {

    @Steps
    SMSecurityQuestionsPageSteps smSecurityQuestionsPageSteps;

    @And("^User answers questions with '(.*)' correct answers$")
    public void userAnswearsQuestions(int numberOfCorrectAnswers){
        smSecurityQuestionsPageSteps.setAnswers(numberOfCorrectAnswers);
        smSecurityQuestionsPageSteps.clickAccessScoreButton();
    }

    @And("^User answers additional question with '(.*)' correct answers$")
    public void userAnswearsAdditionalQuestion(int numberOfCorrectAnswers){
        smSecurityQuestionsPageSteps.setAnswers(numberOfCorrectAnswers);
        smSecurityQuestionsPageSteps.clickAccessScoreButton();
    }

    @And("^User verified blocked SSN text is displayed$")
    public void userVerifiedBlockedSSNTextIsDisplayed(){
        Assert.assertTrue(smSecurityQuestionsPageSteps.isBlockedSSNTextDisplayed());
    }
}
