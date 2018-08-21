package com.ht.mapper;

import java.util.List;

import com.ht.pojo.News;
import com.ht.pojo.TNews;
import com.ht.vo.NewsFindByTypeIdVo;

/**
 * 
 * <p>Title:NewsMapperCustomer</p>
 * <p>Description:新闻的mapper扩展类</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface NewsMapperCustomer {
	
	/*
	 * <p>Description:根据isImage为1的新闻分页查询，count查询个数</p>
	 */
	public List<TNews> findByIsImageAndLimit(int count) throws Exception ;
	
	/* 
	 * <p>Description:查询最新头条新闻</p>
	 */
	public TNews findByIsHead() throws Exception ;
	
	/*
	 * <p>Description:根据新闻类型查询所有的新闻扩展</p>
	 */
	public List<News> findByTypeId(int typeId) throws Exception ;
	
	/*
	 * <p>Description:根据typeId分页查询新闻</p>
	 */
	public List<News> findByTypeIdAndLimit(NewsFindByTypeIdVo<News> vo) throws Exception ;
	
	/*
	 * <p>Description:根据typeId查询新闻的count</p>
	 */
	public int findCountByTypeId(int typeId) throws Exception ;
	
	/*
	 * <p>Description:查询最新新闻，count查询个数</p>
	 */
	public List<TNews> findByReleaseDateDesc(int count) throws Exception ;
	
	/*
	 * <p>Description:查询热点新闻，count查询个数</p>
	 */
	public List<TNews> findByIsHot(int count) throws Exception ;
	
	/*
	 * <p>Description:根据newsId查询新闻，带级联</p>
	 */
	public News findByNewsId(int newsId) throws Exception ; 
	
	/*
	 * <p>Description:更新操作，记住，先取后更新</p>
	 */
	public void doUpdate(TNews news) throws Exception ;
	
	/*
	 * <p>Description:查询新闻，如果有title条件或者发布日期条件则加上条件查询，并分页，包含newsType级联</p>
	 */
	public List<News> findByIfTilteAndreleaseDateAndLimit(NewsFindByTypeIdVo<News> vo) throws Exception ;

	/*
	 * <p>Description:查询总记录数，如果有添加加条件，如果没有不加</p>
	 */
	public int findCountByIfTilteAndreleaseDate(NewsFindByTypeIdVo<News> vo) throws Exception ;
	
}
