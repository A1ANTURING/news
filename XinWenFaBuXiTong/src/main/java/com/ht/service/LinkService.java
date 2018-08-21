package com.ht.service;

import java.util.List;

import com.ht.pojo.TLink;

/**
 * 
 * <p>Title:LinkService</p>
 * <p>Description:友情链接的Service</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface LinkService {
	
	/*
	 * <p>Description:根据orderNum升序查询出所有的友情链接</p>
	 */
	public List<TLink> findAllByOrderNumASC() throws Exception ;
	
	/* 
	 * <p>Description:根据友情链接的Id，取得友情链接对象</p>
	 */
	public TLink findByLinkId(int linkId) throws Exception ;
	
	/*
	 * <p>Description:添加一个友情链接</p>
	 */
	public void doCreate(String linkName,String linkUrl,String email,Integer orderNum) throws Exception ;
	
	/*
	 * <p>Description:更新操作</p>
	 */
	public void doUpdate(int linkId,String linkName,String linkUrl,String email,String orderNum) throws Exception ;

	/* 
	 * <p>Description:删除操作</p>
	 */
	public void doDelete(int linkId) throws Exception ;
}
