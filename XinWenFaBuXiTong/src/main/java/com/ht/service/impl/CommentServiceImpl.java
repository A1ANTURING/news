package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.mapper.CommentMapperCustomer;
import com.ht.pojo.Comment;
import com.ht.pojo.TComment;
import com.ht.service.CommentService;
import com.ht.utils.PropertiesUtil;
import com.ht.vo.NewsFindByTypeIdVo;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	private CommentMapperCustomer commentMapperCustomer ;
	
	public CommentMapperCustomer getCommentMapperCustomer() {
		return commentMapperCustomer;
	}
	
	@Resource
	public void setCommentMapperCustomer(CommentMapperCustomer commentMapperCustomer) {
		this.commentMapperCustomer = commentMapperCustomer;
	}

	@Override
	public List<TComment> findByNewsId(int newsId) throws Exception {
		List<TComment> commentList = commentMapperCustomer.findByNewsId(newsId);
		return commentList;
	}

	@Override
	public void doCreate(TComment comment) throws Exception {
		commentMapperCustomer.doCreate(comment);
	}

	@Override
	public NewsFindByTypeIdVo<Comment> findByPageAndDate(int pageNum,String startDate,String endDate) throws Exception {
		int pageSize = Integer.parseInt(PropertiesUtil.getValue("comment.page.count")) ;
		NewsFindByTypeIdVo<Comment> vo = new NewsFindByTypeIdVo<Comment>(pageNum,pageSize);
		int totalRecord = commentMapperCustomer.findCount();
		vo.setTotalRecord(totalRecord);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		List<Comment> commentList = commentMapperCustomer.findCommentByPageAndDate(vo);
		vo.setData(commentList);
		return vo;
	}

	@Override
	public void doDelete(Integer commentId) throws Exception {
		commentMapperCustomer.doDelete(commentId);
	}

	@Override
	public void doDeletePiliang(List<Integer> commentIds) throws Exception {
		commentMapperCustomer.doDeleteByPiliang(commentIds);
	}

}
