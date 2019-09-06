package cn.zgyt.app.cacheBeans;

import cn.zgyt.entiry.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value="userCacheInfo对象",description="用户登录提交对象")
public class UserCacheInfo {
	
	@ApiModelProperty(value = "用户对象")
	private User  u ;						//用户对象
	@ApiModelProperty(value = "最后请求交互时间")
	private Long lastRequestTime;			//最后请求交互时间
	@ApiModelProperty(value = "登录时间")
	private Long loginTime;					//登录时间
	@ApiModelProperty(value = "登录IP")
	private String loginIP;					//登录IP 
	@ApiModelProperty(value = "登录Key")
	private String loginKey;				//登录Key
	@ApiModelProperty(value = "申请查看的客户资料ID 集合")
	private String scanClientIds;			//申请查看的客户资料ID 集合  
	@ApiModelProperty(value = "最后一次登录时间")
	private String lastLoginTime;			//最后一次登录时间
	@ApiModelProperty(value = "最后一个登录IP")
	private String lastLoginIp;				//最后一个登录IP
	
	
	
	/**
	 * 创建一个在现对象
	 * @param user					//登录对象
	 * @param lastRequestTime		//最后请求交互时间
	 * @param loginTime				//登录时间
	 * @param loginIP				//登录IP
	 * @param loginKey				//登录KEY
	 */
	public UserCacheInfo(User u,String loginIP,String loginKey){
		this.loginTime=System.currentTimeMillis();
		this.lastRequestTime=System.currentTimeMillis();
		this.u=u;
		this.loginIP=loginIP;
		this.loginKey=loginKey;
	}
	
	public UserCacheInfo(){}
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public Long getLastRequestTime() {
		return lastRequestTime;
	}
	public void setLastRequestTime(Long lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public String getLoginKey() {
		return loginKey;
	}
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}
	public String getScanClientIds() {
		return scanClientIds;
	}
	public void setScanClientIds(String scanClientIds) {
		this.scanClientIds = scanClientIds;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
}
