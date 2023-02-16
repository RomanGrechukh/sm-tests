package com.savvymoney.smtests.cucumber.steps.admin;

import com.savvymoney.smtests.cucumber.pages.savvymoney.admin.SearchUserPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SearchUserPageSteps {
    @Page
    SearchUserPage searchUserPage;

    @Step
    public String searchByPMIDandReturnMemberId(String pmid)
    {
        return searchUserPage.searchByPMIDandReturnMemberId(pmid);
    }
}
