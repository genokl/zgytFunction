package cn.zgyt.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import cn.zgyt.entiry.user.User;


/**
 * @author wxy
 */
public class UserResource extends Resource<User> {

	public UserResource(User content, Iterable<Link> links) {
		super(content, links);
	}

}
