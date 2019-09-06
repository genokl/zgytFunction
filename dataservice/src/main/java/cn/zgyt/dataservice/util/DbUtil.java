package cn.zgyt.dataservice.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

public class DbUtil {
	public static String TYPE_VARCHAR="VARCHAR";
	public static String TYPE_INT="INT";
	public static String TYPE_DATETIME="DATETIME";
	
	/**
	 * 执行sql
	 * 返回json
	 */
	public static List<Map<String, Object>> exquteQuerySql(String sql,JdbcTemplate jt) {
	    List<Map<String, Object>> rows = jt.queryForList(sql);
		return  rows;
	}
	
	public static Integer querySqlForCount(String sql,JdbcTemplate jt) {
		return  jt.queryForObject(sql, Integer.class);
	}
	
	public static String exquteUpdateSqlOne(String sql,JdbcTemplate jt) {
		int executeUpdate = jt.update(sql);
		return CommonUtil.getJsonStr("affectedRows", executeUpdate);
	}
	
	public static String exquteUpdateSqlBatch(List<String> ll,JdbcTemplate jt) {
		if(ll!=null&&ll.size()>0) {
			String[] strings = new String[ll.size()];
			String[] array = ll.toArray(strings);
			jt.batchUpdate(array);
		}
		return "";
	}
	/**
	 * ColumnType
	 * @param List<String> ll 字段名集合
	 * @param String tableName 表名
	 */
	public static List<Map<String, String>> getColumType(List<Map<String, String>> m,String tableName,JdbcTemplate jt) throws NumberFormatException, SQLException {
		List<Map<String, String>> lm=new ArrayList<>();
		if(m.size()!=0) {
			List<String> ll=new ArrayList<>();
			List<String> lvalue=new ArrayList<>();
			for (Map<String, String> map : m) {
				for (Entry<String, String> ss : map.entrySet()) {
					if(ss.getKey().equals("condition")) {
						ll.add(ss.getValue().split("=")[0]);
					}else {
						ll.add(ss.getKey());
					}
				}
			}
			Map<String, String> columType = queryColumType(ll, tableName, jt);
			for (int i = 0; i < m.size(); i++) {
				Map<String, String> ms=new HashMap<>();
				Set<Entry<String, String>> entry = m.get(i).entrySet();
				for (Entry<String, String> e2 : entry) {
					String key="";
					String val="";
					if(e2.getKey().equals("condition")) {
						key=e2.getValue().split("=")[0];
						val=e2.getValue().split("=")[1];
						if(columType.get(key).equals(TYPE_VARCHAR)) {
							ms.put(e2.getKey(),key+"='"+val+"'");
						}else if (columType.get(key).equals(TYPE_DATETIME)) {
							ms.put(e2.getKey(),key+"='"+val+"'");
						}else {
							ms.put(e2.getKey(),e2.getValue());
						}
					}else {
						if(columType.get(e2.getKey()).equals(TYPE_VARCHAR)) {
							ms.put(e2.getKey(),"'"+e2.getValue()+"'");
						}else if (columType.get(e2.getKey()).equals(TYPE_DATETIME)) {
							ms.put(e2.getKey(),"'"+e2.getValue()+"'");
						}else {
							ms.put(e2.getKey(),e2.getValue());
						}
					}
				}
				lm.add(ms);
			}
		}
		return lm;
	}
	/**
	 * 获取字段的ColumnType
	 * @param List<String> ll 字段名集合
	 * @param String tableName 表名
	 */
	public static Map<String, String> queryColumType(List<String> ll,String tableName,JdbcTemplate jt) throws NumberFormatException, SQLException {
		String sql="select ";
		for (int i = 0; i < ll.size(); i++) {
			sql+=ll.get(i)+",";
		}
		sql=sql.substring(0, sql.length()-1);
		sql+=" from "+tableName;
		SqlRowSet rowSet = jt.queryForRowSet(sql);  
		SqlRowSetMetaData metaData = rowSet.getMetaData();  
		int columnCount = metaData.getColumnCount();  
		Map<String,String> fieldMap = new HashMap<String,String>();  
		for (int i = 1; i <= columnCount; i++) {    
		    fieldMap.put(metaData.getColumnName(i), metaData.getColumnTypeName(i));  
		}
		return fieldMap;
	}
	
}
