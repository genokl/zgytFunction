package cn.zgyt.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import cn.zgyt.entiry.user.Menu;

/**
 * 
 * @author wxy
 * @date 2019年1月21日
 * 
 */
public class MenuResource extends Resource<Menu> {

	public MenuResource(Menu content, Iterable<Link> links) {
		super(content, links);
	}

}
