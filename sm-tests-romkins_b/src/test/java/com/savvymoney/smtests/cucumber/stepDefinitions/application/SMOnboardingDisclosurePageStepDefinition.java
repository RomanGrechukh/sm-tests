package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMOnboardingDisclosurePageSteps;
import com.savvymoney.smtests.cucumber.steps.application.SMWeCouldntPullPageSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SMOnboardingDisclosurePageStepDefinition {
    @Steps
    private SMOnboardingDisclosurePageSteps smOnboardingDisclosurePageSteps;
    private SMWeCouldntPullPageSteps smWeCouldntPullPageSteps;

    @And("^User enters address, city, state, zip, dob, ssn$")
    public void userLogsInWithUsername(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map m : list) {
            smOnboardingDisclosurePageSteps.userEntersAddress(m.get("address").toString());
            smOnboardingDisclosurePageSteps.userEntersCity(m.get("city").toString());
            smOnboardingDisclosurePageSteps.userSelectsState(m.get("state").toString());
            smOnboardingDisclosurePageSteps.userEntersZip(m.get("zip").toString());
            smOnboardingDisclosurePageSteps.userEntersDob(m.get("dob").toString());
            smOnboardingDisclosurePageSteps.userEntersSsn(m.get("ssn").toString());
        }
    }

    @And("^User verifies I authorize text$")
    public void userVerifiesAuthText() {
        String authTextExp = "< DISCLOSURE IS NOT SET >";
        Assert.assertEquals(authTextExp, smOnboardingDisclosurePageSteps.getAuthText());
    }

    @And("^User sets auth checkbox$")
    public void userSetAuthCheckbox() {
        smOnboardingDisclosurePageSteps.setAuthCheckbox();
    }

    @And("^User clicks on Continue button$")
    public void userClicksOnContinueButton() {
        smOnboardingDisclosurePageSteps.clickOnContinueButton();
    }

    @And("^User verifies corresponding empty fields are shown$")
    public void userVerifiesCorrespondingEmptyFieldsAreShown(DataTable dt) {
        List<String> listOfExpectedEmptyField = dt.asList(String.class);
        Assert.assertTrue(listOfExpectedEmptyField.containsAll(smOnboardingDisclosurePageSteps.checkEmptyFieldsAndReturn()) && smOnboardingDisclosurePageSteps.checkEmptyFieldsAndReturn().containsAll(listOfExpectedEmptyField));
    }

    @And("^User fills empty fields$")
    public void userFillsEmptyFields(DataTable dt) {
        List<Map<String, String>> listOfValuesToFill = dt.asMaps(String.class, String.class);
        smOnboardingDisclosurePageSteps.fillEmptyValues(listOfValuesToFill);
    }
}
