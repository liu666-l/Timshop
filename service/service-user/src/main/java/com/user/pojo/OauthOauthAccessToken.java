package com.user.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="oauth_access_token")
public class OauthOauthAccessToken implements Serializable{

    @Column(name = "token_id")
	private String tokenTokenId;//

    @Column(name = "token")
	private String token;//

	@Id
    @Column(name = "authentication_id")
	private String authenticationAuthenticationId;//

    @Column(name = "user_name")
	private String userUserName;//

    @Column(name = "client_id")
	private String clientClientId;//

    @Column(name = "authentication")
	private String authentication;//

    @Column(name = "refresh_token")
	private String refreshRefreshToken;//



	//get方法
	public String getTokenTokenId() {
		return tokenTokenId;
	}

	//set方法
	public void setTokenTokenId(String tokenTokenId) {
		this.tokenTokenId = tokenTokenId;
	}
	//get方法
	public String getToken() {
		return token;
	}

	//set方法
	public void setToken(String token) {
		this.token = token;
	}
	//get方法
	public String getAuthenticationAuthenticationId() {
		return authenticationAuthenticationId;
	}

	//set方法
	public void setAuthenticationAuthenticationId(String authenticationAuthenticationId) {
		this.authenticationAuthenticationId = authenticationAuthenticationId;
	}
	//get方法
	public String getUserUserName() {
		return userUserName;
	}

	//set方法
	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}
	//get方法
	public String getClientClientId() {
		return clientClientId;
	}

	//set方法
	public void setClientClientId(String clientClientId) {
		this.clientClientId = clientClientId;
	}
	//get方法
	public String getAuthentication() {
		return authentication;
	}

	//set方法
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	//get方法
	public String getRefreshRefreshToken() {
		return refreshRefreshToken;
	}

	//set方法
	public void setRefreshRefreshToken(String refreshRefreshToken) {
		this.refreshRefreshToken = refreshRefreshToken;
	}


}
