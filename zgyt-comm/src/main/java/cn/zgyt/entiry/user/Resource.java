package cn.zgyt.entiry.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限资源类
 * @author wxy
 * @createTime 2016-07-05 19:38:38
 */

@Entity
@Table(name = "am_resource")
public class Resource {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 	//主键ID 
	private String type; 	//权限类型 
	private String value; 	//权限值（权限说明）
	private Integer isDel;		// 是否是禁用的  1 禁用   0 启用


	public Resource() {
	}

	public Resource(String type, String value) {
		this.type = type;
		this.value = value;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "value")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}