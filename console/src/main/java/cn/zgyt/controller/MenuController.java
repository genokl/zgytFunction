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

import cn.zgyt.assembler.MenuResourceAssembler;
import cn.zgyt.entiry.user.Menu;
import cn.zgyt.repository.MenuRepository;
import cn.zgyt.resource.MenuResource;
import cn.zgyt.service.MenuService;
@Controller
@RequestMapping(value="/menu")
public class MenuController {

	@Autowired
	private MenuResourceAssembler assembler;
	
	@Autowired
	private MenuRepository rep;
	
	@Autowired
	private PagedResourcesAssembler<Menu> pagedAssembler;
	
	@Autowired
	private MenuService MenuService;
	
	@RequestMapping("/datalist")
	public ResponseEntity<?> loadArticleDisplayListByPage(
			@PathVariable String defineid, 
			Pageable pageable,
			HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<?> res=null;
		Specification<Menu> spec = new Specification<Menu>() {
			@Override
			public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(cb.equal(root.get("trackingdefine").get("id").as(String.class), defineid));
				Predicate[] p = new Predicate[list.size()];
				query.orderBy(cb.asc(root.get("ordercode").as(Long.class)));
				return cb.and(list.toArray(p));
			}
		};
		Page<Menu> page = rep.findAll(spec, pageable);
        PagedResources<MenuResource> pagedResources = pagedAssembler.toResource(page, assembler);
        if (page.getContent()==null || page.getContent().isEmpty()){
            EmbeddedWrappers wrappers = new EmbeddedWrappers(false);
            EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(Menu.class);
            List<EmbeddedWrapper> embedded = Collections.singletonList(wrapper);
            pagedResources = new PagedResources(embedded, pagedResources.getMetadata(), pagedResources.getLinks());
        }
		return res;
	}

	@RequestMapping("/self")
	public ResponseEntity<?> self(Integer id) {
		Menu p = rep.findByid(id);
		return ResponseEntity.ok(assembler.toSelfResource(p));
	}
}
