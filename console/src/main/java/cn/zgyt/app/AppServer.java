//package cn.zgyt.app;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.framework.utils.CacheUtil;
//import com.framework.utils.SpringUtil;
//
///**
// * 本类负责容器初始化时  加载常用数据
// * @author wxy
// *
// */
//public class AppServer extends HttpServlet {
//	
//	 /**
//	  * 销毁方法
//	  */
//	@Override
//	public void destroy() {
//		super.destroy();
//	}
//	/**
//	 * 初始化执行方法
//	 */
//	@Override
//	public void init() throws ServletException {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		new SpringUtil().setApplicationContext(ac);
//		CacheUtil.LoadAllUserToCache();
//		CacheUtil.LoadAllRole();
//		CacheUtil.LoadAllResource();
//		CacheUtil.loadAllDictionary();
//		CacheUtil.loadIndexData();
//		CacheUtil.loadAllKeyWords();
//		System.out.println("System Environment: ");
//		System.out.println("最大可用内存(xmx)："+(Runtime.getRuntime().maxMemory()/1024/1024)+"MB");
//		System.out.println("当前JVM空闲内存："+(Runtime.getRuntime().freeMemory()/1024/1024)+"MB");
//		System.out.println("system encoding  "+System.getProperty("file.encoding"));
//		//System.out.println("当前JVM占用的内存总数："+Runtime.getRuntime().totalMemory());
//		
//	}
//	
//}
