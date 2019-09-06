package cn.zgyt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.Product;

/**
 *
 */
@RepositoryRestResource(path="product")
@Transactional(propagation=Propagation.REQUIRED)
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	@Query(value="SELECT id,article_title,create_date,article_synopsis,article_synopsis_img,is_del,is_show,article_Html_address "
			+ "FROM am_article WHERE article_type=?1 limit (?2-1)*?3,?3 order by createDate desc",nativeQuery=true)
	List<Product> loadArticleListByArticleTypeAndPage(String articleType, Integer pageIndex, Integer currentCount);
	
	@Query(value="SELECT count FROM am_article WHERE article_type=?1",nativeQuery=true)
	Integer loadArticleCountByArticleTypeAndPage(String articleType);

	Product findProductById(Integer productId);
	
	@Query(value="(SELECT article_title,id,'prev' orderName FROM am_article "
			+ "WHERE UNIX_TIMESTAMP(create_date) > UNIX_TIMESTAMP('?1') "
			+ "AND article_type=?2 ORDER BY create_date asc  limit 1)"
			+ "UNION" + 
			"(SELECT article_title,id,'next' orderName FROM am_article "
			+ "WHERE UNIX_TIMESTAMP(create_date) < UNIX_TIMESTAMP('?1') "
			+ "AND article_type=?2 ORDER BY create_date desc  limit 1)",nativeQuery=true)
	List<Product> findProductPrevAndNextId(String createDate,Integer articleType);
}
