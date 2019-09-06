package cn.zgyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.ProductType;

/**
 *
 */
@RepositoryRestResource(path="productType")
@Transactional(propagation=Propagation.REQUIRED)
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>, JpaSpecificationExecutor<ProductType> {
	

}
