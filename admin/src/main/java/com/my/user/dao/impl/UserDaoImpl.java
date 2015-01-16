package com.my.user.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.my.common.base.impl.BaseDaoImpl;
import com.my.user.dao.UserDao;
import com.my.user.model.UserModel;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserModel> implements UserDao {

	public UserModel findByUserName(String username) {
		return getSqlSession().selectOne("UserModel.findByUsername", username);
	}

	public void addUserRole(Map<String, String> record) {
		getSqlSession().insert("UserRole.addUserRole", record);
	}

}
