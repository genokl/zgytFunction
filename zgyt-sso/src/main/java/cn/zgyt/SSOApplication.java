package cn.zgyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.zgyt.utils.SsoConfig;
@EnableTransactionManagement
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableAuthorizationServer
public class SSOApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SSOApplication.class, args);
	}
	
	@Bean(name = "ssoConfig")
	@ConfigurationProperties(prefix="server")
	public SsoConfig ssoConfig(){
		return new SsoConfig();
	}
	
}
