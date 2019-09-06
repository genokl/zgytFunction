package cn.zgyt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping(value="/jump")
public class JumpController {

    @RequestMapping("/p") 
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "index") String pageName) {
//    	if(pageName.contains(".html")) {
//    		return pageName.replace(".html", "");
//    	}
        return pageName; 
    } 
    
}
