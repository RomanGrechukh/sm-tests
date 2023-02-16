package com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.PrototypePage;


import com.savvymoney.smtests.cucumber.utils.CommonUtils;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PrototypePage extends PageObject {
    private String userName = "//*[@id='x-auto-1-input']";
    private String password = "//*[@id='x-auto-2-input']";
    private String loginButton = "//*[@id='login_btn']";
    private String usersDropDown = "//*[@id='x-auto-3-input']";
    private String pid = "//*[@id='x-auto-4-input']";
    private String pmid = "//*[@id='x-auto-5-input']";
    private String fName = "//*[@id='x-auto-6-input']";
    private String lName = "//*[@id='x-auto-7-input']";
    private String address = "//*[@id='x-auto-8-input']";
    private String city = "//*[@id='x-auto-10-input']";
    private String state = "//*[@id='x-auto-11-input']";
    private String zip = "//*[@id='x-auto-12-input']";
    private String email = "//*[@id='x-auto-13-input']";
    private String birthday = "//*[@id='x-auto-14-input']";
    private String ssn = "//*[@id='x-auto-15-input']";
    private String ssoServer = "//*[@id='x-auto-20-input']";
    private String ssoRelayState = "//*[@id='x-auto-21-input']";
    private String useIframe = "//label[contains(text(), 'Use iFrame:')]/following-sibling::div/div/div/div/div/label[contains(text(), '%s')]";
    private String buttonSubmit = "//*[@id='submit_saml_btn']";

    public WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public String getPmid()
    {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(pmid)));
        return findElementByXpath(pmid).getAttribute("value");
    }
    public void clearAndSendKeys(String xpath, String value) {
        findElementByXpath(xpath).clear();
        findElementByXpath(xpath).sendKeys(value);
    }

    public PrototypePage login(String uname, String pass) {
        findElementByXpath(userName).sendKeys(uname);
        findElementByXpath(password).sendKeys(pass);
        findElementByXpath(loginButton).click();
        return this;
    }

    public PrototypePage selectUserFromDropDown(String user) {
        int exceptionCount = 0;
        do {
            try {
                waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(usersDropDown)));
                clearAndSendKeys(usersDropDown, user);
                exceptionCount = 4;
            } catch (StaleElementReferenceException | TimeoutException e) {
                ++exceptionCount;
            }
        } while (exceptionCount <= 3);
        waitForRenderedElements(By.xpath("//*[@class='HJO3OI-tc-a-com-sencha-gxt-theme-triton-client-base-listview-Css3ListViewAppearance-Css3ListViewStyle-item x-view-highlightrow HJO3OI-tc-c-com-sencha-gxt-theme-triton-client-base-listview-Css3ListViewAppearance-Css3ListViewStyle-sel']"));
        findElementByXpath(usersDropDown).sendKeys(Keys.ENTER);
        return this;
    }

    public PrototypePage userEntersFName(String fNameValue) {
        int exceptionCount = 0;
        do {
            try {
                clearAndSendKeys(fName, fNameValue);
                exceptionCount = 4;
            } catch (StaleElementReferenceException e) {
                ++exceptionCount;
            }
        } while (exceptionCount <= 3);
        return this;
    }

    public PrototypePage userEntersLName(String lNameValue) {
        clearAndSendKeys(lName, lNameValue);
        return this;
    }

    public PrototypePage userEntersAdress(String addressValue) {
        clearAndSendKeys(address, addressValue);
        return this;
    }

    public PrototypePage userEntersCity(String cityValue) {
        clearAndSendKeys(city, cityValue);
        return this;
    }

    public PrototypePage userEntersState(String stateValue) {
        clearAndSendKeys(state, stateValue);
        return this;
    }

    public PrototypePage userEntersEmail(String emailValue) {
        clearAndSendKeys(email, emailValue);
        return this;
    }

    public PrototypePage userEntersSsn(String ssnValue) {
        clearAndSendKeys(ssn, ssnValue);
        return this;
    }

    public PrototypePage userEntersPmid(String pmidValue) {
        if(pmidValue.equals(""))
        {
            clearAndSendKeys(pmid, CommonUtils.getRandomString());
        }
        else
        {
            clearAndSendKeys(pmid, pmidValue);
        }
        return this;
    }

    public PrototypePage userEntersBirthday(String birthdayValue) {
        clearAndSendKeys(birthday, birthdayValue);
        return this;
    }

    public PrototypePage clickOnSubmitButton() {
        findElementByXpath(buttonSubmit).click();
        return this;
    }

    public PrototypePage selectPartner(String PID) {
        findElementByXpath(pid).sendKeys(PID);
        waitForRenderedElements(By.xpath("//*[@class='HJO3OI-tc-d-com-sencha-gxt-theme-triton-client-base-listview-Css3ListViewAppearance-Css3ListViewStyle-view HJO3OI-l-r-com-sencha-gxt-core-client-resources-CommonStyles-CommonStylesDefaultAppearance-CommonDefaultStyles-unselectableSingle x-ignore']"));
        findElementByXpath(pid).sendKeys(Keys.ENTER);
        return this;
    }

    public PrototypePage selectSsoRelayState(String ssoRelayStateValue) {
        clearAndSendKeys(ssoRelayState, ssoRelayStateValue);
        findElementByXpath(ssoRelayState).sendKeys(Keys.ENTER);
        return this;
    }

    public PrototypePage selectSsoServer(String ssoServerValue) {
        clearAndSendKeys(ssoServer, ssoServerValue);
        findElementByXpath(ssoServer).sendKeys(Keys.ENTER);
        return this;
    }

    public PrototypePage setRadioUseIframe(String use) {
        findElementByXpath(String.format(useIframe, use)).click();
        return this;
    }
}
