package com.my.security.service;

import org.springframework.security.core.userdetails.User;

import com.my.user.model.UserModel;

public interface AssemblerService {

	User buildUserFromUserEntity(UserModel userAccount);

}
