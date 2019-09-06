//package com.epc.pm.services.supplier.assembler;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//import java.util.Arrays;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.projection.ProjectionFactory;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
//import org.springframework.stereotype.Component;
//
//import com.epc.pm.entity.supplier.SupplierAppr;
//import com.epc.pm.services.supplier.Projection.SupplierApprProjection;
//import com.epc.pm.services.supplier.controller.SupplierApprController;
//import com.epc.pm.services.supplier.resource.SupplierApprResource;
//
///**
// * 
// * @author 王延伟
// * @date 2019年6月14日
// * 
// */
//@Component	
//public class SupplierApprAssembler extends ResourceAssemblerSupport<SupplierAppr, SupplierApprResource> {
//
//	@Autowired
//	private ProjectionFactory factory;
//	
//	public SupplierApprAssembler() {
//		super(SupplierApprController.class, SupplierApprResource.class);
//	}
//
//	@Override
//	public SupplierApprResource toResource(SupplierAppr entity) {
//		Link self = linkTo(methodOn(SupplierApprController.class).self(entity.getId())).withRel("_self");
////		Link selfProduct = linkTo(methodOn(ProductController.class).datalist(entity.getId(),null,null)).withRel("_product_subgrid");
////		Link selfContact = linkTo(methodOn(ContactController.class).datalist(entity.getId(),null,null)).withRel("_contact_subgrid");
////		Link selfPayment = linkTo(methodOn(SupplierPaymentController.class).datalist(null,null)).withRel("_payment_subgrid");
////		Link update = linkTo(methodOn(SupplierController.class).update(null,null)).withRel("_modify");
////		Link delete = linkTo(methodOn(SupplierController.class).delete(entity.getId())).withRel("_delete");
////		Link filelist = linkTo(methodOn(BaseAttachmentController.class).files(entity.getClass().getName(), entity.getId())).withRel("_filelist");
////		Link fileupload = linkTo(BaseAttachmentController.class).slash("upload").slash(entity.getClass().getName()).slash(entity.getId()).withRel("_fileupload");
////		return new SupplierResource(entity, Arrays.asList(self, update, delete,selfProduct,selfContact,selfPayment, filelist, fileupload));
//		return new SupplierApprResource(factory.createProjection(SupplierApprProjection.class, entity), Arrays.asList(self));
//	}
//	
//}
