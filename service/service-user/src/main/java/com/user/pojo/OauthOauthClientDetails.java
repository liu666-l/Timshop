package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="oauth_client_details")
public class OauthOauthClientDetails implements Serializable{

	@Id
    @Column(name = "client_id")
	private String clientClientId;//客户端ID，主要用于标识对应的应用

    @Column(name = "resource_ids")
	private String resourceResourceIds;//

    @Column(name = "client_secret")
	private String clientClientSecret;//客户端秘钥，BCryptPasswordEncoder加密

    @Column(name = "scope")
	private String scope;//对应的范围

    @Column(name = "authorized_grant_types")
	private String authorizedAuthorizedGrantTypes;//认证模式

    @Column(name = "web_server_redirect_uri")
	private String webWebServerRedirectUri;//认证后重定向地址

    @Column(name = "authorities")
	private String authorities;//

    @Column(name = "access_token_validity")
	private Integer accessAccessTokenValidity;//令牌有效期

    @Column(name = "refresh_token_validity")
	private Integer refreshRefreshTokenValidity;//令牌刷新周期

    @Column(name = "additional_information")
	private String additionalAdditionalInformation;//

    @Column(name = "autoapprove")
	private String autoapprove;//



	//get方法
	public String getClientClientId() {
		return clientClientId;
	}

	//set方法
	public void setClientClientId(String clientClientId) {
		this.clientClientId = clientClientId;
	}
	//get方法
	public String getResourceResourceIds() {
		return resourceResourceIds;
	}

	//set方法
	public void setResourceResourceIds(String resourceResourceIds) {
		this.resourceResourceIds = resourceResourceIds;
	}
	//get方法
	public String getClientClientSecret() {
		return clientClientSecret;
	}

	//set方法
	public void setClientClientSecret(String clientClientSecret) {
		this.clientClientSecret = clientClientSecret;
	}
	//get方法
	public String getScope() {
		return scope;
	}

	//set方法
	public void setScope(String scope) {
		this.scope = scope;
	}
	//get方法
	public String getAuthorizedAuthorizedGrantTypes() {
		return authorizedAuthorizedGrantTypes;
	}

	//set方法
	public void setAuthorizedAuthorizedGrantTypes(String authorizedAuthorizedGrantTypes) {
		this.authorizedAuthorizedGrantTypes = authorizedAuthorizedGrantTypes;
	}
	//get方法
	public String getWebWebServerRedirectUri() {
		return webWebServerRedirectUri;
	}

	//set方法
	public void setWebWebServerRedirectUri(String webWebServerRedirectUri) {
		this.webWebServerRedirectUri = webWebServerRedirectUri;
	}
	//get方法
	public String getAuthorities() {
		return authorities;
	}

	//set方法
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	//get方法
	public Integer getAccessAccessTokenValidity() {
		return accessAccessTokenValidity;
	}

	//set方法
	public void setAccessAccessTokenValidity(Integer accessAccessTokenValidity) {
		this.accessAccessTokenValidity = accessAccessTokenValidity;
	}
	//get方法
	public Integer getRefreshRefreshTokenValidity() {
		return refreshRefreshTokenValidity;
	}

	//set方法
	public void setRefreshRefreshTokenValidity(Integer refreshRefreshTokenValidity) {
		this.refreshRefreshTokenValidity = refreshRefreshTokenValidity;
	}
	//get方法
	public String getAdditionalAdditionalInformation() {
		return additionalAdditionalInformation;
	}

	//set方法
	public void setAdditionalAdditionalInformation(String additionalAdditionalInformation) {
		this.additionalAdditionalInformation = additionalAdditionalInformation;
	}
	//get方法
	public String getAutoapprove() {
		return autoapprove;
	}

	//set方法
	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}


}
