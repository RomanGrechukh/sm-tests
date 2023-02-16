package com.savvymoney.smtests.cucumber.pages.savvymoney.admin;

import com.savvymoney.smtests.cucumber.restClient.*;

import java.util.Map;

public class UnblockSSNPage{

    private static MembershipAdminRestClientTest client = new MembershipAdminRestClientTest("http://internal-sandbox-alb-internal-v2-1230194207.us-east-1.elb.amazonaws.com/membership-admin/admin");

    public String unblockUser(String memberID)
    {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(Long.valueOf(memberID));
        return String.valueOf(client.unblockSSNCall(memberDTO));
    }

    public boolean isUserBlocked(String memberID)
    {
        MemberFilterDTO memberfilterDTO = new MemberFilterDTO();
        memberfilterDTO.setMemberId(Long.valueOf(memberID));
        Map<String, MemberSearchDTO> map =  client.memberSearchCall(memberfilterDTO);
        if(map.get(memberID).getStatus()==4)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
