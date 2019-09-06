package cn.zgyt.dataservice.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import cn.zgyt.dataservice.entity.TableVersion;
import cn.zgyt.dataservice.entity.vo.SearchVo;


public class CommonUtil {

	
	public static String getJsonStr(String key,Object value) {
		Gson g=new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		return g.toJson(map);
	}
	
	/**
	 * 获取范围随机数[m,n]
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static Integer loadRandomNum(Integer m, Integer n) {
		return m + (int) (Math.random() * (n + 1 - m));
	}
	
	public static SearchVo parseSearchUrl(String url, SearchVo vo,HttpServletRequest req) throws Exception {
		vo.setReq(req);
		//http://127.0.0.1:8089/search/    testuser/rowid/Z1-28-B8-5
		String[] ss = url.split("/");
		String tableName="";
		String condition=" 1=1 ";
		if(ss.length==3) {
			tableName=ss[0];
			condition+=("and "+ss[1]+"='"+ss[2]+"'");
		}else {
			throw new Exception("parameter error");
		}
		TableVersion tv=new TableVersion();
		tv.setTableName(tableName);
		vo.setCondition(condition);
		//设置查询条件
		if(vo.getPage()!=null) {
			vo.setQueryType("list");
		}else {
			vo.setQueryType("one");
		}
//			tv.setVersion(vo.getVersion());
		vo.setCondition(condition);
		vo.setTableversion(tv);
		return vo;
	}
	/**
	  * 解析url
	 * @param url
	 * @param vo 
	 * @return
	 */
	public static SearchVo parseUrl(String url, SearchVo vo,HttpServletRequest req) {
		vo.setReq(req);
		String[] ss = url.split("/");
		String tableName="";
		String id="";
		String condition="1=1 ";
			tableName=ss[0];
		if(ss.length>1) {
			id=ss[1];
		}
		TableVersion tv=new TableVersion();
		tv.setTableName(tableName);
		//设置查询条件
		if(!checkFull(id)) {
			condition+="and id ='"+id+"'";
//			tv.setId(id);
		}
		if(vo.getPage()!=null) {
			vo.setQueryType("list");
		}else {
			vo.setQueryType("one");
		}
//			tv.setVersion(vo.getVersion());
		vo.setCondition(condition);
		vo.setTableversion(tv);
		return vo;
	}
	/**
	 * 获取指定url中的某个参数
	 * @param url
	 * @param name
	 * @return
	 */
	public static String getParamByUrl(String url, String name) {
	    url += "&";
	    String pattern = "(\\?|&){1}#{0,1}" + name + "=[a-zA-Z0-9]*(&{1})";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(url);
	    if (m.find( )) {
	        System.out.println(m.group(0));
	        return m.group(0).split("=")[1].replace("&", "");
	    } else {
	        return null;
	    }
	}

	/**
	 * 四舍五入
	 * 
	 * @param m
	 * @param type 1进一法
	 */
	public static Double roundNum(Double m, Integer type) {
		if (type == 1) {
			String ss = m.toString();
			int s1 = Integer.valueOf(ss.substring(0, 1)) + 1;
			int length = ss.split("\\.")[0].length();
			Double s2 = s1 * (Math.pow(10, length - 1));
			return s2;
		}
		return m;
	}

	/**
	 * 检查字符串是否为空, 为空则返回true 反之返回false
	 * @param param
	 * @return
	 */
	public static boolean checkFull(String param) {
		return ((null == param || "".equals(param.trim()) || "null".equals(param.trim())) ? true : false);
	}

	public static String getStringFromStream(HttpServletRequest req) {
		ServletInputStream is;
		try {
			is = req.getInputStream();
			int nRead = 1;
			int nTotalRead = 0;
			byte[] bytes = new byte[10240];
			while (nRead > 0) {
				nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
				if (nRead > 0)
					nTotalRead = nTotalRead + nRead;
			}
			String str = new String(bytes, 0, nTotalRead, "utf-8");
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	
	public static void main(String[] args) {
		double a = 745*20;
		double b=a;
//		for (int i = 0; i < 9; i++) {
//			System.out.println(i);
//			a=a*0.9;
//			b+=a;
//			System.out.println(b);
//		}
		double c = (a*Math.pow(0.9, 9)+a)*10/2;
		System.out.println(c);
	}
}
