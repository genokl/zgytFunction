package cn.zgyt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * 首页重定向配置
 * @author wxy
 */
@Controller
public class IndexController {
 
    @RequestMapping("/")
    public String index1() {
        return "redirect:index";
    }
    @RequestMapping("/index")
    public String index2() {
    	return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
    	return "login";
    }
    
    @RequestMapping("/logout")
    public String logout() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	return "logout";
    }
}