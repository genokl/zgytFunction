package cn.zgyt.entiry;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Product", description = "产品")
@Entity
@Table(name = "am_product")
public class Product  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2991827173568180335L;

	@ApiModelProperty(value = "ID")
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@ApiModelProperty(value = "产品名称")
    private String title;		   //文章题目

	
    
	@ApiModelProperty(value = "种类")
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.REFRESH})
    private ProductType productType;          //1，公司概况  2,联系我们 3，公司要闻，
	
	private ProductType productType_;       
	
	@ApiModelProperty(value = "概述")
    private String productSynopsis;       //概述
	@ApiModelProperty(value = "预览图")
    private String productSynopsisImg;   //预览图 路径 一张图片
	@ApiModelProperty(value = "是否删除")
    private Integer isDel;  			   //文章删除状态   0未删除  1已删除
	@ApiModelProperty(value = "是否上架")
    private Integer isSale;			       //文章展示状态   0草稿状态 1发表状态
	@ApiModelProperty(value = "产品详情")
	@Column(name = "product_detail",columnDefinition = "mediumtext")
    private String productDetail;    	   //文章正文
	
    private String productHtmlAddress;    //文章静态页面路径
    @ApiModelProperty(value = "创建时间")
    private Date createDate;    		   //文章创建时间\
    
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date showDate;    		   //文章创建时间
    private Long orderCode;    		   //文章创建时间
    private String keyWords;    		   //关键词
    
    @ApiModelProperty(value = "价格")
    private Integer price;    		       //单价
    @ApiModelProperty(value = "价格单位")
    private String unit;    		       //单位
    
    @Transient
    private String aroundUrl;    		   //详情页显示，上一条下一条
    
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProductSynopsis() {
		return productSynopsis;
	}
	public void setProductSynopsis(String productSynopsis) {
		this.productSynopsis = productSynopsis;
	}
	public String getProductSynopsisImg() {
		return productSynopsisImg;
	}
	public void setProductSynopsisImg(String productSynopsisImg) {
		this.productSynopsisImg = productSynopsisImg;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public Integer getIsSale() {
		return isSale;
	}
	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public String getProductHtmlAddress() {
		return productHtmlAddress;
	}
	public void setProductHtmlAddress(String productHtmlAddress) {
		this.productHtmlAddress = productHtmlAddress;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public String getAroundUrl() {
		return aroundUrl;
	}
	public void setAroundUrl(String aroundUrl) {
		this.aroundUrl = aroundUrl;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Long getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(Long orderCode) {
		this.orderCode = orderCode;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ProductType getProductType_() {
		return productType_;
	}
	public void setProductType_(ProductType productType_) {
		this.productType_ = productType_;
	}
    
    
}