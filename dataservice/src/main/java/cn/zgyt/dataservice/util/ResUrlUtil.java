package cn.zgyt.dataservice.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.zgyt.dataservice.entity.TableVersion;
import cn.zgyt.dataservice.entity.vo.SearchVo;

public class ResUrlUtil {
	
	
	public static String ss ="dataservice";
	public static String STATUS_SUCCESS ="success";
	public static String STATUS_FAILED ="failed";

	public static String getBaseUrl(SearchVo vo) {
		HttpServletRequest req = vo.getReq();
		return req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/"+ss+"/";
	}
	public static Map<String, Object> addCRUDUrlToObj(Map<String, Object> m,SearchVo vo) {
		String baseUrl = getBaseUrl(vo);
		String tableName = vo.getTableversion().getTableName();
//		String id = (String) m.get("id");
//		String version = (String) m.get("version");
		TableVersion tv = vo.getTableversion();
		String id = (String) m.get("id");
		Map<String, Object> h=new HashMap<>();
		h.put("delete", createHrefMap(baseUrl+tableName+"/"+id));
		m.put("_links", h);
		return m;
	}
	
	public static List<Map<String, Object>> addCRUDUrlToList(List<Map<String, Object>> l,SearchVo vo) {
		if(l.size()>0) {
			for (int i = 0; i < l.size(); i++) {
				Map<String, Object> map = l.get(i);
				l.set(i, addCRUDUrlToObj(map,vo));
			}
		}
		return l;
	}
	
	public static Map addPageUrlToMap(Map<String, Object> m, SearchVo vo) {
		//http://127.0.0.1:8089/dataservice/user?page=1&size=3&version=2
		Map<String,Object> pageM = (Map<String,Object>)m.get("page");
		List<Map<String,Object>> trackings = (List<Map<String,Object>>)m.get("trackings");
		trackings = addCRUDUrlToList(trackings,vo);
		String baseUrl = getBaseUrl(vo);
		String page = vo.getPage().toString();
		String size = vo.getSize().toString();
		
		Integer totalElements = (Integer)(pageM.get("totalElements"));
		Integer totalPages = 0;
		if(totalElements%vo.getSize()==0) {
			totalPages=totalElements/vo.getSize();
		}else {
			totalPages=totalElements/vo.getSize()+1;
		}
		pageM.put("totalPages", totalPages);
//		String version = vo.getVersion();
		String tableName = vo.getTableversion().getTableName();
		Map h=new HashMap<>();
		//当前是第一页
		if(vo.getPage()==totalPages) {
			h.put("next", createHrefMap(baseUrl+tableName+"?"+"page="+totalPages+"&size="+size));
		}else {
			h.put("next", createHrefMap(baseUrl+tableName+"?"+"page="+(Integer.valueOf(page)+1)+"&size="+size));
		}
		h.put("first", createHrefMap(baseUrl+tableName+"?"+"page="+1+"&size="+size));
		h.put("self", createHrefMap(baseUrl+tableName+"?"+"page="+page+"&size="+size));
		h.put("last", createHrefMap(baseUrl+tableName+"?"+"page="+totalPages+"&size="+size));
		
		m.put("_links", h);
		return m;
	}
	
	public static Map createHrefMap(String href) {
		Map h1=new HashMap<>();
		h1.put("href", href);
		return h1;
	}

}
