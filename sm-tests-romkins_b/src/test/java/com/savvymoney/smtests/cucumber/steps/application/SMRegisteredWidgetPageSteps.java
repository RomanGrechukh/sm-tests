package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.WidgetPages.SMRegisteredWidgetPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;
import java.util.Map;

public class SMRegisteredWidgetPageSteps {
    @Page
    SMRegisteredWidgetPage smRegisteredWidgetPage;

    @Step
    public Map<String, List<String>> getAllRecommendations(){
        return smRegisteredWidgetPage.getAllRecommendations();
    }

    @Step
    public void clickOnScore(){
        smRegisteredWidgetPage.clickOnScore();
    }

    @Step
    public boolean scoreIsShown(){
        return smRegisteredWidgetPage.scoreIsShown();
    }

    @Step
    public List<Map<String, String>> getRecommendationsAPIResponse(String smtoken) {
        return smRegisteredWidgetPage.getRecommendationsAPIResponse(smtoken);
    }

    @Step
    public String getSmToken() {
       return smRegisteredWidgetPage.getSmToken();
    }

    @Step
    public List<String> getProductTypesFromOfferURLs() {
        return smRegisteredWidgetPage.getProductTypesFromOfferURLs();
    }
}
