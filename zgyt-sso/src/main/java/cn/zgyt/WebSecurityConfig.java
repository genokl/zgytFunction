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

import cn.zgyt.service.UserService;
import cn.zgyt.utils.SsoConfig;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private SsoConfig ssoConfig;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**", "/css/**", "/img/**","/lib/**","/js/**","/fonts/**","/zgytimg/**");
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
 
    /**
            * 用来配置拦截保护的请求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //不拦截 oauth 开放的资源
        http.csrf().disable();
        http.requestMatchers()//使HttpSecurity接收以"/login/","/oauth/"开头请求。
                .antMatchers("/oauth/**", "/login/**", "/logout/**","/authentication/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin()
                .loginPage(ssoConfig.getLoginPage()).loginProcessingUrl(ssoConfig.getLoginProcessUrl());
                
    }
    

	@Autowired
	private UserService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return this.userService;
	}

}
