 package cn.zgyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import cn.zgyt.entiry.user.User;
import cn.zgyt.entity.MyUserPrincipal;
import cn.zgyt.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired 
	UserRepository userRepository;
	@Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        }else if (user.getIsDel()==1) {
			throw new DisabledException("该用户已删除");
		}
        return new MyUserPrincipal(user);
    }
 
}
