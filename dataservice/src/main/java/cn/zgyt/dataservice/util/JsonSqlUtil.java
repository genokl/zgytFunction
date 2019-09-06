package cn.zgyt.dataservice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import cn.zgyt.dataservice.entity.ColumnDefine;
import cn.zgyt.dataservice.entity.TableDefine;
public class JsonSqlUtil {
	
	public static Map<String, String> mysqlToJava=new HashMap<String, String>();
	public static Map<String, String> javaToMysql=new HashMap<String, String>();
	
	public static  String getUuid(){
        String s= UUID.randomUUID().toString();
        return s.replace("-", "");
        
     }
	/**
	  * 添加主键动作
	 */
	public static ColumnDefine getPrimarykeyInfo() {
		ColumnDefine cd1 = new ColumnDefine();
		cd1.setColumnClass("varchar");
		cd1.setColumnLength(100);
		cd1.setColumnName("id");
		cd1.setIsprimarykey(1);
		cd1.setIsNull("not null");
		return cd1;
	}
	
	public static List<String> entryToAddDataSql(TableDefine td) {
		StringBuffer sql=new StringBuffer();
		StringBuffer key=new StringBuffer();
		StringBuffer val=new StringBuffer();
		List<Map<String,String>> list = td.getDataList();
		List<String> ll = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String condition="";
			sql.append("INSERT INTO "+td.getTableName());
			Map<String, String> map = list.get(i);
			Set<Entry<String,String>> entrySet = map.entrySet();
			key.append("id,");
			val.append("'"+getUuid()+"',");
			for (Entry<String, String> entry : entrySet) {
				if(!entry.getKey().equals("id")) {
					key.append(entry.getKey()+",");
					val.append(entry.getValue()+",");
				}
			}
			sql.append(" ( "+key.toString().substring(0, key.length()-1)+" ) ");
			sql.append("VALUES  ( "+val.toString().substring(0, val.length()-1)+" ) ;");
			ll.add(sql.toString());
			sql.setLength(0);
			key.setLength(0);
			val.setLength(0);
		}
		return ll;
	}
	
	public static List<String> entryToUpdateDataSql(TableDefine td) {
		List<Map<String,String>> list = td.getDataList();
		StringBuffer sql=new StringBuffer();
		List<String> ll = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			Set<Entry<String,String>> es = map.entrySet();
			sql.append("UPDATE "+td.getTableName()+" SET ");
			for (Entry<String, String> entry : es) {
				if(!entry.getKey().equals("id")) {
					sql.append(entry.getKey()+" = "+entry.getValue());
				}
			}
			sql.append(" WHERE id="+map.get("id")+";");
			ll.add(sql.toString());
			sql.setLength(0);
		}
		return ll;
	}

	//根据条件生成sql
	public static List<String> entryToUpdateWithConditionDataSql(TableDefine td, List<Map<String, String>> dl2) {
		List<Map<String,String>> list = td.getDataList();
		StringBuffer sql=new StringBuffer();
		StringBuffer key=new StringBuffer();
		StringBuffer val=new StringBuffer();
		List<String> ll = new ArrayList<String>();
		String ls="";
		for (int i = 0; i < dl2.size(); i++) {
			Map<String, String> map = dl2.get(i);
			Set<Entry<String,String>> es = map.entrySet();
			sql.append("UPDATE "+td.getTableName()+" SET ");
			for (Entry<String, String> entry : es) {
				if(!entry.getKey().equals("condition")) {
					ls+=entry.getKey()+" = "+entry.getValue()+",";
				}
			}
			sql.append(ls.substring(0, ls.length()-1));
			sql.append(" WHERE "+map.get("condition")+";");
			ll.add(sql.toString());
			sql.setLength(0);
		}
		
		for (int i = 0; i < list.size();i++) {
			sql.append("INSERT INTO "+td.getTableName());
			key.append("id,");
			val.append("'"+UUID.randomUUID()+"',");
			for (Entry<String, String> entry : list.get(i).entrySet()) {
				if(!entry.getKey().equals("condition")) {
					key.append(entry.getKey()+",");
					val.append(entry.getValue()+",");
				}else {
					String[] ss = entry.getValue().split("=");
					key.append(ss[0]+",");
					val.append(ss[1]+",");
				}
			}
			sql.append(" ( "+key.toString().substring(0, key.length()-1)+" ) ");
			sql.append("VALUES  ( "+val.toString().substring(0, val.length()-1)+" ) ;");
			ll.add(sql.toString());
			sql.setLength(0);
			key.setLength(0);
			val.setLength(0);
		}
		return ll;
	}
	//根据条件生成sql
	public static List<String> entryToInsertWithConditionDataSql(TableDefine td) {
		List<Map<String,String>> list = td.getDataList();
		StringBuffer sql=new StringBuffer();
		List<String> ll = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			Set<Entry<String,String>> es = map.entrySet();
			sql.append("UPDATE "+td.getTableName()+" SET ");
			for (Entry<String, String> entry : es) {
				if(!entry.getKey().equals("condition")) {
					sql.append(entry.getKey()+" = "+entry.getValue());
				}
			}
			sql.append(" WHERE "+map.get("condition")+";");
			ll.add(sql.toString());
			sql.setLength(0);
		}
		return ll;
	}
//	public static String setVal(String name,String val,Map<String, String> columTypeList) {
//		if(CommonUtil.checkFull(columTypeList.get(name))) {
//			String type = columTypeList.get(name);
//			if(type.equals(DbUtil.TYPE_DATETIME)) {
//				return 
//			}else if(type.equals(DbUtil.TYPE_DATETIME)) {
//				
//			}
//				return val
//		}
//		return val;
//	}
	

}
