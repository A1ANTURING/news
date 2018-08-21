package com.ht.mapper;

import java.util.List;

import com.ht.pojo.Comment;
import com.ht.pojo.TComment;
import com.ht.vo.NewsFindByTypeIdVo;

/**
 * 
 * <p>Title:CommentMapperCustomer</p>
 * <p>Description:评论的Mapper</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public interface CommentMapperCustomer {
	
	/*
	 * <p>Description:根据新闻的ID查询评论</p>
	 */
	public List<TComment> findByNewsId(int newsId) throws Exception ;
	
	/*
	 * <p>Description:添加操作</p>8
	 */
	public void doCreate(TComment comment) throws Exception ;
	
	/*
	 * <p>Description:分页查询，如果有日期则根据日期查询</p>
	 */
	public List<TComment> findByPageAndDate(NewsFindByTypeIdVo<TComment> vo) throws Exception ;

	/*
	 * <p>Description:查询所有评论的个数</p>
	 */
	public int findCount() throws Exception ;
	
	/*
	 * <p>Description:分页查询，如果有时间条件则加上时间条件，如果没有就不加，返回级联的评论对象，级联新闻</p>
	 */
	public List<Comment> findCommentByPageAndDate(NewsFindByTypeIdVo<Comment> vo) throws Exception ;
	
	/*
	 * <p>Description:单删除，根据评论的id来删除</p>
	 */
	public void doDelete(int commentId) throws Exception ;
	
	/*
	 * <p>Description:多删除，根据评论的id来删除</p>
	 */
	public void doDeleteByPiliang(List<Integer> commentIds) throws Exception ;
}
