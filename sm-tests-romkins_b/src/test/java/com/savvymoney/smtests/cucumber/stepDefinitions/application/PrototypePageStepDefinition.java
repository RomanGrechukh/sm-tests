package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage.GeneralPage;
import com.savvymoney.smtests.cucumber.steps.application.PrototypePageSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class PrototypePageStepDefinition {

    @Steps
    PrototypePageSteps prototypePageSteps;
    GeneralPage generalPage;

    @And("^User opens SAML page$")
    public void userOpensSamlPage() {
        prototypePageSteps.openPrototypePage();
    }

    @And("^User logs in to SAML$")
    public void userLogsInToSaml() {
        prototypePageSteps.login("rhrechukh","pOntiag2008");
    }

    @And("^User selects user '(.*)' from drop down$")
    public void userSelectUserFromDropDown(String user) {
        prototypePageSteps.selectUserFromDropDown(user);
    }

    @And("^User enters user data$")
    public void userEntersUserData(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        prototypePageSteps.enterData(list);
    }

    @And("^User selects partner '(.*)' from drop down$")
    public void userSelectPartner(String partnerId) {
        prototypePageSteps.selectPartner(partnerId);
    }

    @And("^User selects whether to use Iframe or not '(.*)', SSO Relay state '(.*)', SSO Server '(.*)'$")
    public void userSelectsWhetherToUseIframeOrNotAndStateAndServer(String use, String state, String server) {
        prototypePageSteps.setRadioUseIframe(use);
        prototypePageSteps.selectSsoRelayState(state);
        prototypePageSteps.selectSsoServer(server);
    }

    @And("^User clicks on SAML submit button$")
    public void userClicksOnSubmitButton() {
        prototypePageSteps.clickOnSubmitButton();
    }

    @And("^User switches to SM application tab$")
    public void userSwitchesToSMApplicationTab(){
        generalPage.switchToTab(2, 2);
    }
}
