package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMMainNavigationPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;


public class SMMainNavigationPageStepDefinition {
    @Steps
    SMMainNavigationPageSteps smMainNavigationPageSteps;

    @And("^User clicks on menu item with name '(.*)'$")
    public void userClicksOnMenuItemWithName(String itemName){
        smMainNavigationPageSteps.clickOnMenuItem(itemName);
    }
}
