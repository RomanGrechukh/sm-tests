package com.savvymoney.smtests.cucumber.steps.admin;

import com.savvymoney.smtests.cucumber.pages.savvymoney.admin.UnblockSSNPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class UnblockSSNPageSteps {
    @Page
    UnblockSSNPage unblockSSNPage = new UnblockSSNPage();

    @Step
    public void unblockUser(String memberID)
    {
        unblockSSNPage.unblockUser(memberID);
    }

    @Step
    public boolean isUserBlocked(String memberID)
    {
        return unblockSSNPage.isUserBlocked(memberID);
    }
}
