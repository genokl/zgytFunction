package cn.zgyt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zgyt.assembler.ProductResourceAssembler;
import cn.zgyt.entiry.Product;
import cn.zgyt.repository.ProductRepository;
import cn.zgyt.resource.ProductResource;
import cn.zgyt.service.ProductDisplayService;
@Controller
@RequestMapping(value="/index")
public class IndexController {  

	@Autowired
	private ProductDisplayService productDisplayService;
	@Autowired
	private ProductRepository productRep;
	@Autowired
	private ProductResourceAssembler assembler;
	
	@RequestMapping("/indexData")
	public ResponseEntity<?> loadArticleDisplayListByPage(
			HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> res=null;
		Map<String, Object> info=null;
		try {
//			info = productDisplayService.loadAllArticleDisplayListByPage(vo);
		    	List<Product> news = productRep.findProductByProductTypeIdId(3,4);
		    	List<Product> products = productRep.findProductByProductTypeIdId(4,4);
		    	List<Product> techs = productRep.findProductByProductTypeIdId(5,4);
		    	List<ProductResource> newss = assembler.toListResource(news);
		    	List<ProductResource> productss = assembler.toListResource(products);
		    	List<ProductResource> techss = assembler.toListResource(techs);
		    	Map m=new HashMap<>();
		    	m.put("news", newss);
		    	m.put("products", productss);
		    	m.put("techs", techss);
			res=new ResponseEntity<>(m,HttpStatus.OK);
		} catch (Exception e) {
			res=new ResponseEntity<>(info,HttpStatus.EXPECTATION_FAILED);
			e.printStackTrace();
		}
		return res;
	}
	
}
