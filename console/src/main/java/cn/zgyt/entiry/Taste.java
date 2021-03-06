//package cn.zgyt.entiry;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Cascade;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//@ApiModel(value = "Taste", description = "口味")
//@Entity
//@Table(name = "am_taste")
//public class Taste {
//
//	@ApiModelProperty(value = "ID")
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;
//	
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//    @Cascade({org.hibernate.annotations.CascadeType.ALL})
//    @JoinTable(
//    joinColumns = {@JoinColumn(name = "taste_id")},
//    inverseJoinColumns = {@JoinColumn(name = "product_id")})
//	private List<Product> products;
//	 
//	 
//	@ApiModelProperty(value = "味道名称")
//    private String tasteKey;		   //味道名称
//	
//    private String tasteVal;		   //味道名称
//    
//    
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public String getTasteKey() {
//		return tasteKey;
//	}
//	public void setTasteKey(String tasteKey) {
//		this.tasteKey = tasteKey;
//	}
//	public String getTasteVal() {
//		return tasteVal;
//	}
//	public void setTasteVal(String tasteVal) {
//		this.tasteVal = tasteVal;
//	}
//	public List<Product> getProducts() {
//		return products;
//	}
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
//    
//    
//}
