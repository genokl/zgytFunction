package cn.zgyt.entiry.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 用户登录基本信息记录
 * 	无论登录成功失败都记录该数据 
 * 	数据来源： 发送登录请求是携带
 */

@Entity
@Table(name = "am_user_login_info")
public class UserLoginInfo {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;				//主键
	private String loginName;		//登录名
	private String loginIp;			//登录IP
	private Date loginTime;			//登录时间
	private String loginSource;		//登录设备信息
	private String loginOs;			//登录系统
	private String loginOsVersion;	//登录系统版本
	private String loginBrowser;	//登录浏览器
	private String loginBrowserCore;//登录浏览器内核
	private String loginOther;		//登录其他信息
	private Integer loginStatus;	//0登录失败 1登录成功



	public UserLoginInfo() {
	}

	public UserLoginInfo(String loginName) {
		this.loginName = loginName;
	}

	public UserLoginInfo(String loginName, String loginIp, Date loginTime,
			String loginSource, String loginOs, String loginOsVersion,
			String loginBrowser, String loginBrowserCore, String loginOther,
			Integer loginStatus) {
		this.loginName = loginName;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.loginSource = loginSource;
		this.loginOs = loginOs;
		this.loginOsVersion = loginOsVersion;
		this.loginBrowser = loginBrowser;
		this.loginBrowserCore = loginBrowserCore;
		this.loginOther = loginOther;
		this.loginStatus = loginStatus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "login_source", length = 50)
	public String getLoginSource() {
		return this.loginSource;
	}

	public void setLoginSource(String loginSource) {
		this.loginSource = loginSource;
	}

	@Column(name = "login_os", length = 20)
	public String getLoginOs() {
		return this.loginOs;
	}

	public void setLoginOs(String loginOs) {
		this.loginOs = loginOs;
	}

	public String getLoginOsVersion() {
		return this.loginOsVersion;
	}

	public void setLoginOsVersion(String loginOsVersion) {
		this.loginOsVersion = loginOsVersion;
	}

	public String getLoginBrowser() {
		return this.loginBrowser;
	}

	public void setLoginBrowser(String loginBrowser) {
		this.loginBrowser = loginBrowser;
	}

	public String getLoginBrowserCore() {
		return this.loginBrowserCore;
	}

	public void setLoginBrowserCore(String loginBrowserCore) {
		this.loginBrowserCore = loginBrowserCore;
	}

	public String getLoginOther() {
		return this.loginOther;
	}

	public void setLoginOther(String loginOther) {
		this.loginOther = loginOther;
	}

	public Integer getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

}