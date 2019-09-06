package cn.zgyt.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import cn.zgyt.controller.ProductController;
import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.ProductType;
import cn.zgyt.resource.ProductResource;
@Component
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, ProductResource> {


	
	public ProductResourceAssembler() {
       super(ProductController.class, ProductResource.class);
    }
	
	@Override
    public ProductResource toResource(Product entity) {
		Link self = linkTo(methodOn(ProductController.class).self(entity.getId())).withRel("_self");
        return new ProductResource(entity, Arrays.asList(self));
    }
	
	public ProductResource toInfoResource(Product entity) {
		Link self = linkTo(methodOn(ProductController.class).self(entity.getId())).withRel("_self");
		entity.setProductType_(entity.getProductType());
//		Link next = linkTo(methodOn(ProductController.class).nextOne(entity.getId())).withRel("_next");
//		Link pref = linkTo(methodOn(ProductController.class).prefOne(entity.getId())).withRel("_pref");
		return new ProductResource(entity, Arrays.asList(self));
	}
	public ProductResource toSelfResource(Product entity) {
		Link self = linkTo(methodOn(ProductController.class).self(entity.getId())).withRel("_self");
//		Link next = linkTo(methodOn(ProductController.class).nextOne(entity.getId())).withRel("_next");
//		Link pref = linkTo(methodOn(ProductController.class).prefOne(entity.getId())).withRel("_pref");
		return new ProductResource(entity, Arrays.asList(self));
	}
	public List<ProductResource> toListResource(List<Product> list) {
		List<ProductResource> ll=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);
			Link self = linkTo(methodOn(ProductController.class).self(product.getId())).withRel("_self");
			ll.add(new ProductResource(product, Arrays.asList(self)));
		}
		return ll;
	}

}
