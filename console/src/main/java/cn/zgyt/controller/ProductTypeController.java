package cn.zgyt.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zgyt.assembler.ProductTypeResourceAssembler;
import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.ProductType;
import cn.zgyt.repository.ProductTypeRepository;
import cn.zgyt.resource.ProductTypeResource;
@Controller
@RequestMapping(value="productType")
public class ProductTypeController {

	@Autowired
	private ProductTypeResourceAssembler assembler;
	
	@Autowired
	private ProductTypeRepository rep;
	
	@Autowired
	private PagedResourcesAssembler<ProductType> pagedAssembler;
	
	@RequestMapping("/datalist")
	public ResponseEntity<?> loadArticleDisplayListByPage(
			@PathVariable String defineid, 
			Pageable pageable,
			HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> res=null;
		Specification<ProductType> spec = new Specification<ProductType>() {
			@Override
			public Predicate toPredicate(Root<ProductType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(cb.equal(root.get("isDel"), 0));//查询未删除的产品类型
				Predicate[] p = new Predicate[list.size()];
				query.orderBy(cb.asc(root.get("ordercode").as(Long.class)));
				return cb.and(list.toArray(p));
			}
		};
		Page<ProductType> page = rep.findAll(spec, pageable);
        PagedResources<ProductTypeResource> pagedResources = pagedAssembler.toResource(page, assembler);
        if (page.getContent()==null || page.getContent().isEmpty()){
            EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
            EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(Product.class);
            List<EmbeddedWrapper> embedded = Collections.singletonList(wrapper);
            pagedResources = new PagedResources(embedded, pagedResources.getMetadata(), pagedResources.getLinks());
        }
		return res;
	}

	@RequestMapping("/self/{id}")
	public ResponseEntity<?> self(@PathVariable Integer id) {
		ProductType p = rep.findOne(id);
		return ResponseEntity.ok(assembler.toSelfResource(p));
	}

}
