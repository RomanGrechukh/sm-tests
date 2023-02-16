package com.savvymoney.smtests.cucumber.restClient;

public class MemberDTO {
    private Long memberId;
    private String email;
    private String dataProvider;
    private MemberInfoDTO memberInfo;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberInfoDTO getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfoDTO memberInfo) {
        this.memberInfo = memberInfo;
    }

    public String getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

}
