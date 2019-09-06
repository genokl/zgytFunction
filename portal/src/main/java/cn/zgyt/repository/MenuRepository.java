package cn.zgyt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.user.Menu;

/**
 *
 */
@RepositoryRestResource(path="menu")
@Transactional(propagation=Propagation.REQUIRED)
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	
//	@Query(value="SELECT count FROM am_article WHERE article_type=?1",nativeQuery=true)
//	Integer loadArticleCountByArticleTypeAndPage(String articleType);
	/**
	 * 查询父级菜单列表
	 * @param parentId
	 * @return
	 */
	List<Menu> findMenuByLevel(Integer level);
	
	/**
	 * 根据父级id查询子集菜单列表
	 * @param parentId
	 * @return
	 */
	List<Menu> findMenuByParentIdOrderByOrdersAsc(Integer parentId);
	
}
