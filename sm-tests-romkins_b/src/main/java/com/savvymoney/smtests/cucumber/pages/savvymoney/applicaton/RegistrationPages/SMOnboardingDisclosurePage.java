package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages;

import com.savvymoney.smtests.cucumber.exceptions.ElementNotFoundException;
import com.savvymoney.smtests.cucumber.utils.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.seleniumhq.jetty9.util.log.Log;

import java.util.*;
import java.util.logging.Logger;

@DefaultUrl("/ui/page/149/onboarding/sign-up")
public class SMOnboardingDisclosurePage extends AbstractPage {

    private String inputFirstName = "//*[@id='firstName']";
    private String inputLastName = "//*[@id='lastName']";
    private String inputAddress = "//*[@id='address']";
    private String inputCity = "//*[@id='city']";
    private String inputEmail = "//*[@id='email']";
    private String dropdownState = "//*[@id='state']";
    private String inputZip = "//*[@id='zipCode']";
    private String inputDOB = "//*[@id='dateOfBirth']";
    private String inputSSN = "//*[@id='ssn']";
    private String checkboxAuth = "//*[@class='vv-form-control-icon material-icons']";
    private String namesInTitle = "//*[@class='vv-blue-title']";
    private String textAuth = "//*[@class='vv-form-check-label']/span";
    private String buttonSubmit = "//*[@class='vv-btn w-100 vv-btn-big d-inline-block ']";

    @Override
    protected String pageIdentifierXpath() {
        return inputSSN;
    }

    public List<String> checkEmptyFieldsAndReturn() {
        List<String> listEmptyFields = new ArrayList<>();
        List<String> locators = Arrays.asList(inputFirstName, inputLastName, inputAddress, inputCity, inputEmail, dropdownState, inputZip, inputDOB, inputSSN);

        for (String l : locators) {
            try {
                if (getWebElement(l).getAttribute("value").isEmpty() && getWebElement(l).isDisplayed()) {
                    listEmptyFields.add(getWebElement(l + "/parent::div/parent::div/preceding-sibling::label").getText());
                }
            } catch (ElementNotFoundException e) {
                continue;
            }
        }
        return listEmptyFields;
    }

    public void fillEmptyValues(List<Map<String, String>> listOfValuesToFill) {
        for (Map<String, String> mapElement : listOfValuesToFill) {
            for (Map.Entry<String, String> entry : mapElement.entrySet()) {
                try {
                    getWebElement(String.format("//label[contains(text(), '%s')]/parent::div/div/div/input", entry.getKey())).sendKeys(entry.getValue());
                }
                catch (ElementNotFoundException e)
                {
                    System.out.println("Element not found");
                }
            }
        }
    }

    public void enterAddress(String address) {
        typeInto(getWebElement(inputAddress), address);
    }

    public void enterFName(String fName) {
        typeInto(getWebElement(inputFirstName), fName);
    }

    public void enterLName(String lName) {
        typeInto(getWebElement(inputLastName), lName);
    }

    public void enterCity(String city) {
        typeInto(getWebElement(inputCity), city);
    }

    public void selectState(String state) {
        typeInto(getWebElement(dropdownState), state);
    }

    public void enterZip(String zip) {
        typeInto(getWebElement(inputZip), zip);
    }

    public void enterDOB(String dob) {
        typeInto(getWebElement(inputDOB), dob);
    }

    public void enterSSN(String ssn) {
        typeInto(getWebElement(inputSSN), ssn);
    }

    public void setAuth() {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(checkboxAuth)));
        setCheckbox(getWebElement(checkboxAuth), true);
    }

    public String getFname() {
        String title = getWebElement(namesInTitle).getText();
        int index = title.substring(6).indexOf(" ");
        return title.substring(0, index - 1);
    }

    public String getLname() {
        String title = getWebElement(namesInTitle).getText();
        int index = title.substring(6).indexOf(" ");
        return title.substring(index, title.length());
    }

    public String getAuthText() {
        return getWebElement(textAuth).getText();
    }

    public void clickOnContinueButton() {
        clickOn(buttonSubmit);
    }

}
