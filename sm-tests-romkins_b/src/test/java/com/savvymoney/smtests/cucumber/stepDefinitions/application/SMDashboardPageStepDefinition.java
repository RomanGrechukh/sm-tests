package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMDashboardPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SMDashboardPageStepDefinition {
    @Steps
    SMDashboardPageSteps smDashboardPageSteps;

    @And("^And verifies score '(.*)' is shown on dashboard$")
    public void userLogsInWithCredsAndVerifiesNameIsShownOnDashboard(String score) {
        assertThat(smDashboardPageSteps.getScoreValue(), is(score));
    }

    @And("^User opens dashboard page$")
    public void userOpensDashboardPage() {
        smDashboardPageSteps.openDashboardPage();
    }
}
