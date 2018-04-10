package com.woocation.auth.dashboard.model;

import java.io.Serializable;

//@RedisHash("oauth_clients")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Id
	private String client_id;
	private String client_secret;
	private String scope;
	private Integer access_token_validity;
	private Integer refresh_token_validity;
	private String client_name;
	private String grantTypes;
	private String redirectUri;
	private String userId;
	
	
	//private Set<String> test ;
//	private Date createdDate;

	/*public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}*/
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	/*	public Set<String> getTest() {
		return test;
	}

	public void setTest(Set<String> test) {
		this.test = test;
	}
*/
	public String getGrantTypes() {
		return grantTypes;
	}

	public void setGrantTypes(String grantTypes) {
		this.grantTypes = grantTypes;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	public Integer getAccess_token_validity() {
		return access_token_validity;
	}

	public void setAccess_token_validity(Integer access_token_validity) {
		this.access_token_validity = access_token_validity;
	}

	public Integer getRefresh_token_validity() {
		return refresh_token_validity;
	}

	public void setRefresh_token_validity(Integer refresh_token_validity) {
		this.refresh_token_validity = refresh_token_validity;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

}
