package com.ht.pojo;

/**
 * 
 * <p>Title:Comment</p>
 * <p>Description:评论扩展类</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public class Comment extends TComment{
	private TNews news ;

	public TNews getNews() {
		return news;
	}

	public void setNews(TNews news) {
		this.news = news;
	}
}
