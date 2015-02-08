package com.my.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysUsersMapper;
import com.my.common.model.SysUsers;
import com.my.common.model.SysUsersExample;
import com.my.plugin.PageHelper;
import com.my.plugin.PageInfo;
import com.my.user.dao.SysUserDao;
import com.my.user.model.SysUser;
import com.my.user.service.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUsersMapper sysUsersMapper;

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	public SysUsers getByUsernameAndPassword(String username, String password) {
		if (username == null || password == null) {
			return null;
		}
		Md5PasswordEncoder md5Encoder = new Md5PasswordEncoder();
		md5Encoder.setEncodeHashAsBase64(true);
		SysUsersExample example = new SysUsersExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(md5PasswordEncoder.encodePassword(password, username));
		List<SysUsers> users = sysUsersMapper.selectByExample(example);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public SysUser getByUsername(String username) {
		if (username == null) {
			return null;
		}
		return sysUserDao.findByUserName(username);
	}

	public void save(SysUsers record) {
		record.setPassword(md5PasswordEncoder.encodePassword(record.getPassword(), record.getUsername()));
		sysUsersMapper.insert(record);
	}

	public PageInfo<SysUsers> getPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		SysUsersExample example = new SysUsersExample();
		List<SysUsers> users = sysUsersMapper.selectByExample(example);
		PageInfo<SysUsers> pageUser = new PageInfo<SysUsers>(users);
		return pageUser;
	}

	public void update(SysUsers user) {
		if (user == null || user.getUserId() == null || user.getUsername() == null) {
			return;
		}
		logger.info("================ " + user.getPassword());
		// user.setPassword(MD5.encode(user.getPassword()));
		user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), user.getUsername()));
		sysUsersMapper.updateByPrimaryKeySelective(user);
		SysUsersExample example = new SysUsersExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		sysUsersMapper.updateByExampleSelective(user, example);
	}

	public void saveOrUpdate(SysUsers user) {
		
	}

	public void saveUserRole(String userId, String roleId) {
		Map<String, String> record = new HashMap<String, String>();
		record.put("id", UUID.randomUUID().toString());
		record.put("roleId", roleId);
		record.put("userId", userId);
		sysUserDao.addUserRole(record);
	}

}
