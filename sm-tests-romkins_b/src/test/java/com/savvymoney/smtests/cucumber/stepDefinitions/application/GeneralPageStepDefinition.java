package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage.GeneralPage;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class GeneralPageStepDefinition {
    @Steps
    GeneralPage generalPage;

    @And("^User switches to tab '(.*)' having in general '(.*)' tabs$")
    public void userSwitchesToRegistrationTab(int numberOfWindowsToSwitch, int countOfAllWindows) {
        generalPage.switchToTab(countOfAllWindows,numberOfWindowsToSwitch);
    }

    @And("^User switches to tab '(.*)'$")
    public void userSwitchesToRegistrationTab(String tabName) {
        generalPage.switchToTab(tabName);
    }

    @And("^User makes URL mock and refresh a page$")
    public void userSMakesUrlMockAndRefreshAPage() {
        generalPage.makeUrlMockAndRefresh();
    }
}
