package cn.zgyt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zgyt.util.CommonUtils;
@Controller
@RequestMapping(value="/jump")
public class JumpController {

    @RequestMapping("/p") 
    public String hello(HttpServletRequest request,HttpServletResponse response, @RequestParam(value = "name", defaultValue = "index") String pageName,String param,Model model) {
    	if(!CommonUtils.checkFull(param)) {
    		model.addAttribute(param);
    	}
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return pageName; 
    } 
    
}
