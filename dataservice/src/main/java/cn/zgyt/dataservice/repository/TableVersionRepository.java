package cn.zgyt.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.dataservice.entity.TableVersion;

/**
 *
 */
@RepositoryRestResource(path="tableversion")
@Transactional(propagation=Propagation.REQUIRED)
public interface TableVersionRepository extends JpaRepository<TableVersion, Integer>{

	/**
	 * 检查是否重复创建表
	 * tableName+version
	 * 匹配
	 */
	@RestResource(path="findByTableName",rel="findByTableName")
	public List<TableVersion> findByTableName(String tableName);
	
	
	public Integer deleteByTableName(String tableName);

	
}
