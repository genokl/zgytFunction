package cn.zgyt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.entiry.user.User;

/**
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String name);
}
