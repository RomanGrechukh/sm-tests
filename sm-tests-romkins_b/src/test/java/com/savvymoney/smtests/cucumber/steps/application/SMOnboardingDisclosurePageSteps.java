package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMOnboardingDisclosurePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;
import java.util.Map;

public class SMOnboardingDisclosurePageSteps {
    @Page
    SMOnboardingDisclosurePage smOnboardingDisclosurePage;

    @Step
    public void userEntersAddress(String address) {
        smOnboardingDisclosurePage.enterAddress(address);
    }

    @Step
    public void userEntersCity(String city) {
        smOnboardingDisclosurePage.enterCity(city);
    }

    @Step
    public void userSelectsState(String state) {
        smOnboardingDisclosurePage.selectState(state);
    }

    @Step
    public void userEntersZip(String zip) {
        smOnboardingDisclosurePage.enterZip(zip);
    }

    @Step
    public void userEntersDob(String dob) {
        smOnboardingDisclosurePage.enterDOB(dob);
    }

    @Step
    public void userEntersSsn(String ssn) {
        smOnboardingDisclosurePage.enterSSN(ssn);
    }

    @Step
    public String getAuthText() {
        return smOnboardingDisclosurePage.getAuthText();
    }

    @Step
    public String getFname() {
        return smOnboardingDisclosurePage.getFname();
    }

    @Step
    public String getLname() {
        return smOnboardingDisclosurePage.getLname();
    }

    @Step
    public void setAuthCheckbox() {
        smOnboardingDisclosurePage.setAuth();
    }

    @Step
    public void clickOnContinueButton() {
        smOnboardingDisclosurePage.clickOnContinueButton();
    }

    @Step
    public List<String> checkEmptyFieldsAndReturn() {
        return smOnboardingDisclosurePage.checkEmptyFieldsAndReturn();
    }

    @Step
    public void fillEmptyValues(List<Map<String, String>> listOfValuesToFill) {
        smOnboardingDisclosurePage.fillEmptyValues(listOfValuesToFill);
    }
}
