package com.savvymoney.smtests.cucumber.stepDefinitions.admin;

import com.savvymoney.smtests.cucumber.steps.admin.SearchUserPageSteps;
import com.savvymoney.smtests.cucumber.steps.admin.UnblockSSNPageSteps;
import com.savvymoney.smtests.cucumber.steps.application.PrototypePageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class UnblockSSNPageStepDefinition {

    @Steps
    UnblockSSNPageSteps unblockSSNPageSteps;
    @Steps
    SearchUserPageSteps searchUserPageSteps;
    @Steps
    PrototypePageSteps prototypePageSteps;

    @And("^User unblocks member")
    public void userUnblockMember() {
        unblockSSNPageSteps.unblockUser(searchUserPageSteps.searchByPMIDandReturnMemberId(prototypePageSteps.getPmid()));
    }
}
