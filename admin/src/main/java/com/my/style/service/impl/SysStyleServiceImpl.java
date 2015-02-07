package com.my.style.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.common.dao.SysStylesMapper;
import com.my.common.model.SysStyles;
import com.my.style.service.SysStyleService;

@Service("sysStyleService")
public class SysStyleServiceImpl implements SysStyleService {

	@Autowired
	private SysStylesMapper sysStylesMapper;
	
	public void save(SysStyles style) {
		sysStylesMapper.insert(style);
	}

}
