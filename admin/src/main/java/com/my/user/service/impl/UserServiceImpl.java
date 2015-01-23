package com.my.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysUsersMapper;
import com.my.common.model.SysUsers;
import com.my.common.model.SysUsersExample;
import com.my.menu.model.MenuModel;
import com.my.plugin.PageHelper;
import com.my.plugin.PageInfo;
import com.my.user.dao.UserDao;
import com.my.user.model.UserModel;
import com.my.user.service.UserService;
import com.my.utils.MD5;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SysUsersMapper userMapper;

	public SysUsers findByNameAndPassword(String username, String password) {
		if (username == null || password == null) {
			return null;
		}
		SysUsersExample example = new SysUsersExample();
		example .createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(MD5.encode(password));
		List<SysUsers> users = userMapper.selectByExample(example);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public UserModel findByName(String username) {
		if (username == null) {
			return null;
		}
		return userDao.findByUserName(username);
	}

	public void save(SysUsers record) {
		record.setPassword(MD5.encode(record.getPassword()));
		userMapper.insert(record);
	}

	public List<MenuModel> getMenuByUser(SysUsers user) {
		return null;
	}

	public PageInfo<SysUsers> getPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		SysUsersExample example = new SysUsersExample();
		List<SysUsers> users = userMapper.selectByExample(example);
		PageInfo<SysUsers> pageUser = new PageInfo<SysUsers>(users);
		return pageUser;
	}

	public void update(SysUsers record) {
		record.setPassword(MD5.encode(record.getPassword()));
		userMapper.updateByPrimaryKeySelective(record);
	}

}
