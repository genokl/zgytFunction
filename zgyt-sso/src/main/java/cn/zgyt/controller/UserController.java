package cn.zgyt.controller;

import java.security.Principal;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
    private ConsumerTokenServices tokenServices;

    @GetMapping("/user")
    public Authentication principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.debug("user-me:{}", authentication.getName());
        System.out.println();
        return authentication;
    }
    

}