package com.ht.pojo;

/**
 * 
 * <p>Title:News</p>
 * <p>Description:新闻的扩展类</p>
 * <p>Compary</p>
 * @author 胡腾
 */
public class News extends TNews{
	private TNewstype tNewstype ;

	public TNewstype gettNewstype() {
		return tNewstype;
	}

	public void settNewstype(TNewstype tNewstype) {
		this.tNewstype = tNewstype;
	}
	
}
