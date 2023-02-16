package com.savvymoney.smtests.cucumber.stepDefinitions.admin;

import com.savvymoney.smtests.cucumber.steps.admin.SearchUserPageSteps;
import com.savvymoney.smtests.cucumber.steps.admin.UnblockSSNPageSteps;
import com.savvymoney.smtests.cucumber.steps.application.PrototypePageSteps;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class SearchUserPageStepDefinition {
    @Steps
    SearchUserPageSteps searchUserPageSteps;
    @Steps
    UnblockSSNPageSteps unblockSSNPageSteps;
    @Steps
    PrototypePageSteps prototypePageSteps;

    @And("^User verifies member is not blocked and unblocks if blocked")
    public void userVerifiesMemberIsNotBlocked() {
        if(unblockSSNPageSteps.isUserBlocked(searchUserPageSteps.searchByPMIDandReturnMemberId(prototypePageSteps.getPmid())))
        {
            unblockSSNPageSteps.unblockUser(searchUserPageSteps.searchByPMIDandReturnMemberId(prototypePageSteps.getPmid()));
        }
        Assert.assertFalse(unblockSSNPageSteps.isUserBlocked(searchUserPageSteps.searchByPMIDandReturnMemberId(prototypePageSteps.getPmid())));
    }

}
