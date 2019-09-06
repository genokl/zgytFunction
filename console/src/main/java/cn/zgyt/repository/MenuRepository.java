package cn.zgyt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.user.Menu;

/**
 *
 */
@RepositoryRestResource(path="menu")
@Transactional(propagation=Propagation.REQUIRED)
public interface MenuRepository extends JpaRepository<Menu, Integer>,JpaSpecificationExecutor<Menu>{

	Menu findByid(Integer Id);
	
}
