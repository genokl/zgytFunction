package cn.zgyt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.zgyt.app.cacheBeans.UserCacheInfo;
import cn.zgyt.entiry.Product;
import cn.zgyt.entiry.user.Resource;
import cn.zgyt.entiry.user.Role;
import cn.zgyt.entiry.user.User;

/**
 * user 工具类
 * @author dell
 *
 */
public class CacheUtil {
	/**
	 * 用户缓存对象
	 * key 用户名
	 * value  用户对象
	 */
	public static Map<String,User> userMap = new ConcurrentHashMap<String,User>();
	/**
	 * 角色缓存对象
	 * key 角色ID 
	 * value 角色对象
	 */
	public static Map<Integer,Role> roleMap = new ConcurrentHashMap<Integer,Role>();
	/**
	 * 资源缓存对象
	 * key  资源ID 
	 * value 资源对象
	 */
	public static Map<Integer,Resource> resourceMap = new ConcurrentHashMap<Integer,Resource>();
	/**
	 * 登录用户集合
	 *  key  用户登录key 
	 *  value  用户对象 
	 */
	public static Map<String,UserCacheInfo> onLineUser = new ConcurrentHashMap<String,UserCacheInfo>();
//	/**
//	 * 用户隐藏属性 map
//	 * key  可以资料  属性下标
//	 * value 客户资料对象
//	 */
//	public static Map<Integer,ClientHidenInfo> hindeMap= new ConcurrentHashMap<Integer ,ClientHidenInfo>();
	/**
	 * 数据字典
	 * key 需要转换的key
	 * value  转换后的值
	 */
	public static Map<String ,String> dictionaryMap= new ConcurrentHashMap<String, String>();
	
	/**
	 * 数据字典解密
	 */
	public static Map<String ,String> dictionaryUndoMap= new ConcurrentHashMap<String, String>();
	
	/**
	 * 首页文章Map
	 *  key Article ID 
	 * value Article对象
	 * 
	 */
	public static List<Product> indexNewsList= new ArrayList<Product>();
	
	/**
	 * 首页文章Map
	 *  key Article ID 
	 * value Article对象
	 */
	public static List<Product> indexProductsList= new ArrayList<Product>();

	/**
	 * 首页文章Map
	 *  key Article ID 
	 * value Article对象
	 */
	public static List<Product> indexTechList= new ArrayList<Product>();
	
	/**
	 * 首页文章Map
	 *  key Article ID 
	 * value Article对象
	 */
	public static Map<Integer ,Product> indexRegularDataMap= new ConcurrentHashMap<Integer, Product>();
	
	/**
	 * 关键词Map
	 *  key Article ID 
	 * value Article对象
	 */
	public static List<Product> keyWordsList= new ArrayList<Product>();
	
//	/**
//	 * 公司内网IP
//	 */
//	public static final String FIRM_IP_ADD="124.193.139.234";
//	public static final String FIRM_IP_ADD2="124.200.189.34";
	
	
	
//	/**
//	 * 加载全部的用户到 缓存中去
//	 */
//	public static void LoadAllUserToCache(){
//		List<User> list = new LoadEntityDB().getUserDataFromDB();
//		User u = null;
//		for(int i=0;i<list.size();i++){
//			u = list.get(i);
//			//对密码进行二次加密
//			u.setPassword(CommonUtils.strToMD5(u.getPassword(), 32));
//			CacheUtil.userMap.put(u.getName(), u);
//		}
//	}
//	/**
//	 * 加载全部角色
//	 */
//	public static void LoadAllResource(){
//		List<Role> l = new LoadEntityDB().getRoleDataFromDB();
//		for (Role r : l) {
//			 CacheUtil.roleMap.put(r.getId(), r);
//		}
//	}
//	/**
//	 * 加载全部资源
//	 */
//	public static void LoadAllRole(){
//		 List<Resource> l= new LoadEntityDB().getResourceDataFromDB();
//		 for (Resource r : l) {
//			 CacheUtil.resourceMap.put(r.getId(), r);
//		}
//	}
//	/**
//	 * 根据ID 在缓存中查询 用户对象
//	 * @param userId
//	 * @return
//	 */
//	public static User getUserById(int userId){
//		for (Map.Entry<String, User> em :userMap.entrySet()) {
//			if(userId==em.getValue().getId()){
//				return em.getValue();
//			}
//		}
//		return null;
//	}
//	
//	/**
//	 * 根据角色名 获取角色实体对象 
//	 * @param roleName 角色名
//	 * @return  没有则返回空
//	 */
//	public static Role getRoleByName(String roleName){
//		for (Map.Entry<Integer, Role> em:CacheUtil.roleMap.entrySet()) {
//			if(em.getValue().getName().equals(roleName)){
//				return em.getValue();
//			}
//		}
//		return null;
//	}
//	
//	/**
//	 * 加载数据字典
//	 */
//	public static void loadAllDictionary(){
//		List<Dictionary> list=new LoadEntityDB().getAllDictionaryDB();
//		for (Dictionary d : list) {
//			CacheUtil.dictionaryMap.put(d.getKey(), d.getValue());
//			CacheUtil.dictionaryUndoMap.put(d.getValue(), d.getKey());
//		}
//	}
//	/**
//	 * 加载首页数据
//	 */
//	public static void loadIndexData() {
//		//加载新闻列表数据
//		/**
//		 *  3，公司要闻
//		 */
//		CacheUtil.indexNewsList = new LoadEntityDB().getNewListDataFromDB();//加载公司要闻列表
////		if (l!=null) {
////			for(int i=0;i<l.size();i++){
////				CacheUtil.indexNewsList.add(l.get(i));
////			}
////		}
//		
//		/**
//		 * 4公司产品
//		 */
//		CacheUtil.indexProductsList = new LoadEntityDB().getProductListDataFromDB();//加载公司产品列表
////		if (l2!=null) {
////			for(int i=0;i<l2.size();i++){
////				CacheUtil.indexProductsList.put(l2.get(i).getId(), l2.get(i));
////			}
////		}
//		/**
//		 * 5，科研技术
//		 */
//		CacheUtil.indexTechList = new LoadEntityDB().getTechListDataFromDB();//加载公司科研技术列表
////		if (l3!=null) {
////			for(int i=0;i<l3.size();i++){
////				CacheUtil.indexTechList.put(l3.get(i).getId(), l3.get(i));
////			}
////		}
//		
//		/**
//		 * indexProductsMap
//		 * 此map中
//		 * key ArticleType  1，2，6 		1，公司概况  2,联系我们  6，人力资源
//		 * value Article对象
//		 */
//		List<Article> l4 = new LoadEntityDB().getRegularListDataFromDB();
//		if (l4!=null) {
//			//加载固定数据列表 分别是  公司概况，联系我们，人力资源
//			for(int i=0;i<l4.size();i++){
//				CacheUtil.indexRegularDataMap.put(l4.get(i).getArticleType(), l4.get(i));
//			}
//		}
//		
//	}
//	
//	/**
//	 * 添加新增文章到首页缓存
//	 */
//	public static void addArticleToCache(Article a) {
//		Integer articleType = a.getArticleType();
//		if (articleType==1||articleType==2||articleType==6) {//1,公司概况 2,联系我们 6，人力资源
//			indexRegularDataMap.put(articleType, a);
//		}else if (articleType==3) {//3，公司要闻
//			if (indexNewsList.size()==6) {
//				indexNewsList.remove(5);
//				indexNewsList.add(0, a);
//			}else {
//				indexNewsList.add(0, a);
//			}
//		}else if (articleType==4) {//4公司产品
//			if (indexProductsList.size()==6) {
//				indexProductsList.remove(5);
//				indexProductsList.add(0, a);
//			}else {
//				indexProductsList.add(0, a);
//			}
//		}else if (articleType==5) {//5，科研技术
//			if (indexTechList.size()==6) {
//				indexTechList.remove(5);
//				indexTechList.add(0, a);
//			}else {
//				indexTechList.add(0, a);
//			}
//		}
//	}
//	/**
//	 * 更新首页缓存数据
//	 */
//	public static void updateArticleToCache(Article a) {
//		Integer articleType = a.getArticleType();
//		if (articleType==1||articleType==2||articleType==6) {//1,公司概况 2,联系我们 6，人力资源
//			indexRegularDataMap.put(articleType, a);
//		}else if (articleType==3) {//3，公司要闻
//			if (indexNewsList.contains(a)) {
//				indexNewsList.remove(a);
//				indexNewsList.add(0, a);
//			}
//		}else if (articleType==4) {//4公司产品
//			if (indexProductsList.contains(a)) {
//				indexProductsList.remove(a);
//				indexProductsList.add(0, a);
//			}
//		}else if (articleType==5) {//5，科研技术
//			if (indexTechList.contains(a)) {
//				indexTechList.remove(a);
//				indexTechList.add(0, a);
//			}
//		}
//	}
//	/**
//	 * 加载所有关键词到缓存
//	 */
//	public static void loadAllKeyWords() {
//		keyWordsList = new LoadEntityDB().getKeyWordsDataFromDB();
//	}
//	
}
