package com.savvymoney.smtests.cucumber.restClient;

import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class MembershipAdminRestClientTest {

	private RestTemplate restTemplate;
	private String membershipAdminRestApiUrl;

	public MembershipAdminRestClientTest(String membershipAdminRestApiUrl) {
		this.membershipAdminRestApiUrl = membershipAdminRestApiUrl;
		this.restTemplate = new RestTemplate(httpRequestFactory());
	}

	public Response unblockSSNCall(MemberDTO memberDTO) {
		HttpEntity<MemberDTO> entity = new HttpEntity<>(memberDTO, createHeader());
		String exchangeURL = membershipAdminRestApiUrl + "/member/unblock";
		try {
			ResponseEntity<Response> responseEntity = restTemplate.exchange(exchangeURL, HttpMethod.POST, entity,
					Response.class);
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			throw new RestClientException(createExceptionMessage(exchangeURL, e));
		}
	}

	public Response cancelAccountCall(MemberDTO memberDTO) {
		HttpEntity<MemberDTO> entity = new HttpEntity<>(memberDTO, createHeader());
		String exchangeURL = membershipAdminRestApiUrl + "/member/cancel";
		try {
			ResponseEntity<Response> responseEntity = restTemplate.exchange(exchangeURL, HttpMethod.POST, entity,
					Response.class);
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			throw new RestClientException(createExceptionMessage(exchangeURL, e));
		}
	}

	public Map<String, MemberSearchDTO> memberSearchCall(MemberFilterDTO memberFilterDTO) {
		HttpEntity<MemberFilterDTO> entity = new HttpEntity<>(memberFilterDTO, createHeader());
		String exchangeURL = membershipAdminRestApiUrl + "/member/search";
		try {
			ResponseEntity<Map<String, MemberSearchDTO>> responseEntity = restTemplate.exchange(exchangeURL,
					HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, MemberSearchDTO>>() {
					});
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			throw new RestClientException(createExceptionMessage(exchangeURL, e));
		}
	}

	private ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}

	private HttpClient httpClient() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(200);
		connectionManager.setDefaultMaxPerRoute(100);
		return HttpClientBuilder.create().setConnectionManager(connectionManager).build();
	}

	protected HttpHeaders createHeader() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		return header;
	}

	protected String createExceptionMessage(String exchangeURL, HttpStatusCodeException e) {
		return String.format("Invalid  response from %s. Response status code: %s - %s. Message: %s.", exchangeURL,
				e.getStatusCode().value(), e.getStatusCode().getReasonPhrase(), e.getResponseBodyAsString());
	}

}
