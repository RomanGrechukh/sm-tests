package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.DashboardPage;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage.GeneralPage;
import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import com.savvymoney.smtests.cucumber.utils.Consts;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.concurrent.TimeUnit;

@DefaultUrl("/ui")
public class SMDashboardPage extends AbstractPage {
    private String textScoreValue = "//*[@class='score-rating']";

    @Override
    protected String pageIdentifierXpath() {
        return textScoreValue;
    }

    public String getTextScoreValue(){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWebElement(textScoreValue).getText();
    }

    public void openDashboardPage()
    {
        GeneralPage genPage = new GeneralPage();
        getDriver().navigate().to(Consts.URL);
    }
}