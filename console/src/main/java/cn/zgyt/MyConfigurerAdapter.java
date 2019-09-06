package cn.zgyt;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class MyConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/lib/**");
        web.ignoring().antMatchers("/fonts/**");
        web.ignoring().antMatchers("/favicon.ico");
    }
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//          .antMatcher("/**")
          .authorizeRequests()
//          .antMatchers("/", "/login/**")
//          .permitAll()
          .anyRequest()
          .authenticated()
          .and().headers().frameOptions().sameOrigin()
          .and().csrf().disable();
    }
}