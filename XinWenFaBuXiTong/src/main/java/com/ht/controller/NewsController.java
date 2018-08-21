package com.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ht.pojo.News;
import com.ht.pojo.TComment;
import com.ht.service.CommentService;
import com.ht.service.NewsService;
import com.ht.vo.NewsFindByTypeIdVo;

/**
 * 
 * <p>Title:NewsController</p>
 * <p>Description:新闻的Controller</p>
 * <p>Compary</p>
 * @author 胡腾
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	
	private NewsService newsService ;
	
	private CommentService commentService ;
	
	public CommentService getCommentService() {
		return commentService;
	}
	@Resource
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public NewsService getNewsService() {
		return newsService;
	}
	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping(value="/list/{typeId}/{pageNum}",method={RequestMethod.GET})
	public String list(Model model,@PathVariable int typeId,@PathVariable int pageNum) throws Exception {
		NewsFindByTypeIdVo<News> newsVo = newsService.findByTypeIdAndPage(pageNum, typeId);
		model.addAttribute("newsVo", newsVo) ;
		model.addAttribute("mainPage", "newsList.jsp") ;
		return "foreground/news/newsTemp" ;
	}
	
	@RequestMapping(value="/show/{newsId}",method={RequestMethod.GET})
	public String show(Model model,@PathVariable int newsId) throws Exception {
		newsService.doUpdateClick(newsId);
		News news = newsService.findByNewsId(newsId);
		News previous = newsService.findByNewsId(newsId - 1);
		News next = newsService.findByNewsId(newsId + 1);
		List<TComment> commentList = commentService.findByNewsId(newsId);
		
		model.addAttribute("commentList", commentList) ;
		model.addAttribute("previous", previous) ;
		model.addAttribute("next", next) ;
		model.addAttribute("news", news) ;
		model.addAttribute("mainPage", "newsShow.jsp") ;
		return "foreground/news/newsTemp" ;
	}
}
