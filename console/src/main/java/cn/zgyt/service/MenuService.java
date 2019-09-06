package cn.zgyt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zgyt.repository.MenuRepository;
/**
 * 文章管理类Service
 * @author wxy
 *
 */
@Service("menuService")
@Transactional
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	


}
