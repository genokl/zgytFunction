//package cn.zgyt.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
///**
// *  CRM 系统操作用户类
// */
//@Entity
//@Table(name = "am_user")
//public class User extends OAuth2Authentication{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 2410278351477456452L;
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id; 			 //主键id
//	private String userName; 			 //登录名
//	private String passWord;		 //密码
//	private Integer isDel; 		 //是否禁用 0禁用  1 启用
//	private Integer sex; 			 //性别
//	@Column(name = "last_login_time", length = 19)
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastLoginTime;		 //最后登录时间
//	private String lastLoginIp;		 //最后登录IP
//	private Date createTime;		 //创建时间
//	private String roleIds;			 //角色ID 集合
//	private String phone;			 //手机号码
//	
//	
//	public User(OAuth2Request storedRequest, Authentication userAuthentication) {
//		super(storedRequest, userAuthentication);
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
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassWord() {
//		return passWord;
//	}
//
//	public void setPassWord(String passWord) {
//		this.passWord = passWord;
//	}
//
//
//	public Integer getIsDel() {
//		return isDel;
//	}
//
//
//
//	public void setIsDel(Integer isDel) {
//		this.isDel = isDel;
//	}
//
//
//
//	public Integer getSex() {
//		return this.sex;
//	}
//
//	public void setSex(Integer sex) {
//		this.sex = sex;
//	}
//
//	public Date getLastLoginTime() {
//		return this.lastLoginTime;
//	}
//
//	public void setLastLoginTime(Date lastLoginTime) {
//		this.lastLoginTime = lastLoginTime;
//	}
//
//	public String getLastLoginIp() {
//		return this.lastLoginIp;
//	}
//
//	public void setLastLoginIp(String lastLoginIp) {
//		this.lastLoginIp = lastLoginIp;
//	}
//	public Date getCreateTime() {
//		return this.createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public String getRoleIds() {
//		return this.roleIds;
//	}
//
//	public void setRoleIds(String roleIds) {
//		this.roleIds = roleIds;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	
//	
//
//}