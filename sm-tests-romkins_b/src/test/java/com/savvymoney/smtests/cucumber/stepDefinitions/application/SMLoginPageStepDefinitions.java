package com.savvymoney.smtests.cucumber.stepDefinitions.application;

import com.savvymoney.smtests.cucumber.steps.application.SMLoginPageSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class SMLoginPageStepDefinitions {

    @Steps
    SMLoginPageSteps smLoginPageSteps;

    @And("^User opens login page$")
    public void openLoginPage() {
        smLoginPageSteps.openLoginPage();
    }


    //@And("^User logs in with the following '(.*)' and '(.*)'$")
    // public void loginWithListOfUsernames(String uname, String pass) {
    //
    // for (Map.Entry<String, String> entry : map.entrySet()) {
    //     smLoginPageSteps.login(entry.getKey(), entry.getValue());
    //}
    //}

    //@And("^User logs in with the following username and password and verifies error message is displayed$")
   // public void userLogsInWithCredsAndVerifiesErrorMessage(DataTable dataTable) {
      //  List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
     //   for (int i = 0; i < data.size(); i++) {
     //       String uname = data.get(i).get("username");
     //       String pass = data.get(i).get("password");
      //      String errorMessage = data.get(i).get("errorMessage");
      //      smLoginPageSteps.login(uname, pass);
     //       Assert.assertEquals(errorMessage, smLoginPageSteps.getErrorMessage());
      //  }
    //}

    @And("^User logs in with the following '(.*)'$")
    public void userLogsInWithUsername(String uname) {
        smLoginPageSteps.loginUsername(uname);
    }

    @And("^And '(.*)'$")
    public void userLogsInWithPassword(String password) {
        smLoginPageSteps.loginPassword(password);
    }

    @And("^And verifies '(.*)' is displayed$")
    public void userVerifiesErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, smLoginPageSteps.getErrorMessage());
    }

    @And("^User enters '(.*)', '(.*)' and verifies '(.*)' is displayed$")
    public void blaBla(String a, String b, String errorMessage) {
        Assert.assertEquals(errorMessage, smLoginPageSteps.loginAndGetErrorMessage(a, b));
    }

    @And("^User enters and verifies data from table is displayed$")
    public void blaBlaBla(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for (Map l : list) {
            Assert.assertEquals(l.get("errorMessage").toString(), smLoginPageSteps.loginAndGetErrorMessage(l.get("username").toString(), l.get("password").toString()));
        }
    }

    @And("^User opens login page for '(.*)'$")
    public void userOpensLoginPageForPid(String pid) {
        smLoginPageSteps.openLoginPageForPid(pid);
    }

    @And("^User clicks on banner$")
    public void userClicksOnBanner() {
        smLoginPageSteps.userClicksOnBanner();
    }

    @And("^User verifies banner is clickable '(.*)'$")
    public void userVerifiesBannerIsClickable(String isClickable) {
        Assert.assertTrue(isClickable, smLoginPageSteps.userVerifiesBannerIsClickable());
    }
}
