//package cn.zgyt.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// * 权限角色�? * @author wxy
// * @createTime 2016-07-05 19:39:37
// */
//@Entity
//@Table(name = "am_role")
//public class Role{
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id; 			//角色主键ID 
//	private String name; 			//角色名称 
//	private String description; 	// 角色说明 
//	private String resourceIds; 	// 资源ID 集合
//	private Integer isDel;		// 是否是禁用的   1 禁用   0 启用
//	
//	public Role() {
//	}
//
//	
//	public Role(String name, String description, String resourceIds) {
//		this.name = name;
//		this.description = description;
//		this.resourceIds = resourceIds;
//	}
//
//	public Integer getId() {
//		return this.id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return this.description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getResourceIds() {
//		return this.resourceIds;
//	}
//
//	public void setResourceIds(String resourceIds) {
//		this.resourceIds = resourceIds;
//	}
//	public Integer getIsDel() {
//		return isDel;
//	}
//	public void setIsDel(Integer isDel) {
//		this.isDel = isDel;
//	}
//
//
//}