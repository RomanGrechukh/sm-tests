package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.DashboardPage;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMRecommendationBlockDashboard extends PageObject {
    public Map<String, List<String>> getAllRecommendations(){

        Map<String, List<String>> recommendations = new HashMap<>();
        List<WebElement> list;
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-logo ']"));
        List<String> listLogos = new ArrayList<>();
        for (WebElement l : list)
        {
            listLogos.add(l.getAttribute("src"));
        }
        recommendations.put("logos", listLogos);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-value vv-recommendations-value-bottom']"));
        List<String> listAprs = new ArrayList<>();
        for (WebElement l : list)
        {
            listAprs.add(l.getText());
        }
        recommendations.put("aprs", listAprs);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-desc']"));
        List<String> listDescriptions = new ArrayList<>();
        for (WebElement l : list)
        {
            listDescriptions.add(l.getText());
        }
        recommendations.put("descriptions", listDescriptions);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-title']/div"));
        List<String> listTitles = new ArrayList<>();
        for (WebElement l : list)
        {
            listTitles.add(l.getText());
        }
        recommendations.put("titles", listTitles);
        return  recommendations;
    }
}
