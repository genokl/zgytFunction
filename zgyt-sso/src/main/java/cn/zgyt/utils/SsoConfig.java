package cn.zgyt.utils;

import org.springframework.stereotype.Component;

@Component
public class SsoConfig {

	
	private String loginProcessUrl;
    private String loginPage;
    
    
    
	public String getLoginProcessUrl() {
		return loginProcessUrl;
	}
	public void setLoginProcessUrl(String loginProcessUrl) {
		this.loginProcessUrl = loginProcessUrl;
	}
	public String getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

    
}
