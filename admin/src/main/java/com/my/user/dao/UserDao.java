package com.my.user.dao;

import java.util.Map;

import com.my.common.base.BaseDao;
import com.my.user.model.UserModel;

public interface UserDao extends BaseDao<UserModel>{

	public UserModel findByUserName(String username);

	public void addUserRole(Map<String, String> record);

}
