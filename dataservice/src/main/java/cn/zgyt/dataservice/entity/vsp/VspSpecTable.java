package cn.zgyt.dataservice.entity.vsp;

public class VspSpecTable {

	private Integer id;//凹进组数
	private Integer group_Indentation_StartX;//凹进组横坐标
	private Integer group_Indentation_StartY;//凹进组竖向坐标
	private Integer group_Indentation_Length;//组长
	
	
	public Integer getGroup_Indentation_StartX() {
		return group_Indentation_StartX;
	}
	public void setGroup_Indentation_StartX(Integer group_Indentation_StartX) {
		this.group_Indentation_StartX = group_Indentation_StartX;
	}
	public Integer getGroup_Indentation_StartY() {
		return group_Indentation_StartY;
	}
	public void setGroup_Indentation_StartY(Integer group_Indentation_StartY) {
		this.group_Indentation_StartY = group_Indentation_StartY;
	}
	public Integer getGroup_Indentation_Length() {
		return group_Indentation_Length;
	}
	public void setGroup_Indentation_Length(Integer group_Indentation_Length) {
		this.group_Indentation_Length = group_Indentation_Length;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
