package cn.zgyt.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.zgyt.entiry.user.User;

public class MyUserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3852089927581899385L;
	private User user;
 
	
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MyUserPrincipal(User user) {
        this.user = user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassWord();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		if(user.getIsDel()==0) {//未删除
			return true;
		}else {//已删除
			return false;
		}
	}

	@Override
	public boolean isAccountNonLocked() {
		if(user.getIsDel()==0) {//未删除
			return true;
		}else {//已删除
			return false;
		}
	}

	@Override
	public boolean isCredentialsNonExpired() {
		if(user.getIsDel()==0) {//未删除
			return true;
		}else {//已删除
			return false;
		}
	}

	@Override
	public boolean isEnabled() {
		if(user.getIsDel()==0) {//未删除
			return true;
		}else {//已删除
			return false;
		}
	}
}
