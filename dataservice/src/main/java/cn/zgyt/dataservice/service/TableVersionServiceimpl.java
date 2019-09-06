package cn.zgyt.dataservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import cn.zgyt.dataservice.entity.TableDefine;
import cn.zgyt.dataservice.entity.TableVersion;
import cn.zgyt.dataservice.entity.vo.SearchVo;
import cn.zgyt.dataservice.liquibase.LiquiHelpUtil;
import cn.zgyt.dataservice.repository.TableVersionRepository;
import cn.zgyt.dataservice.util.DbUtil;
import cn.zgyt.dataservice.util.JsonSqlUtil;
import cn.zgyt.dataservice.util.XMLUtil;

@Service
public class TableVersionServiceimpl {

	@Autowired
    private TableVersionRepository tableVersionRepository;
	
	
	@Value("${spring.application.changeLogBasePath:path}")
	private String changeLogBasePath;
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	//增加自定义表指定数据
	@Transactional(rollbackFor = Exception.class )
	public Integer insertDataForJson(String str, String path) throws Exception{
		Gson g=new Gson();
		TableDefine td = g.fromJson(str, TableDefine.class);
		List<TableVersion> ls = tableVersionRepository.findByTableName(td.getTableName());
		if(ls.size()==1) {
			td.setPath(path);
			List<Map<String,String>> list = td.getDataList();
			//生成sql
			List<String> ll = JsonSqlUtil.entryToAddDataSql(td);
			DbUtil.exquteUpdateSqlBatch(ll, jdbcTemplate);
		}else {
			throw new Exception("no find table:"+td.getTableName());
		}
		return null;
	}
	
	//更新自定义表指定数据
	@Transactional(rollbackFor = Exception.class )
	public void updateDataForJson(TableDefine td, String path) throws Exception{
		td.setPath(path);
		List<TableVersion> ls = tableVersionRepository.findByTableName(td.getTableName());
		if(ls.size()==1) {
			List<Map<String,String>> dl = DbUtil.getColumType(td.getDataList(),td.getTableName(),jdbcTemplate);
			td.setDataList(dl);
			List<String> ll = JsonSqlUtil.entryToUpdateDataSql(td);
			DbUtil.exquteUpdateSqlBatch(ll, jdbcTemplate);
			
		}else {
			throw new Exception("no find table:"+td.getTableName());
		}
	}
	/**
	 * 更新或添加excel中的数据
	 * @param td
	 * updateDataWithCondition(td);
	 */
	@Transactional(rollbackFor = Exception.class )
	public void updateDataWithCondition(TableDefine td)throws Exception {
		List<Map<String, String>> dl = td.getDataList();
		List<TableVersion> ls = tableVersionRepository.findByTableName(td.getTableName());
		if(ls.size()==1) {
			String sql="SELECT * FROM "+td.getTableName();
			String colum="";
			String condition=" (";
			String conditionStr="";
			for (int i = 0; i < dl.size(); i++) {
				String con = dl.get(i).get("condition");
				String[] ss = con.split("=");
				if(ss[1].startsWith("'")) {
					condition+=ss[1]+",";
				}else {
					condition+="'"+ss[1]+"',";
				}
				colum=ss[0];
				conditionStr=ss[0];
			}
			sql+=" WHERE "+colum+" in "+condition.substring(0, condition.length()-1)+")";
			List<Map<String,Object>> list = DbUtil.exquteQuerySql(sql, jdbcTemplate);
			List<Map<String, String>> dl2=new ArrayList<Map<String, String>>();
			List<Map<String, String>> dl3=new ArrayList<Map<String, String>>();
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < dl.size(); j++) {
					String val = (String) list.get(i).get(conditionStr);
					if(dl.get(j).get("condition").equals(conditionStr+"="+val+"")) {
						dl2.add(dl.get(j));
						dl.remove(j);
					}
				}
			}
//			td.setDataList(dl);
			td.setDataList(DbUtil.getColumType(dl, td.getTableName(), jdbcTemplate));
			dl2=DbUtil.getColumType(dl2, td.getTableName(), jdbcTemplate);
			List<String> ll = JsonSqlUtil.entryToUpdateWithConditionDataSql(td, dl2);
			DbUtil.exquteUpdateSqlBatch(ll, jdbcTemplate);
		}else {
			throw new Exception("no find table:"+td.getTableName());
		}
	}

	//删除自定义表指定数据
	@Transactional(rollbackFor = Exception.class )
	public String delObjData(SearchVo vo) throws Exception{
		String res="";
		//记录表创建关系记录
		TableVersion tv = vo.getTableversion();
		List<TableVersion> ls = tableVersionRepository.findByTableName(tv.getTableName());
		String exquteUpdateSql="";
		if(ls.size()==1) {
			String sql="DELETE FROM "+tv.getTableName()+" WHERE "+vo.getCondition();
			exquteUpdateSql = DbUtil.exquteUpdateSqlOne(sql, jdbcTemplate);
		}else {
			throw new Exception("no find table:"+tv.getTableName());
		}
		return exquteUpdateSql;
	}
		
	//查询对象
	public Map<String,Object> findObjWithMap(SearchVo vo) throws Exception{
		String res="";
		//记录表创建关系记录
		TableVersion tv = vo.getTableversion();
		List<TableVersion> list = tableVersionRepository.findByTableName(tv.getTableName());
		if(list.size()==1) {//"+list.get(0).getColumnStr()+"
			String sql="select * from "+tv.getTableName()+" where "+vo.getCondition();
			List<String> ls=new ArrayList<>();
			ls.add("id");
			ls.add("project");
			DbUtil.queryColumType(ls,tv.getTableName(), jdbcTemplate);
			List<Map<String,Object>> list2 = DbUtil.exquteQuerySql(sql, jdbcTemplate);
			if(list2.size()>0) {
				Map<String, Object> map = list2.get(0);
				return map;
			}
		}else {
			throw new Exception("no find table:"+tv.getTableName());
		}
		return null;
	}
	
	//查询列表
	public Map<String,Object> findListWithMap(SearchVo vo) throws Exception{
		String res="";
		Map<String, Object> m=new HashMap<>();
		//记录表创建关系记录
		TableVersion tv = vo.getTableversion();
		List<TableVersion> list = tableVersionRepository.findByTableName(tv.getTableName());
		if(list.size()==1) {//"+list.get(0).getColumnStr()+"
			String sql="select * from "+tv.getTableName()+" where "+vo.getCondition();
			if(vo.getSize()!=-1) {//查全部
				sql+=" limit "+(vo.getPage()-1)*vo.getSize()+","+vo.getSize();
			}
			List<Map<String,Object>> list2 = DbUtil.exquteQuerySql(sql, jdbcTemplate);
			String sql2="select count(id) from "+tv.getTableName()+" where "+vo.getCondition();
			Integer totalElements = DbUtil.querySqlForCount(sql2, jdbcTemplate);
			m.put("trackings", list2);
			Map<String, Object> page=new HashMap<>();
			page.put("size", vo.getSize());//每页显示数
			page.put("totalElements", totalElements);//总条数
//			page.put("totalPages", (int)(totalElements/vo.getSize()+1)+"");//总页数
			page.put("number", vo.getPage());//当前页数
			m.put("page", page);
		}else {
			throw new Exception("no find table:"+tv.getTableName());
		}
		return m;
	}
	
	
	//=============================================================================================================
	
	//创建表by liquibase
	@Transactional(rollbackFor = Exception.class )
	public String createTableForJson(TableDefine td, String[] paramArrRest) throws Exception{
		String filePath="";
		TableVersion tv = new TableVersion();
		//td.setPath(paramArrRest);
		//记录表创建关系记录
		tv.setCreateDate(new Date());
		tv.setTableName(td.getTableName());
		List<TableVersion> list = tableVersionRepository.findByTableName(tv.getTableName());
		if(list.size()==0) {//"+list.get(0).getColumnStr()+"
			tableVersionRepository.save(tv);//添加tableversion数据
			filePath= changeLogBasePath + "/" + td.getTableName() + ".xml";
			XMLUtil.parseTableDefineToXml(filePath, td);//生成xml文件
			LiquiHelpUtil.excuteUpdate(filePath, jdbcTemplate);//执行xml文件
		}else {
			throw new Exception("no find table:"+tv.getTableName());
		}
		return td.getTableName();
	}

	//删除表by liquibase
	@Transactional(rollbackFor = Exception.class )
	public Map delTable(String tableName) throws Exception{
		Map m=new HashMap<>();
		TableVersion tv=new TableVersion();
		tv.setTableName(tableName);
		//删除关系表数据
		tableVersionRepository.deleteByTableName(tableName);
		//创建删除自定义表文件
		String filePath=changeLogBasePath+"/"+tableName+".xml";
		//删除关系表记录
		tableVersionRepository.deleteByTableName(tv.getTableName());
		//删除liquibase记录
		delDatabasechangelog(filePath);
		XMLUtil.createDelXml(filePath,tableName);
		LiquiHelpUtil.excuteUpdate(filePath, jdbcTemplate);
		return m;
	}
	
	//删除表databasechangelog数据 
	@Transactional(rollbackFor = Exception.class )
	public String delDatabasechangelog(String filePath) throws Exception{
		String sql="DELETE FROM databasechangelog WHERE FILENAME = '"+filePath+"'";
		DbUtil.exquteUpdateSqlOne(sql, jdbcTemplate);
		XMLUtil.delXmlByPath(filePath);
		return "";
	}
	
	//更新表结构  加减字段 修改字段类型 修改字段长度 修改字段名
	@Transactional(rollbackFor = Exception.class )
	public void updateTableForJson(String str, String path) throws Exception{
		Gson g=new Gson();
		TableDefine td = g.fromJson(str, TableDefine.class);
		td.setPath(path);
//			List<String> sql = JsonSqlUtil.createAlterTableSql(td);
//			DbUtil.exquteUpdateSqlBatch(sql, jdbcTemplate);
	}
	
	
}
