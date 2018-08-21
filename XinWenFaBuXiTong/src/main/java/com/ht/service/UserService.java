package com.ht.service;

import com.ht.pojo.TUser;

/**
 * 
 * <p>Title:UserService</p>
 * <p>Description:后台管理员用户的Service</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface UserService {
	
	/*
	 * <p>Description:登录操作</p>
	 */
	public TUser login(String username,String password) throws Exception ;
}
