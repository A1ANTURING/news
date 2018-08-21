package com.ht.component;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.ht.pojo.NewsType;
import com.ht.pojo.TLink;
import com.ht.pojo.TNews;
import com.ht.service.LinkService;
import com.ht.service.NewsService;
import com.ht.service.NewsTypeService;

/**
 * 
 * <p>Title:InitServlet</p>
 * <p>Description:此组件主要是用来初始化应用的一些很少被更改的数据</p>
 * <p>Compary</p>
 * @author 胡腾
 */
@Component
public class InitServlet implements ServletContextAware {
	private LinkService linkService ;
	private NewsTypeService newsTypeService ;
	private NewsService newsService ;
	public NewsService getNewsService() {
		return newsService;
	}
	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	public NewsTypeService getNewsTypeService() {
		return newsTypeService;
	}
	@Resource
	public void setNewsTypeService(NewsTypeService newsTypeService) {
		this.newsTypeService = newsTypeService;
	}
	public LinkService getLinkService() {
		return linkService;
	}
	
	@Resource
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		
		try {
			List<TLink> linkList = linkService.findAllByOrderNumASC();
			List<NewsType> newsTypeList = newsTypeService.findAll();
			List<TNews> isImageList = newsService.findByIsImageAndLimit();
			TNews isHead = newsService.findByIsHead();
			List<TNews> newestList = newsService.findByNewest();
			List<TNews> isHotList = newsService.findByIsHot();
			
			servletContext.setAttribute("isHotList", isHotList) ;
			servletContext.setAttribute("newestList", newestList) ;
			servletContext.setAttribute("isHead", isHead) ;
			servletContext.setAttribute("linkList", linkList) ;
			servletContext.setAttribute("newsTypeList", newsTypeList) ;
			servletContext.setAttribute("isImageList", isImageList) ;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("#######################系统出错了################################");
		}
	}
	
}
