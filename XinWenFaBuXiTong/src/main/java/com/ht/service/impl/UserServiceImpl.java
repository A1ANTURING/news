package com.ht.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.mapper.UserMapperCustomer;
import com.ht.pojo.TUser;
import com.ht.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapperCustomer userMapperCustomer ;
	
	public UserMapperCustomer getUserMapperCustomer() {
		return userMapperCustomer;
	}
	@Resource
	public void setUserMapperCustomer(UserMapperCustomer userMapperCustomer) {
		this.userMapperCustomer = userMapperCustomer;
	}

	@Override
	public TUser login(String username, String password) throws Exception {
		TUser user = new TUser() ;
		user.setUsername(username);
		user.setPassword(password);
		TUser entityUser = userMapperCustomer.findByUser(user);
		return entityUser;
	}

}
