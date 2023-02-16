package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.DashboardPage.SMDashboardPage;
import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.DashboardPage.SMRecommendationBlockDashboard;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.List;
import java.util.Map;

public class SMDashboardPageSteps {
    @Page
    SMDashboardPage smDashboardPage;
    @Page
    SMRecommendationBlockDashboard smRecommendationBlockDashboard;

    @Step
    public String getScoreValue(){
        return smDashboardPage.getTextScoreValue();
    }

    @Step
    public Map<String, List<String>> getAllRecommendations(){
        return smRecommendationBlockDashboard.getAllRecommendations();
    }

    @Step
    public void openDashboardPage()
    {
        smDashboardPage.openDashboardPage();
    }

}
