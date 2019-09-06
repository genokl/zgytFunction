package cn.zgyt.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Arrays;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import cn.zgyt.controller.MenuController;
import cn.zgyt.entiry.user.Menu;
import cn.zgyt.resource.MenuResource;
@Component
public class MenuResourceAssembler extends ResourceAssemblerSupport<Menu, MenuResource> {


	
	public MenuResourceAssembler() {
       super(MenuController.class, MenuResource.class);
    }
	
	@Override
    public MenuResource toResource(Menu entity) {
		Link self = linkTo(methodOn(MenuController.class).self(entity.getId())).withRel("_self");
        return new MenuResource(entity, Arrays.asList(self));
    }
	
	public MenuResource toSelfResource(Menu entity) {
		Link self = linkTo(methodOn(MenuController.class).self(entity.getId())).withRel("_self");
		return new MenuResource(entity, Arrays.asList(self));
	}

}
