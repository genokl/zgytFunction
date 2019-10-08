package cn.zgyt.resource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import cn.zgyt.entiry.user.MyException;

/**
 * 
 * @author wxy
 * @date 2019年1月21日
 * 
 */
public class MyExceptionResource extends Resource<MyException> {

	public MyExceptionResource(MyException content, Iterable<Link> links) {
		super(content, links);
	}

}
