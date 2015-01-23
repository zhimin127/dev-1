package com.my.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.my.security.service.AssemblerService;
import com.my.user.model.UserModel;
import com.my.user.service.UserService;

//@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserService userService;
	@Autowired
	private UserCache userCache;
	@Autowired
	private AssemblerService assemblerService;
	@Autowired
	private MessageSource messageSource;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("============================== 1.用户 " + username + " ============================== ");
		User user = (User) this.userCache.getUserFromCache(username);
		if (user == null) {
			UserModel userAccount = userService.findByName(username);
			if (userAccount == null) {
				throw new UsernameNotFoundException("user not found");
			}
			user = assemblerService.buildUserFromUserEntity(userAccount);
			userCache.putUserInCache(user);
		}
		return user;
	}

}
