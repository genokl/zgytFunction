package cn.zgyt.dataservice.entity;

public class ColumnDefine {
	
	//属性名
	String columnName;
	
	//属性值
	String columnValue;
	//属性类型
	String columnClass;
	//是否是主键
	Integer isprimarykey;
	//字段长度（对应int和varchar）
	Integer columnLength;
	//注释
	String note;
	//是否非空	
	String isNull;
	
	/**
	 * 加字段			 addColum,
	 * 减字段           		 deleteColum,
	 * 修改字段类型/长度  	 updateColum
	 * 更新数据 		 	 updateData	
	 * 添加数据		 	 insertData	
	 * (修改字段属性接口用)
	 */
	String updateType;
	//修改的属性名(修改字段属性接口用)
	String tocolumnName;
	
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnValue() {
		return columnValue;
	}
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	public String getColumnClass() {
		return columnClass;
	}
	public void setColumnClass(String columnClass) {
		this.columnClass = columnClass;
	}
	public Integer getIsprimarykey() {
		return isprimarykey;
	}
	public void setIsprimarykey(Integer isprimarykey) {
		this.isprimarykey = isprimarykey;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIsNull() {
		return isNull;
	}
	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}
	public Integer getColumnLength() {
		return columnLength;
	}
	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public String getTocolumnName() {
		return tocolumnName;
	}
	public void setTocolumnName(String tocolumnName) {
		this.tocolumnName = tocolumnName;
	}
	
	
}
