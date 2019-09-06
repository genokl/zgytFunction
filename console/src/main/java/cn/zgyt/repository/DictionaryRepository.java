package cn.zgyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.user.Dictionary;

/**
 *
 */
@RepositoryRestResource(path="dictionary")
@Transactional(propagation=Propagation.REQUIRED)
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer>{

}
