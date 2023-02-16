package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SMMainNavigationPage extends PageObject {
    private String creditScoreNavItem = "//button[contains(text(),'Credit Score')]";
    private String creditReportNavItem = "//button[contains(text(),'Credit Report')]";
    private String moreOffersDropDown = "//div[contains(text(), 'More Offers')]";
    private String resourcesDropDown = "//div[contains(text(), 'Resources')]";
    private String creditCardsDropDown = "//div[contains(text(), 'Credit Cards')]/parent::div[@class='d-none d-xmd-block vv-navbar-item has-items']";
    private String autoLoansDropDown = "//div[contains(text(), 'Auto Loans')]/parent::div[@class='d-none d-xmd-block vv-navbar-item has-items']";
    private String personalLoansDropDown = "//div[contains(text(), 'Personal Loans')]/parent::div[@class='d-none d-xmd-block vv-navbar-item has-items']";
    private String studentLoansNavItem = "//button[contains(text(),'Student Loans')]";
    private String homeLoansNavItem = "//button[contains(text(),'Home Loans')]";
    private String otherLoansNavItem = "//button[contains(text(),'Other Loans')]";
    private String dropDownItemPattern = "//div[@class='d-none d-xmd-block vv-navbar-item hovered has-items']/div[contains(text(), '%s')]/following-sibling::div/div/div/div/div/button[contains(text(), '%s')]";
    private List<String> listDropDownItems = new ArrayList<String>(Arrays.asList("New Auto Loans",
            "Refinance Auto Loans",
            "All Credit Cards",
            "Balance Transfer",
            "New Personal Loans",
            "Debt Consolidation"));

    private WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    private void selectDropDownMenuItem(String itemName) {
        Actions actions = new Actions(getDriver());
        switch (itemName) {
            case "New Auto Loans":
                actions.moveToElement(findElementByXpath(autoLoansDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Auto Loans", "New Auto Loans")));
                break;
            case "Refinance Auto Loans":
                actions.moveToElement(findElementByXpath(autoLoansDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Auto Loans", "Refinance Auto Loans")));
                break;
            case "All Credit Cards":
                actions.moveToElement(findElementByXpath(creditCardsDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Credit Cards", "All Credit Cards")));
                break;
            case "Balance Transfer":
                actions.moveToElement(findElementByXpath(creditCardsDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Credit Cards", "Balance Transfer")));
                break;
            case "New Personal Loans":
                actions.moveToElement(findElementByXpath(personalLoansDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Personal Loans", "New Personal Loans")));
                break;
            case "Debt Consolidation":
                actions.moveToElement(findElementByXpath(personalLoansDropDown)).perform();
                clickOn(findElementByXpath(String.format(dropDownItemPattern, "Personal Loans", "Debt Consolidation")));
                break;
            default:
        }
    }

    public void clickOnMenuItem(String itemName) {
        if (listDropDownItems.contains(itemName)) {
            selectDropDownMenuItem(itemName);
        } else {
            switch (itemName) {
                case "Credit Score":
                    clickOn(findElementByXpath(creditScoreNavItem));
                    break;
                case "Credit Report":
                    clickOn(findElementByXpath(creditReportNavItem));
                    break;
                case "Student Loans":
                    clickOn(findElementByXpath(studentLoansNavItem));
                    break;
                case "Home Loans":
                    clickOn(findElementByXpath(homeLoansNavItem));
                    break;
                case "Other Loans":
                    clickOn(findElementByXpath(otherLoansNavItem));
                    break;
                default:
            }
        }
    }
}
