package com.ht.mapper;

import java.util.List;

import com.ht.pojo.TLink;

/**
 * 
 * <p>Title:LinkMapperCustomer</p>
 * <p>Description:</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface LinkMapperCustomer {
	
	/*
	 * <p>Description:查询所有的友情链接，排序为升序</p>
	 */
	public List<TLink> findAllByOrderNumASC() throws Exception ;
	
	/*
	 * <p>Description:根据友情链接的Id进行查找</p>
	 */
	public TLink findByLinkId(int linkId) throws Exception ;
	
	/*
	 * <p>Description:添加一个友情链接到数据库</p>
	 */
	public void doCreate(TLink link) throws Exception ;
	
	/*
	 * <p>Description:更新一个友情链接</p>
	 */
	public void doUpdate(TLink link) throws Exception ;
	
	/*
	 * <p>Description:根据友情链接的Id来删除一个友情链接，谨慎使用，使用的时候先取，使用的时候先取，使用的时候先取</p>
	 */
	public void doDelete(int linkId) throws Exception ;
}
