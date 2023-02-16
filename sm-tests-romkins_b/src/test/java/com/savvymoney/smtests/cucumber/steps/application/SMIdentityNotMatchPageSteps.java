package com.savvymoney.smtests.cucumber.steps.application;

import com.savvymoney.smtests.cucumber.pages.savvymoney.applicaton.RegistrationPages.SMIdentityNotMatchPage;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SMIdentityNotMatchPageSteps {
    @Page
    SMIdentityNotMatchPage smIdentityNotMatchPage;

    public boolean isErrorTextShown()
    {
        return smIdentityNotMatchPage.isErrorTextShown();
    }

    public boolean isUrlCorrect()
    {
       return smIdentityNotMatchPage.isUrlCorrect();
    }
}
