package com.ht.service;

import java.util.List;

import com.ht.pojo.News;
import com.ht.pojo.TNews;
import com.ht.vo.NewsFindByTypeIdVo;

/**
 * 
 * <p>Title:NewsService</p>
 * <p>Description:新闻的Service</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface NewsService {
	
	/*
	 * <p>Description:取得新闻isImage为1的</p>
	 */
	public List<TNews> findByIsImageAndLimit() throws Exception ;
	
	/*
	 * <p>Description:取得最新头条新闻</p>
	 */
	public TNews findByIsHead() throws Exception ;
	
	/*
	 * <p>Description:取得最新的新闻的展示</p>
	 */
	public List<TNews> findByNewest() throws Exception ;
	
	/*
	 * <p>Description:取得热点新闻的展示</p>
	 */
	public List<TNews> findByIsHot() throws Exception ;
	
	/* 
	 * <p>Description:根据新闻类别取得新闻，并分页，page当前页码，封装到NewsFindByTypeIdVo里面</p>
	 */
	public NewsFindByTypeIdVo<News> findByTypeIdAndPage(int page,Integer typeId) throws Exception ;

	/*
	 * <p>Description:根据newsId来取得news对象，级联TNewsType</p>
	 */
	public News findByNewsId(Integer newsId) throws Exception ;
	
	/*
	 * <p>Description:更新操作点击次数，操作之前请先查询，操作之前请先查询，操作之前请先查询</p>
	 */
	public void doUpdateClick(Integer newsId) throws Exception ;
	
	/*
	 * <p>Description:根据条件来查询出vo对象title标题，startDate开始时间,endDate结束时间，pageNum当前页码</p>
	 */
	public NewsFindByTypeIdVo<News> findByIfTilteAndreleaseDateAndLimit(String title,String startDate,String endDate,int pageNum) throws Exception ;
	
	/*
	 * <p>Description:添加操作</p>
	 */
	public void doCreate(String fileName,String title,String author,Integer typeId,
			Integer isHead,Integer isImage,Integer isHot,
			String content) throws Exception ;
	
	/*
	 * <p>Description:更新操作</p>
	 */
	public void doUpdate(Integer newsId,String fileName,String title,String author,Integer typeId,
			Integer isHead,Integer isImage,Integer isHot,
			String content) throws Exception ;
	
	/*
	 * <p>Description:删除操作</p>
	 */
	public void doDelete(Integer newsId) throws Exception ;
}
