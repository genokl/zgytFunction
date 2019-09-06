package cn.zgyt.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import cn.zgyt.entiry.ProductType;

/**
 * 
 * @author wxy
 * @date 2019年1月21日
 * 
 */
public class ProductTypeResource extends Resource<ProductType> {

	public ProductTypeResource(ProductType content, Iterable<Link> links) {
		super(content, links);
	}

}
