package com.ht.mapper;

import java.util.List;

import com.ht.pojo.NewsType;
import com.ht.pojo.TNewstype;

/**
 * 
 * <p>Title:NewsTypeMapperCustomer</p>
 * <p>Description:新闻类型的Mapper扩展</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface NewsTypeMapperCustomer {
	/*
	 * <p>Description:查询全部的新闻类型和新闻类型下的新闻，谨慎使用</p>
	 */
	public List<NewsType> findAllAndNews() ;
	
	/*
	 * <p>Description:查询所有的新闻类别，级联为空</p>
	 */
	public List<NewsType> findAll() ;
	
}
