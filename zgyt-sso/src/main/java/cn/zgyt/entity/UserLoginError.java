//package cn.zgyt.entity;
//
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
///**
// * 用户登录错误记录表 
// * 主要用于禁用用户20分钟内的重复登录
// */
//@Entity
//@Table(name = "am_user_login_error")
//public class UserLoginError{
//	@Id 
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Integer id; //主键
//	private String loginName; //登录名称 /用户名
//	private Integer loginErrorNum;// 错误次数
//	private Date lastErrorTime;// 上次的错误时间
//
//	public UserLoginError() {
//	}
//
//	public UserLoginError(String loginName, Integer loginErrorNum,
//			Date lastErrorTime) {
//		this.loginName = loginName;
//		this.loginErrorNum = loginErrorNum;
//		this.lastErrorTime = lastErrorTime;
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
//	public String getLoginName() {
//		return this.loginName;
//	}
//
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//
//	public Integer getLoginErrorNum() {
//		return this.loginErrorNum;
//	}
//
//	public void setLoginErrorNum(Integer loginErrorNum) {
//		this.loginErrorNum = loginErrorNum;
//	}
//
//	public Date getLastErrorTime() {
//		return this.lastErrorTime;
//	}
//
//	public void setLastErrorTime(Date lastErrorTime) {
//		this.lastErrorTime = lastErrorTime;
//	}
//
//}