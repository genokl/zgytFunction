package cn.zgyt.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.zgyt.assembler.ProductResourceAssembler;
import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.ProductType;
import cn.zgyt.repository.ProductRepository;
import cn.zgyt.repository.ProductTypeRepository;
import cn.zgyt.resource.ProductResource;
import cn.zgyt.utils.ResponseUtils;
import cn.zgyt.utils.StringUtil;
@Controller
@RequestMapping(value="product")
public class ProductController {

	@Autowired
	private ProductResourceAssembler assembler;
	
	@Autowired
	private ProductRepository rep;
	
	@Autowired
	private ProductTypeRepository typeRep;
	
	@Autowired
	private PagedResourcesAssembler<Product> pagedAssembler;
	

	@GetMapping(value="/self/{id}",produces="application/json")
	public ResponseEntity<?> self(@PathVariable Integer id) {
		List<ProductType> list = typeRep.findByuseType("1");
		Product p = rep.findProductById(id);
		p.setProductTypeS(list);
		return ResponseEntity.ok(assembler.toInfoResource(p));
	}
	
	@DeleteMapping(value="/delete/{id}",produces="application/json")
	public ResponseEntity<?> delete(@PathVariable  Integer id) {
		rep.delete(id);
		return null;
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@RequestBody Product p,HttpServletResponse req) {
		if(p!=null) {
			p.setCreateDate(new Date());
			if(p.getShowDate()==null) {
				p.setShowDate(new Date());
			}
			ProductType pt = new ProductType();
			pt.setId(p.getProductTypeId());
			p.setProductType(pt);
			p.setIsDel(0);
			p.setIsSale(1);
			p.setProductDetail(StringUtil.dealProductDetail(p.getProductDetail()));
			p.setOrderCode(System.currentTimeMillis());
			Product ps = rep.save(p);
			List<ProductType> list = typeRep.findByuseType("1");
			p.setProductTypeS(list);
//			JSONObject jo=new JSONObject();
//			jo.put("info", p);
//			ResponseUtils.renderJson(req,jo.toJSONString());
		}
		return ResponseEntity.ok(assembler.toInfoResource(p));
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<?> save(@RequestBody Product p,HttpServletResponse req) {
			ProductType pt = new ProductType();
			pt.setId(p.getProductTypeId());
			p.setProductDetail(StringUtil.dealProductDetail(p.getProductDetail()));
			p.setProductType(pt);
			Product one = rep.getOne(p.getId());
			p.setCreateDate(one.getCreateDate());
			Product save = rep.save(p);
			JSONObject jo=new JSONObject();
			jo.put("info", save);
			ResponseUtils.renderJson(req,jo.toJSONString());
			return null;
	}
	
	@PutMapping(value="/top")
	public ResponseEntity<?> top(@RequestBody Product p) {
		ProductType pt = new ProductType(); 
		pt.setId(p.getProductTypeId());
		p.setProductType(pt);
		Product one = rep.getOne(p.getId());
		p.setCreateDate(one.getCreateDate());
		rep.save(p);
		return new ResponseEntity<Object>("", HttpStatus.OK);
	}
	
	@PutMapping(value="/sale")
	public ResponseEntity<?> sale(@RequestBody Product p) {
		ProductType pt = new ProductType();
		pt.setId(p.getProductTypeId());
		p.setProductType(pt);
		Product one = rep.getOne(p.getId());
		p.setCreateDate(one.getCreateDate());
		rep.save(p);
		return new ResponseEntity<Object>("", HttpStatus.OK);
	}

	
	@RequestMapping("/datalist")
	public ResponseEntity<?> datalist(
			Integer productType,
			Pageable pageable,
			HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> res=null;
		Specification<Product> spec = new Specification<Product>() {
			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(cb.equal(root.get("productType"), productType));
				Predicate[] p = new Predicate[list.size()];
				query.orderBy(cb.desc(root.get("showDate").as(Date.class)));
				return cb.and(list.toArray(p));
			}
		};
		Page<Product> page = rep.findAll(spec, pageable);
        PagedResources<ProductResource> pagedResources = pagedAssembler.toResource(page, assembler);
        if (page.getContent()==null || page.getContent().isEmpty()){
            EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
            EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(Product.class);
            List<EmbeddedWrapper> embedded = Collections.singletonList(wrapper);
            pagedResources = new PagedResources(embedded, pagedResources.getMetadata(),pagedResources.getLinks());
        }
        res = new ResponseEntity<Object>(pagedResources, HttpStatus.OK);
		return res;
	}
	
}
