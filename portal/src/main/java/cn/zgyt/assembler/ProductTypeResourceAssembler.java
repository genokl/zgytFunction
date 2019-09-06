package cn.zgyt.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Arrays;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import cn.zgyt.controller.ProductController;
import cn.zgyt.controller.ProductTypeController;
import cn.zgyt.entiry.ProductType;
import cn.zgyt.resource.ProductTypeResource;
@Component
public class ProductTypeResourceAssembler extends ResourceAssemblerSupport<ProductType, ProductTypeResource> {


	
	public ProductTypeResourceAssembler() {
       super(ProductTypeController.class, ProductTypeResource.class);
    }
	
	@Override
    public ProductTypeResource toResource(ProductType entity) {
		Link self = linkTo(methodOn(ProductTypeController.class).self(entity.getId())).withRel("_self");
		Link next = linkTo(methodOn(ProductTypeController.class).self(entity.getId())).withRel("_self");
		Link prev = linkTo(methodOn(ProductTypeController.class).self(entity.getId())).withRel("_self");
        return new ProductTypeResource(entity, Arrays.asList(self,next,prev));
    }
	
	public ProductTypeResource toSelfResource(ProductType entity) {
		Link self = linkTo(methodOn(ProductController.class).datalist(entity.getId(),null,null,null)).withRel("_self");
		return new ProductTypeResource(entity, Arrays.asList(self));
	}

}
