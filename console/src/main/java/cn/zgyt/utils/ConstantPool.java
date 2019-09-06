package cn.zgyt.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共常量类
 * @author wz
 *
 */
public class ConstantPool {
	//后台使用
	/**
	 * 用户登录id
	 */
	public static final String LOGIN_USER_ID = "loginUserId"; //用户登录id
	
	/**
	 * 文章id
	 */
	public static final String ARTICLE_ID = "articleId"; //文章id
	
	
	
	//前台使用
	/**
	 * 前台显示    活动类型
	 */
	public static final String PORTAL_ARTICLE_TYPE = "articleType"; //文章类型

	/**
	 * 前台显示    文章Id
	 */
	public static final String PORTAL_ARTICLE_ID = "articleId"; //文章id
	
	public static final String statusCodeStr = "statusCode"; //文章id

	public static final Integer STATUS_INIT = 0;
	public static final Integer STATUS_SUCCESS = 1;
	public static final Integer STATUS_EXCEPTION = -7;

	
}
