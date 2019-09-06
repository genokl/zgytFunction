package cn.zgyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChengJianSheng
 * @date 2019-02-12
 */
@Controller
public class LoginController {

	
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @DeleteMapping(value = "/remove_token", params = "access_token")
//	public void removeToken(String access_token) {
//		boolean flag = tokenServices.revokeToken(access_token);
//		if (flag) {
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			// saveLogoutLog(authentication.getName());
//		}
//	}
}
