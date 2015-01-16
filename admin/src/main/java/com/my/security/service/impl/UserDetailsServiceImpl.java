package com.my.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.my.security.service.AssemblerService;
import com.my.user.model.UserModel;
import com.my.user.service.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService; 
	@Autowired
    private AssemblerService assemblerService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//UserAccount userAccount = userDao.findByUsername(username);
		UserModel userAccount = userService.findByName(username);
		if (userAccount == null) {
			throw new UsernameNotFoundException("user not found");
		}

		return assemblerService.buildUserFromUserEntity(userAccount);
	}

}
