package cn.zgyt.dataservice.entity;

import java.util.List;
import java.util.Map;

public class TableDefine {
	
	private String path;
	
	//表名
	private String tableName;
	//表名
	private String version;
	//存储引擎
	private String ENGINE;
	//主键策略
	private String primerKeyGenerator;
	//表存储字符
	private String CHARSET;
	
	/**
	 * 更新数据 		 	 updateData	
	 * 按条件添加数据		 	 conditionUpdate	
	 */
	private String updateType;
	
	
	List<ColumnDefine> ColumnDefineList;
	List<ConstraintsDefine> ConstraintsDefineList;
	
	List<Map<String, String>> dataList;
	
	
	public List<ColumnDefine> getColumnDefineList() {
		return ColumnDefineList;
	}
	public void setColumnDefineList(List<ColumnDefine> columnDefineList) {
		ColumnDefineList = columnDefineList;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<ConstraintsDefine> getConstraintsDefineList() {
		return ConstraintsDefineList;
	}
	public void setConstraintsDefineList(List<ConstraintsDefine> constraintsDefineList) {
		ConstraintsDefineList = constraintsDefineList;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getENGINE() {
		return ENGINE;
	}
	public void setENGINE(String eNGINE) {
		ENGINE = eNGINE;
	}
	public String getCHARSET() {
		return CHARSET;
	}
	public void setCHARSET(String cHARSET) {
		CHARSET = cHARSET;
	}
	public String getPrimerKeyGenerator() {
		return primerKeyGenerator;
	}
	public void setPrimerKeyGenerator(String primerKeyGenerator) {
		this.primerKeyGenerator = primerKeyGenerator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<Map<String, String>> getDataList() {
		return dataList;
	}
	public void setDataList(List<Map<String, String>> dataList) {
		this.dataList = dataList;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

}
