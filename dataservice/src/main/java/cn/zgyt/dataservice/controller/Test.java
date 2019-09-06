package cn.zgyt.dataservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

	@RequestMapping("/test")
	@ResponseBody
	public String  test() {
		return "test";
	}
	
}
