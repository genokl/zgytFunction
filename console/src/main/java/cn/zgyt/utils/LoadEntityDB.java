//package com.framework.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.hibernate.Query;
//import org.springframework.orm.hibernate3.HibernateTemplate;
//
//import com.zgyt.basic.entity.Article;
//import com.zgyt.basic.entity.Dictionary;
//import com.zgyt.basic.entity.Resource;
//import com.zgyt.basic.entity.Role;
//import com.zgyt.basic.entity.User;
//import com.zgyt.portal.service.ArticleDisplayService;
//
///**
// * 加载数据库数据
// * @author wxy
// */
//public class LoadEntityDB {
//
//	/***
//	 * 查询用户数据
//	 * 
//	 * @return
//	 */
//	public List<User> getUserDataFromDB() {
//		List<User> list = null;
//		HibernateTemplate ht = (HibernateTemplate) SpringUtil
//				.getBean("hibernateTemplate");
//		list = ht.find("from User");
//		return list;
//	}
//
//	/**
//	 * 查询角色信息
//	 * 
//	 * @return
//	 */
//	public List<Role> getRoleDataFromDB() {
//		List<Role> list = null;
//		HibernateTemplate ht = (HibernateTemplate) SpringUtil
//				.getBean("hibernateTemplate");
//		list = ht.find("from Role");
//		return list;
//	}
//
//	/**
//	 * 查询资源信息
//	 * 
//	 * @return
//	 */
//	public List<Resource> getResourceDataFromDB() {
//		List<Resource> list = null;
//		HibernateTemplate ht = (HibernateTemplate) SpringUtil
//				.getBean("hibernateTemplate");
//		list = ht.find("from Resource");
//		return list;
//	}
//
//	/**
//	 * 加载数据字典到缓存中
//	 * @return
//	 */
//	public List<Dictionary> getAllDictionaryDB(){
//		List<Dictionary> list = null;
//		HibernateTemplate ht = (HibernateTemplate) SpringUtil.getBean("hibernateTemplate");
//		list = ht.find("from Dictionary");
//		return list;
//	}
//
//	/**
//	 * 加载数据库中的新闻列表数据到缓存（前六条）
//	 * @return
//	 */
//	public List<Article> getNewListDataFromDB() {
//		List<Article> list = new ArrayList<Article>();
//		ArticleDisplayService as = (ArticleDisplayService) SpringUtil.getBean("articleDisplayServiceImpl");
//		list = as.loadAllArticleDisplayListByPage(1, 6, "3");//加载公司要闻列表
//		return list;
//	}
//	
//	/**
//	 * 加载数据库中的公司产品数据到缓存（前六条）
//	 * @return
//	 */
//	public List<Article> getProductListDataFromDB() {
//		List<Article> list =  new ArrayList<Article>();
//		ArticleDisplayService as = (ArticleDisplayService) SpringUtil.getBean("articleDisplayServiceImpl");
//		list = as.loadAllArticleDisplayListByPage(1, 6, "4");//加载公司产品列表
//		return list;
//	}
//	
//	/**
//	 * 加载数据库中的科研技术列表数据到缓存（前六条）
//	 * @return
//	 */
//	public List<Article> getTechListDataFromDB() {
//		List<Article> list =  new ArrayList<Article>();
//		ArticleDisplayService as = (ArticleDisplayService) SpringUtil.getBean("articleDisplayServiceImpl");
//		list = as.loadAllArticleDisplayListByPage(1, 6, "5");//加载科研技术列表
//		return list;
//	}
//	
//	/**
//	 * 加载数据库中的科研技术列表数据到缓存（前六条）
//	 * @return
//	 */
//	public List<Article> getRegularListDataFromDB() {
//		List<Article> list = new ArrayList<Article>();
//		ArticleDisplayService as = (ArticleDisplayService) SpringUtil.getBean("articleDisplayServiceImpl");
//		List<Article> list2 = as.loadAllArticleDisplayListByPage(1, 1, "6");
//		if (list2.size()>0) {
//			list.add(list2.get(0));//人力资源
//		}
//		
//		List<Article> list3 = as.loadAllArticleDisplayListByPage(1, 1, "1");
//		if (list3.size()>0) {
//			list.add(list3.get(0));//公司概况
//		}
//		
//		List<Article> list4 = as.loadAllArticleDisplayListByPage(1, 1, "2");//联系我们
//		if (list4.size()>0) {
//			list.add(list4.get(0));//联系我们
//		}
//		return list;
//	}
//
//	/**
//	 * 加载数据库中的关键词到缓存（查询结果前四条）
//	 * @return
//	 */
//	public List<Article> getKeyWordsDataFromDB() {
//		List<Article> list = new ArrayList<Article>();
//		ArticleDisplayService as = (ArticleDisplayService) SpringUtil.getBean("articleDisplayServiceImpl");
//		list=as.loadAllArticleIdByKeyWord();
//		return list;
//	}
//	
//	
//}
