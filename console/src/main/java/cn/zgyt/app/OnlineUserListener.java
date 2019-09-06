//package com.framework.app;
//
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//import com.framework.utils.CacheUtil;
//import com.zgyt.basic.entity.User;
///**
// * session监听器
// * @author wxy
// *
// */
//public class OnlineUserListener implements HttpSessionListener {
//
//	@Override
//	public void sessionCreated(HttpSessionEvent event) {
//	}
//
//	@Override
//	public void sessionDestroyed(HttpSessionEvent event) {
//		HttpSession session =event.getSession();
//		//清除登录缓存信息
//		Object o = session.getAttribute("loginName");
//		if(o!=null){
//			System.out.println("一个用户过期了！！！！！！"+o+"---");
//			User u = CacheUtil.userMap.get(o.toString());
//			if(u!=null&&u.getId()!=null){
//				String key = session.getAttribute("loginKey").toString();
//				CacheUtil.onLineUser.remove(key);
//			}
//		}
//	}
//
//}
