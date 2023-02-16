package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.GeneralPageSteps;
import com.savvymoney.smtests.cucumber.steps.application.SMDashboardPageSteps;
import com.savvymoney.smtests.cucumber.steps.application.SMRegisteredWidgetPageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SMRegisteredWidgetPageStepDefinition {
    @Steps
    SMRegisteredWidgetPageSteps smRegisteredWidgetPageSteps;
    @Steps
    SMDashboardPageSteps smDashboardPageSteps;
    @Steps
    GeneralPageSteps generalPageSteps;

    @And("^User clicks on Score button on widget$")
    public void userClicksOnContinueButton() {
        smRegisteredWidgetPageSteps.clickOnScore();
    }

    @And("^User verifies score is shown on registered widget$")
    public void userVerifiesScoreIsShownOnRegisteredWidget() {
        smRegisteredWidgetPageSteps.scoreIsShown();
    }

    @And("^User verifies recommendation block data on dashboard matches recommendation block data on widget$")
    public void userVerifiesRecommendationBlockDataOnDashboardMatchesRecommendationBlockDataOnWidget(){
        Map<String, List<String>> widgetRecommendationData =  smRegisteredWidgetPageSteps.getAllRecommendations();
        generalPageSteps.switchToBrowserTab(3, 3);
        Map<String, List<String>> dashboardRecommendationData =  smDashboardPageSteps.getAllRecommendations();
        Assert.assertEquals(widgetRecommendationData.get("logos"), dashboardRecommendationData.get("logos"));
        Assert.assertEquals(widgetRecommendationData.get("aprs"), dashboardRecommendationData.get("aprs"));
    }

    @And("^User verifies links on Get Offer buttons are correct according to product types$")
    public void userVerifiesLinksOnGetOfferButtonsAreCorrectAccordingToProductTypes() {
        List<Map<String, String>> list = smRegisteredWidgetPageSteps.getRecommendationsAPIResponse(smRegisteredWidgetPageSteps.getSmToken());
        List<String> listProductTypesFromOfferURLs = smRegisteredWidgetPageSteps.getProductTypesFromOfferURLs();
        int i=0;
        for(Map<String, String> map : list)
        {
            if(map.get("offerType")==null)
            {
                switch(map.get("description"))
                {
                    case "Shave dollars off your monthly car payment" : Assert.assertTrue(listProductTypesFromOfferURLs.get(i).equals("blog/debt/refinancing-your-car-loan/"));
                    break;
                }
                break;
            }
            switch(map.get("offerType"))
            {
                case "LOW_INTEREST_CC" : Assert.assertTrue(listProductTypesFromOfferURLs.get(i).equals("credit-cards"));
                break;
                case "HOME_EQUITY_LOAN" : Assert.assertTrue(listProductTypesFromOfferURLs.get(i).equals("home-loans"));
                break;
                case "OTHER_OFFER" : Assert.assertTrue(listProductTypesFromOfferURLs.get(i).equals("other-loans"));
                break;
            }
            i++;
        }
    }
}