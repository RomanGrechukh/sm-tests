package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.GeneralPage;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralPage extends PageObject {
    public void switchToTab(int countOfAllWindows, int numberOfWindowToSwitch) {
        numberOfWindowToSwitch = numberOfWindowToSwitch - 1;
        waitFor(ExpectedConditions.numberOfWindowsToBe(countOfAllWindows));
        ArrayList<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(handles.get(numberOfWindowToSwitch));
    }

    public void makeUrlMockAndRefresh() {
        getDriver().navigate().to(getDriver().getCurrentUrl().concat("?mock=true"));
        getDriver().navigate().refresh();
    }

    public void switchToTab(String tabName) {
        Map<Integer, String> mapURLs = new HashMap<>();
        ArrayList<String> handles = new ArrayList<>(getDriver().getWindowHandles());
        for (int i = 0; i < handles.size(); i++) {
            mapURLs.put(i, getDriver().switchTo().window(handles.get(i)).getCurrentUrl());
        }
        //TODO : remove wait and i
        int i = 0;
        waitABit(5000);
        switch (tabName) {
            case "Application":
                for (Map.Entry<Integer, String> entry : mapURLs.entrySet()) {
                    if (entry.getValue().contains("credit-score") || entry.getValue().contains("onboarding") || entry.getValue().contains("web")) {
                        getDriver().switchTo().window(handles.get(entry.getKey()));
                        i++;
                        break;
                    }
                }
                break;
            case "Widget":
                for (Map.Entry<Integer, String> entry : mapURLs.entrySet()) {
                    if (entry.getValue().contains("widget")) {
                        getDriver().switchTo().window(handles.get(entry.getKey()));
                        i++;
                        break;
                    }
                }
                break;
            case "SAML":
                for (Map.Entry<Integer, String> entry : mapURLs.entrySet()) {
                    if (entry.getValue().contains("prototype")) {
                        getDriver().switchTo().window(handles.get(entry.getKey()));
                        i++;
                        break;
                    }
                }
                break;
            default: throw new RuntimeException("can't recognize tab name : " + tabName);
        }
        if (i == 0) {
            System.out.println("No such tab found. Please check spelling");
        }

    }
}
