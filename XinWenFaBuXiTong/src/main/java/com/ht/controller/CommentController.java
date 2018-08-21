package com.ht.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ht.pojo.TComment;
import com.ht.service.CommentService;

/**
 * 
 * <p>Title:CommentController</p>
 * <p>Description:评论的Controller</p>
 * <p>Compary</p>
 * @author 胡腾
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
	
	private CommentService commentService ;
	
	public CommentService getCommentService() {
		return commentService;
	}
	@Resource
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value="/create/{newsId}",method={RequestMethod.POST})
	public String create(@PathVariable int newsId,String content,HttpServletRequest request) throws Exception{
		TComment comment = new TComment() ;
		comment.setNewsid(newsId);
		comment.setContent(content);
		comment.setUserip(request.getRemoteAddr());
		commentService.doCreate(comment);
		return "redirect:/news/show/" + newsId ;
	}
	
}
