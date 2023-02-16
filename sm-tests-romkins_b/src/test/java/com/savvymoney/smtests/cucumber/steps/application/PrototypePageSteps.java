package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.PrototypePage.PrototypePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrototypePageSteps {

    private PrototypePage prototypePage;

    @Step
    public void openPrototypePage() {
        prototypePage.getDriver().get("https://prototype.savvymoney.com/saml/index.html");
        prototypePage.getDriver().manage().window().maximize();
    }

    @Step
    public void login(String uname, String pass) {
        prototypePage.login(uname, pass);
    }

    @Step
    public void selectUserFromDropDown(String user) {
        prototypePage.selectUserFromDropDown(user);
    }

    @Step
    public String getPmid() {
        return prototypePage.getPmid();
    }

    @Step
    public void enterData(List<Map<String, String>> list) {
        List<String> listFields = new ArrayList<>(Arrays.asList("FirstName", "LastName", "Address", "City", "State", "Email", "PMID", "SSN", "Birthday"));
        for (String l : listFields) {
            if (list.get(0).get(l) != null) {
                switch (l) {
                    case "FirstName":
                        prototypePage.userEntersFName(list.get(0).get(l));
                        break;
                    case "LastName":
                        prototypePage.userEntersLName(list.get(0).get(l));
                        break;
                    case "Address":
                        prototypePage.userEntersAdress(list.get(0).get(l));
                        break;
                    case "City":
                        prototypePage.userEntersCity(list.get(0).get(l));
                        break;
                    case "State":
                        prototypePage.userEntersState(list.get(0).get(l));
                        break;
                    case "Email":
                        prototypePage.userEntersEmail(list.get(0).get(l));
                        break;
                    case "PMID":
                        prototypePage.userEntersPmid(list.get(0).get(l));
                        break;
                    case "SSN":
                        prototypePage.userEntersSsn(list.get(0).get(l));
                        break;
                    case "Birthday":
                        prototypePage.userEntersBirthday(list.get(0).get(l));
                        break;
                }

            }
        }
    }

    @Step
    public void selectPartner(String pid) {
        prototypePage.selectPartner(pid);
    }

    @Step
    public void clickOnSubmitButton() {
        prototypePage.clickOnSubmitButton();
    }

    @Step
    public void setRadioUseIframe(String use) {
        prototypePage.setRadioUseIframe(use);
    }

    @Step
    public void selectSsoRelayState(String ssoRelayState) {
        prototypePage.selectSsoRelayState(ssoRelayState);
    }

    @Step
    public void selectSsoServer(String ssoServerState) {
        prototypePage.selectSsoServer(ssoServerState);
    }
}
