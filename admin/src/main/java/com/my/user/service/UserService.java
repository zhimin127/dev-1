package com.my.user.service;

import java.util.List;

import com.my.common.model.SysUsers;
import com.my.menu.model.MenuModel;
import com.my.plugin.PageInfo;
import com.my.user.model.UserModel;

public interface UserService {

	void save(SysUsers user);

	void update(SysUsers user);

	SysUsers findByNameAndPassword(String username, String password);

	UserModel findByName(String userName);

	List<MenuModel> getMenuByUser(SysUsers user);

	PageInfo<SysUsers> getPage(int page, int rows);

}
