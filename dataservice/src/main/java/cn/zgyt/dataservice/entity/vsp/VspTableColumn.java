package cn.zgyt.dataservice.entity.vsp;

import java.util.List;

public class VspTableColumn {
	/**
	 * 本组起点x坐标
	 */
	private Integer group_StartX;
	/**
	 * 本组起点y坐标
	 */
	private Integer group_StartY;
	
	/**
	 * 每组竖向间隔(组外间隔)
	 */
	private Integer group_interval_XLength;
	/**
	 * 每组竖向间隔(组外间隔)
	 */
	private Integer group_interval_YLength;
	
	/**
	 * 每组横向宽度
	 */
	private Integer group_X_length;
	/**
	 * 每组竖向高度
	 */
	private Integer group_Y_length;
	
	/**
	 * 每组竖table数
	 */
	private Integer group_X_Table_Num;
	/**
	 * 每组竖table数
	 */
	private Integer group_Y_Table_Num;
	
	/**
	 * 组间table横间隔
	 */
	private Integer Table_X_interval;
	/**
	 * 组间table竖间隔
	 */
	private Integer Table_Y_interval;
	/**
	 * 每table宽
	 */
	private Integer Table_X_length;
	/**
	 * 每table长
	 */
	private Integer Table_Y_length;
	/**
	 * 本组id
	 */
	private String groupid ;
	/**
	 * 本组id（数据库）
	 */
	private String id ;
	
	private List<VspSpecTable> specTableS ;//本组特殊列
	private List<String> rowIdl ;//本组特殊列
	
	
	
	public Integer getGroup_StartX() {
		return group_StartX;
	}
	public void setGroup_StartX(Integer group_StartX) {
		this.group_StartX = group_StartX;
	}
	public Integer getGroup_StartY() {
		return group_StartY;
	}
	public void setGroup_StartY(Integer group_StartY) {
		this.group_StartY = group_StartY;
	}
	public Integer getGroup_interval_XLength() {
		return group_interval_XLength;
	}
	public void setGroup_interval_XLength(Integer group_interval_XLength) {
		this.group_interval_XLength = group_interval_XLength;
	}
	public Integer getGroup_interval_YLength() {
		return group_interval_YLength;
	}
	public void setGroup_interval_YLength(Integer group_interval_YLength) {
		this.group_interval_YLength = group_interval_YLength;
	}
	public Integer getGroup_X_length() {
		return group_X_length;
	}
	public void setGroup_X_length(Integer group_X_length) {
		this.group_X_length = group_X_length;
	}
	public Integer getGroup_Y_length() {
		return group_Y_length;
	}
	public void setGroup_Y_length(Integer group_Y_length) {
		this.group_Y_length = group_Y_length;
	}
	public Integer getGroup_X_Table_Num() {
		return group_X_Table_Num;
	}
	public void setGroup_X_Table_Num(Integer group_X_Table_Num) {
		this.group_X_Table_Num = group_X_Table_Num;
	}
	public Integer getTable_X_interval() {
		return Table_X_interval;
	}
	public void setTable_X_interval(Integer table_X_interval) {
		Table_X_interval = table_X_interval;
	}
	public Integer getTable_Y_interval() {
		return Table_Y_interval;
	}
	public void setTable_Y_interval(Integer table_Y_interval) {
		Table_Y_interval = table_Y_interval;
	}
	public Integer getTable_X_length() {
		return Table_X_length;
	}
	public void setTable_X_length(Integer table_X_length) {
		Table_X_length = table_X_length;
	}
	public Integer getTable_Y_length() {
		return Table_Y_length;
	}
	public void setTable_Y_length(Integer table_Y_length) {
		Table_Y_length = table_Y_length;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public List<VspSpecTable> getSpecTableS() {
		return specTableS;
	}
	public void setSpecTableS(List<VspSpecTable> specTableS) {
		this.specTableS = specTableS;
	}
	public Integer getGroup_Y_Table_Num() {
		return group_Y_Table_Num;
	}
	public void setGroup_Y_Table_Num(Integer group_Y_Table_Num) {
		this.group_Y_Table_Num = group_Y_Table_Num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getRowIdl() {
		return rowIdl;
	}
	public void setRowIdl(List<String> rowIdl) {
		this.rowIdl = rowIdl;
	}
	
	
	
}
