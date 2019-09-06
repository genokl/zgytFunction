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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zgyt.assembler.ProductResourceAssembler;
import cn.zgyt.entiry.Product;
import cn.zgyt.repository.ProductRepository;
import cn.zgyt.resource.ProductResource;
@Controller
@RequestMapping(value="product")
public class ProductController {

	@Autowired
	private ProductResourceAssembler assembler;
	
	@Autowired
	private ProductRepository rep;
	
	@Autowired
	private PagedResourcesAssembler<Product> pagedAssembler;
	

	@RequestMapping(value="/self/{id}",produces="application/json")
	public ResponseEntity<?> self(@PathVariable Integer id) {
		Product p = rep.findProductById(id);
		return ResponseEntity.ok(assembler.toInfoResource(p));
	}

	public ResponseEntity<?> nextOne(Integer id) {
		Product p = rep.findOne(id);
		return ResponseEntity.ok(assembler.toResource(p));
	}

	public ResponseEntity<?> prefOne(Integer id) {
		Product p = rep.findOne(id);
		return ResponseEntity.ok(assembler.toResource(p));
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
            pagedResources = new PagedResources(embedded, pagedResources.getMetadata(), pagedResources.getLinks());
        }
        res = new ResponseEntity<Object>(pagedResources, HttpStatus.OK);
		return res;
	}
	
}
