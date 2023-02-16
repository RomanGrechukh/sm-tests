package com.savvymoney.smtests.cucumber.pages.savvymoney.admin;

import com.savvymoney.smtests.cucumber.restClient.MemberFilterDTO;
import com.savvymoney.smtests.cucumber.restClient.MemberSearchDTO;
import com.savvymoney.smtests.cucumber.restClient.MembershipAdminRestClientTest;

import java.util.Map;

public class SearchUserPage {
    private static MembershipAdminRestClientTest client = new MembershipAdminRestClientTest("http://internal-sandbox-alb-internal-v2-1230194207.us-east-1.elb.amazonaws.com/membership-admin/admin");

    public static String searchByPMIDandReturnMemberId(String pmid) {
        MemberFilterDTO memberfilterDTO = new MemberFilterDTO();
        memberfilterDTO.setPartnerMemberId(pmid);
        Map<String, MemberSearchDTO> map =  client.memberSearchCall(memberfilterDTO);
        return String.valueOf(map.keySet().iterator().next());
    }
}
