package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.WidgetPages;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.*;

public class SMRegisteredWidgetPage extends PageObject {
    @FindBy(xpath = "//*[@class='score-rating text-right']")
    WebElement score;
    private String linkGetOffer = "//*[@class='carousel-inner']/div[%s]/div/a";

    public Map<String, List<String>> getAllRecommendations() {
        Map<String, List<String>> recommendations = new HashMap<>();
        List<WebElement> list;
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-logo ']"));
        List<String> listLogos = new ArrayList<>();
        for (WebElement l : list) {
            listLogos.add(l.getAttribute("src"));
        }
        recommendations.put("logos", listLogos);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-value vv-recommendations-value-bottom']"));
        List<String> listAprs = new ArrayList<>();
        for (WebElement l : list) {
            listAprs.add(l.getText());
        }
        recommendations.put("aprs", listAprs);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-desc']"));
        List<String> listDescriptions = new ArrayList<>();
        for (WebElement l : list) {
            listDescriptions.add(l.getText());
        }
        recommendations.put("descriptions", listDescriptions);

        list.clear();
        list = getDriver().findElements(By.xpath("//*[@class='vv-recommendations-title']/div"));
        List<String> listTitles = new ArrayList<>();
        for (WebElement l : list) {
            listTitles.add(l.getText());
        }
        recommendations.put("titles", listTitles);
        return recommendations;
    }

    public void clickOnScore() {
        waitFor(ExpectedConditions.elementToBeClickable(score));
        score.click();
    }

    public boolean scoreIsShown() {
        waitFor(ExpectedConditions.visibilityOf(score));
        if (score.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getSmToken() {
        String URL = getDriver().getCurrentUrl();
        return URL.substring(URL.indexOf("page/") + 5, URL.lastIndexOf("/"));
    }

    public List<Map<String, String>> getRecommendationsAPIResponse(String smtoken) {
        Response response = given()
                .header("X-Auth-Token", smtoken)
                .when()
                .get("https://beta.savvymoney.com/presentation/offers/recommendations");
        return response
                .jsonPath()
                .getList("recommendations");
    }

    public List<String> getProductTypesFromOfferURLs() {
        List<String> listProductTypes = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            WebElement element = getDriver().findElement(By.xpath(String.format(linkGetOffer, i+1)));
            String link = element.getAttribute("href");
            listProductTypes.add(link.substring(link.lastIndexOf("%2F") + 3));
            if(listProductTypes.get(i).isEmpty())
            {
                listProductTypes.add(i, link.substring(link.lastIndexOf("%3Fl%3D%2F")  + 10).replace("%2F", "/"));
            }
        }
        listProductTypes.remove(4);
        return listProductTypes;
    }
}
