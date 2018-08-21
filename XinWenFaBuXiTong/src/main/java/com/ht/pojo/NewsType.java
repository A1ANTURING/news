package com.ht.pojo;

import java.util.List;

/**
 * 
 * <p>Title:NewsType</p>
 * <p>Description:新闻类型的扩展类</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public class NewsType extends TNewstype{
	
	private List<News> news ;

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}
}
