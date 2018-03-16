package com.woocation.auth.dashboard.model;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("oauth_clients")
public class Client  implements Serializable {

	private String client_id ;
	private String client_secret;
	private Set<String> scope ;
	private Set<String> authorized_grant_types ;
	private Integer access_token_validity ;
	private Integer refresh_token_validity ;
	private String client_name ;
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
	public Set<String> getScope() {
		return scope;
	}
	public void setScope(Set<String> scope) {
		this.scope = scope;
	}
	public Set<String> getAuthorized_grant_types() {
		return authorized_grant_types;
	}
	public void setAuthorized_grant_types(Set<String> authorized_grant_types) {
		this.authorized_grant_types = authorized_grant_types;
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
