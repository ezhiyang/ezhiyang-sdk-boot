package com.ezhiyang.sdk.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ezhiyang")
public class ZyClientProperties {

  private String url;
  
  private String clientId;
  
  private String secret;
  
  private String privatekey;
  
  private Long expiredTime;
  
  private Integer connectTimeout;
  
  private Integer socketTimeout;
  
  private String zyPublicKey;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getPrivatekey() {
    return privatekey;
  }

  public void setPrivatekey(String privatekey) {
    this.privatekey = privatekey;
  }

  public Long getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(Long expiredTime) {
    this.expiredTime = expiredTime;
  }

  public Integer getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Integer connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Integer getSocketTimeout() {
    return socketTimeout;
  }

  public void setSocketTimeout(Integer socketTimeout) {
    this.socketTimeout = socketTimeout;
  }

  public String getZyPublicKey() {
    return zyPublicKey;
  }

  public void setZyPublicKey(String zyPublicKey) {
    this.zyPublicKey = zyPublicKey;
  }

}
