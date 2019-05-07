package com.oracle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.bean.Admin;
import com.oracle.bean.Monster;
import com.oracle.mapper.AdminMapper;
import com.oracle.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private  AdminMapper adminMapper;
	
	
	@Override
	@Transactional
	public int register(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminMapper.insert(admin);
	}



	@Override
	public Admin login(String account) {
		// TODO Auto-generated method stub
		return this.adminMapper.selectByPrimaryKey(account);
	}








	

}
