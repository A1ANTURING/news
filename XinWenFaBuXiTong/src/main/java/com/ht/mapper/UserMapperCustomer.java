package com.ht.mapper;

import com.ht.pojo.TUser;

/**
 * 
 * <p>Title:UserMapperCustomer</p>
 * <p>Description:后台管理员用户的Mapper</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface UserMapperCustomer {
	
	/*
	 * <p>Description:根据用户查询用户</p>
	 */
	public TUser findByUser(TUser user) throws Exception ;
}
