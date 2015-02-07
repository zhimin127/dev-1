package com.my.security.service;

import org.springframework.security.core.userdetails.User;

import com.my.user.model.SysUser;

public interface AssemblerService {

	User buildUserFromUserEntity(SysUser userAccount);

}
