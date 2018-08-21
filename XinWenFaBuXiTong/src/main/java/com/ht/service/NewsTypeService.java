package com.ht.service;

import java.util.List;

import com.ht.pojo.NewsType;
import com.ht.pojo.TNewstype;

/**
 * 
 * <p>Title:NewsTypeService</p>
 * <p>Description:新闻类别的service</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface NewsTypeService {
	
	/*
	 * <p>Description:根据新闻类型的id进行查找</p>
	 */
	public TNewstype findByNewsTypeId(Integer newsTypeId) throws Exception ;
	
	/*
	 * <p>Description:查询所有的新闻类别，并级联新闻</p>
	 */
	public List<NewsType> findAll() throws Exception ;
	
	/*
	 * <p>Description:取得所有的新闻类别，没有级联新闻</p>
	 */
	public List<TNewstype> findAllNotNews() throws Exception ;
	
	/*
	 * <p>Description:添加一个新闻类别</p>
	 */
	public void doCreate(String newsTypeName) throws Exception ;
	
	/*
	 * <p>Description:更新操作</p>
	 */
	public void doUpdate(Integer newsTypeId,String newsTypeName) throws Exception ;
	
	/*
	 * <p>Description:删除操作</p>
	 */
	public boolean doDelete(Integer newsTypeId) throws Exception ;
}
