package com.oracle.service;

import com.oracle.bean.Admin;


public interface AdminService {

	int register(Admin admin);

	Admin login(String account);



}
