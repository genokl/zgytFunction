package cn.zgyt.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import cn.zgyt.entiry.Product;

/**
 * 
 * @author wxy
 * @date 2019年1月21日
 * 
 */
public class ProductResource extends Resource<Product> {

	public ProductResource(Product content, Iterable<Link> links) {
		super(content, links);
	}

}
