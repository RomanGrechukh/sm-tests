package com.savvymoney.smtests.cucumber.restClient;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MemberFilterDTO {

	private Long memberId;
	private String email;
	private String contactEmail;
	private String partnerMemberId;

	private Long partnerId;
	private String firstName;
	private String lastName;
	private String ssn;
	private Byte status;
	private String address;
	private String city;
	private String state;
	private List<Long> extraMemberIds;
	private Integer page;
	private Integer size;

	public boolean hasCreditParams() {
		return this.partnerId != null || this.status != null || !StringUtils.isAllEmpty(this.firstName, this.lastName,
				this.address, this.city, this.state, this.ssn);
	}

	public boolean hasMembershipParams() {
		return this.memberId != null || !StringUtils.isAllEmpty(this.email, this.contactEmail, this.partnerMemberId);
	}

	public List<Long> getExtraMemberIds() {
		return extraMemberIds;
	}

	public void setExtraMemberIds(List<Long> extraMemberIds) {
		this.extraMemberIds = extraMemberIds;
	}

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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
