package com.ezhiyang.sdk.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ezhiyang.sdk.core.cache.AbstractAuthCache;
import com.ezhiyang.sdk.core.cache.MemoryAuthCache;
import com.ezhiyang.sdk.core.context.SdkContext;
import com.ezhiyang.sdk.core.model.ClientConfig;

@Configuration
@ConditionalOnClass({ClientConfig.class,SdkContext.class})
@EnableConfigurationProperties(ZyClientProperties.class)
@ConditionalOnProperty(prefix = "ezhiyang",name = {"url","clientId","secret","privatekey"})
public class ZySdkAutoConfiguration {

  public ZyClientProperties properties;
  
  public ZySdkAutoConfiguration(ZyClientProperties properties) {
    this.properties = properties;
  }
  
  @Bean
  @ConditionalOnMissingBean
  public ClientConfig clientConfig() {
    ClientConfig config = new ClientConfig(properties.getUrl(),
        properties.getClientId(), properties.getSecret(), properties.getPrivatekey());
    if(properties.getExpiredTime() != null && properties.getExpiredTime() <= 7200) {
      config.setExpiredTime(properties.getExpiredTime());
    }
    if(properties.getConnectTimeout() != null) {
      config.setConnectTimeout(properties.getConnectTimeout());
    }
    if(properties.getSocketTimeout() != null) {
      config.setSocketTimeout(properties.getSocketTimeout());
    }
    return config;
  }
  
  
  @Bean
  @ConditionalOnMissingBean(AbstractAuthCache.class)
  public AbstractAuthCache abstractAuthCache() {
    AbstractAuthCache cache = new MemoryAuthCache();
    return cache;
  }
  
  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnBean({ClientConfig.class,AbstractAuthCache.class})
  public SdkContext sdkContext(ClientConfig clientConfig,AbstractAuthCache cache) {
    SdkContext context = new SdkContext(clientConfig,cache);
    return context;
  }
  
  
  
}
