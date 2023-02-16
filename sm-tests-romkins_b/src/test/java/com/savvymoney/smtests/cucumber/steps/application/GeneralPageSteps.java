package com.savvymoney.smtests.cucumber.steps.application;


import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage.GeneralPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class GeneralPageSteps {
    @Page
    private GeneralPage generalPage;

    @Step
    public void switchToBrowserTab(int countOfAlLWindows, int numberOfWindowToSwitch) {
        generalPage.switchToTab(countOfAlLWindows, numberOfWindowToSwitch);
    }

    @Step
    public void switchToBrowserTab(String tabName) {
        generalPage.switchToTab(tabName);
    }

    @Step
    public void makeUrlMockAndRefresh() {
        generalPage.makeUrlMockAndRefresh();
    }
}
