package cn.zgyt.dataservice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zgyt.dataservice.entity.vo.SearchVo;
import cn.zgyt.dataservice.service.TableVersionServiceimpl;
import cn.zgyt.dataservice.util.CommonUtil;
import cn.zgyt.dataservice.util.ResUrlUtil;
import cn.zgyt.dataservice.util.UrlUtil;


@Controller
@RequestMapping("/search/**")
public class SearchController {
	
	private String prepath="search";
	
	
	@Autowired
	private TableVersionServiceimpl tableVersionServiceimpl;
	
	
	
	@ResponseBody
	@GetMapping
	public ResponseEntity<Object> searchData(
			HttpServletRequest request,
			HttpServletResponse response,
			SearchVo vo
			) throws Exception{
		ResponseEntity<Object> res=null;
		try {
			Map<String, Object> map = new HashMap<>();
			String requestURI = request.getRequestURI();
			String paramArrRest = UrlUtil.getParamArrRest(prepath, requestURI);
			vo = CommonUtil.parseSearchUrl(paramArrRest, vo, request);
			if (vo.getQueryType().equals("one")) {
				map = tableVersionServiceimpl.findObjWithMap(vo);
				if(map!=null) {
					map = ResUrlUtil.addCRUDUrlToObj(map, vo);
					res = new ResponseEntity<>(map, HttpStatus.OK);
				}else {
					res = new ResponseEntity<>(map, HttpStatus.OK);
				}
			}else if(vo.getQueryType().equals("list")){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
		return res; 
	}
}

