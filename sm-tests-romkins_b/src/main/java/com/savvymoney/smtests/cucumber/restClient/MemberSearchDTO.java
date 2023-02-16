package com.savvymoney.smtests.cucumber.restClient;

import java.util.Date;

public class MemberSearchDTO {

	private Long memberId;
	private Long partnerId;
	private String email;
	private String contactEmail;
	private String partnerMemberId;
	private Boolean isSSO;
	private Date expirationDate;
	private Date lastLoginDate;
	private Date createdAt;
	private String memberType;
	private Boolean dormant;

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private Byte status;
	private String ssn;
	private String password;
	private boolean shouldBeCancelled;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPartnerMemberId() {
		return partnerMemberId;
	}

	public void setPartnerMemberId(String partnerMemberId) {
		this.partnerMemberId = partnerMemberId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

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

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Boolean getIsSSO() {
		return isSSO;
	}

	public void setIsSSO(Boolean isSSO) {
		this.isSSO = isSSO;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Boolean getDormant() {
		return dormant;
	}

	public void setDormant(Boolean dormant) {
		this.dormant = dormant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isShouldBeCancelled() {
		return shouldBeCancelled;
	}

	public void setShouldBeCancelled(boolean shouldBeCancelled) {
		this.shouldBeCancelled = shouldBeCancelled;
	}

}
