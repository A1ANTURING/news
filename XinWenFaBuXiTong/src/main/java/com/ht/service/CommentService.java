package com.ht.service;

import java.util.List;

import com.ht.pojo.Comment;
import com.ht.pojo.TComment;
import com.ht.vo.NewsFindByTypeIdVo;


/**
 * 
 * <p>Title:CommentService</p>
 * <p>Description:评论的Service</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface CommentService {
	
	/* 
	 * <p>Description:根据新闻的Id，取得评论</p>
	 */
	public List<TComment> findByNewsId(int newsId) throws Exception ;
	
	/*
	 * <p>Description:添加操作</p>
	 */
	public void doCreate(TComment comment) throws Exception ;
	
	/* 
	 * <p>Description:分页取得评论，如果有日期的条件则加上日期条件</p>
	 */
	public NewsFindByTypeIdVo<Comment> findByPageAndDate(int pageNum,String startDate,String endDate) throws Exception ;

	/* 
	 * <p>Description:根据评论的id进行删除</p>
	 */
	public void doDelete(Integer commentId) throws Exception ;
	
	/*
	 * <p>Description:根据评论的id进行批量删除</p>9
	 */
	public void doDeletePiliang(List<Integer> commentIds) throws Exception ;
}
