package cn.zgyt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.user.UserLoginError;

/**
 *
 */
@RepositoryRestResource(path="userLoginError")
@Transactional(propagation=Propagation.REQUIRED)
public interface UserLoginErrorRepository extends JpaRepository<UserLoginError, Integer>{

}
