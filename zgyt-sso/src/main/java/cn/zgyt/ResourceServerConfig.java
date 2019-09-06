package cn.zgyt;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 认证中心
 * 
 * @author wxy
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
		//表单登录 方式
        http.formLogin().and()
                .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
                .antMatchers("/oauth/token").permitAll()
                .and()
                .csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
	}

}
