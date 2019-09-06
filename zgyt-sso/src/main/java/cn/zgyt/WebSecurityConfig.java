package cn.zgyt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import cn.zgyt.service.UserService;
import cn.zgyt.utils.SsoConfig;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SsoConfig ssoConfig;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**", "/css/**", "/img/**","/lib/**","/js/**","/fonts/**","/zgytimg/**");
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder be = new BCryptPasswordEncoder();
		String encode = be.encode("123abc");
		System.out.println(be.matches("123abc", encode));
		System.out.println(":"+encode);
	}

	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/login").permitAll()
		.and()
			.formLogin().loginPage(ssoConfig.getLoginPage()).loginProcessingUrl(ssoConfig.getLoginProcessUrl())
		.and()
			.requestMatchers().antMatchers("/login","/", "/oauth/authorize", "/oauth/confirm_access","/oauth/token",ssoConfig.getLoginProcessUrl())
		.and()
			.authorizeRequests().anyRequest().authenticated()
//		.and()
//			.headers().frameOptions().disable()
		.and().headers().frameOptions().sameOrigin()
		.and()
			.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize")).disable();
	}


	@Override
	protected UserDetailsService userDetailsService() {
		// 自定义用户信息类
		return this.userService;
	}

}
