package cn.zgyt.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.Product;
import cn.zgyt.repository.ProductRepository;
/**
 * 文章管理类Service
 * @author wxy
 *
 */
@Service("productDisplayService")
@Transactional
public class ProductDisplayService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	/**
	 * 请求文章列表 (带分页)不查文章详情
	 */
//	public Map<String, Object> loadAllArticleDisplayListByPage(SearchVo vo) {
//		Integer pageIndex = vo.getPageIndex();
//		Integer currentCount = vo.getCurrentCount();
//		String productType = vo.getArticleType();
//		Map<String, Object> m=new HashMap<>();
//		if (pageIndex==null) {//若是当前页为空，则查询第一页
//			pageIndex=1;
//		}
//		if (currentCount==null) {//本页条数默认 为 4条
//			currentCount=6;
//		}
//		List<Product> al=new ArrayList<Product>();
//		al= productRepository.loadArticleListByArticleTypeAndPage(productType,pageIndex, currentCount);
//		m.put("info", al);
//	    Integer count = productRepository.loadArticleCountByArticleTypeAndPage(productType);
//	    m.put("count", count);
//		return m;
//	}

	/**
	 * 加载文章详情数据
	 */
	public Map<String, Object> loadArticleDisplayInfoData(Integer articleId) {
		Map<String, Object> m=new HashMap<>();
		String sql="select * from zgyt_article where id = "+articleId;
		Product a = productRepository.findProductById(articleId);
		m.put("info", a);
		if(a!=null) {
//			List<Product> ll= productRepository.findArticlePrevAndNextId(a.getCreateDate().toString(), a.getArticleType());
//			Map<String, List<Product>> mm = ll.stream().collect(Collectors.groupingBy(Product::getOrderName));
//			m.put("other", mm);
		}
		return m;
	}



//	/**
//	 * 查询分业总条数
//	 */
//	public Integer loadArticleDisplayCount(String articleType) {
//		String sql="select count(id) from zgyt_article where is_del = 0 ";
//		if (!CommonUtils.checkFull(articleType)) {
//			sql+=" and article_type in ( "+articleType+" )";
//		}
//		return articleRepository.excuteBySQL(sql);
//	}
//
//	/**
//	 * 根据关键词搜索文章内容
//	 */
//	public String searchArticleByKeyWord(Integer pageIndex, Integer currentCount,String searchInput) {
//		JSONObject jo = new JSONObject();
//		JsonConfig jsonConfig = new JsonConfig();
//		//id,articleTitle,articleType,createDate,articleSynopsis,articleSynopsisImg,isDel,isShow,articleHtmlAddress
//		String sql="select id,article_title,article_type,create_date," +
//				"article_synopsis,article_synopsis_img,is_del,is_show,article_Html_address" +
//				" from zgyt_article where is_del=0 and is_show=1 and key_words like %"+searchInput+"%";
//		if (pageIndex==null) {//若是当前页为空，则查询第一页
//			pageIndex=1;
//		}
//		if (currentCount==null) {//本页条数默认 为 20条
//			currentCount=4;
//		}
//		List list = articleDaoImpl.excuteBySqlListByPageNum(sql, pageIndex, currentCount, Article.class);
//		jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
//		JSONArray ja = JSONArray.fromObject(list, jsonConfig);
//		jo.put("info", list);
//		return null;
//	}
//
//	/**
//	 *查询所有文章关键词
//	 */
//	public List<Article> loadAllArticleIdByKeyWord() {
//		ArrayList<Article> keyWords=new ArrayList<Article>();
//		String hql="select new Article(id,articleTitle,keyWords,isDel,isShow) from Article where isShow =1 and isDel = 0 ";
//		hql+="and articleType in (3,4,5) ";
//		keyWords=(ArrayList<Article>) articleDaoImpl.getListByHQL(hql);
//		return keyWords;
//	}

}
