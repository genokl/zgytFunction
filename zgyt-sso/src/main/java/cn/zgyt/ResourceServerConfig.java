package cn.zgyt;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
@Order(6)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
		// 表单登录 方式
		http.httpBasic().disable()
		.formLogin()
		.and()
		.authorizeRequests().antMatchers("/api/**").authenticated().antMatchers("/oauth/token").permitAll()
		.and()
		.csrf().disable();
	}

//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()// 禁用了 csrf 功能
//				.authorizeRequests()// 限定签名成功的请求
//				.antMatchers("/decision/**", "/govern/**").hasAnyRole("USER", "ADMIN")
////                .antMatchers("/admin/**").hasRole("ADMIN")
//				.antMatchers("/test/**", "/admin/**").authenticated()// 签名成功后可访问，不受role限制
////            .antMatchers("/admin/login","/oauth/**").permitAll()
//				.anyRequest().permitAll()// 其他没有限定的请求，允许访问
//				.and().anonymous()// 对于没有配置权限的其他请求允许匿名访问
//				.and().formLogin()// 使用 spring security 默认登录页面
//				;// 启用http 基础验证
//	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
	}

}
