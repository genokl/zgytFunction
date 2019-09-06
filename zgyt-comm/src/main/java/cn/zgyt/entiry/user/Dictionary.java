package cn.zgyt.entiry.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * crm 数据字典
 * 
 * @author wxy
 * 
 */
@Entity
@Table(name = "am_dictionary")
public class Dictionary {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String key;
	private String value;

	public Dictionary() {
	}

	public Dictionary(String key, String value) {
		this.key = key;
		this.value = value;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	
}