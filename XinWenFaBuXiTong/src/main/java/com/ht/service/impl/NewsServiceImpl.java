package com.ht.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.mapper.NewsMapperCustomer;
import com.ht.mapper.TNewsMapper;
import com.ht.pojo.News;
import com.ht.pojo.TNews;
import com.ht.service.NewsService;
import com.ht.utils.DateUtil;
import com.ht.utils.PropertiesUtil;
import com.ht.vo.NewsFindByTypeIdVo;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	private NewsMapperCustomer newsMapperCustomer ;
	
	private TNewsMapper tNewsMapper ;
	
	public TNewsMapper gettNewsMapper() {
		return tNewsMapper;
	}
	@Resource
	public void settNewsMapper(TNewsMapper tNewsMapper) {
		this.tNewsMapper = tNewsMapper;
	}
	public NewsMapperCustomer getNewsMapperCustomer() {
		return newsMapperCustomer;
	}
	@Resource
	public void setNewsMapperCustomer(NewsMapperCustomer newsMapperCustomer) {
		this.newsMapperCustomer = newsMapperCustomer;
	}

	@Override
	public List<TNews> findByIsImageAndLimit() throws Exception {
		int count = Integer.parseInt(PropertiesUtil.getValue("index.isImage.count")) ;
		List<TNews> isImageList = newsMapperCustomer.findByIsImageAndLimit(count);
		return isImageList;
	}
	
	@Override
	public TNews findByIsHead() throws Exception {
		TNews isHead = newsMapperCustomer.findByIsHead();
		return isHead;
	}
	@Override
	public List<TNews> findByNewest() throws Exception {
		List<TNews> newestList = newsMapperCustomer.findByReleaseDateDesc(Integer.parseInt(PropertiesUtil.getValue("new.news.count")));
		
		return newestList;
	}
	@Override
	public List<TNews> findByIsHot() throws Exception {
		List<TNews> isHotList = newsMapperCustomer.findByIsHot(Integer.parseInt(PropertiesUtil.getValue("hot.news.count")));
		return isHotList;
	}
	@Override
	public NewsFindByTypeIdVo<News> findByTypeIdAndPage(int page,Integer typeId) throws Exception {
		if(page == 0){
			page = 1 ;
		}
		NewsFindByTypeIdVo<News> vo = new NewsFindByTypeIdVo<News>(page,Integer.parseInt(PropertiesUtil.getValue("news.page.count")));
		vo.setTypeId(typeId);
		int totalRecord = newsMapperCustomer.findCountByTypeId(typeId);
		vo.setTotalRecord(totalRecord);
		List<News> news = newsMapperCustomer.findByTypeIdAndLimit(vo);
		vo.setData(news);
		
		return vo;
	}
	@Override
	public News findByNewsId(Integer newsId) throws Exception {
		News news = newsMapperCustomer.findByNewsId(newsId);
		return news;
	}
	@Override
	public void doUpdateClick(Integer newsId) throws Exception {
		TNews news = tNewsMapper.selectByPrimaryKey(newsId);
		if(news != null){
			news.setClick(news.getClick() + 1);
			news.setNewsid(newsId);
			newsMapperCustomer.doUpdate(news);
		}
	}
	
	@Override
	public NewsFindByTypeIdVo<News> findByIfTilteAndreleaseDateAndLimit(String title,String startDate,String endDate,int pageNum) throws Exception {
		NewsFindByTypeIdVo<News> vo = new NewsFindByTypeIdVo<News>(pageNum,Integer.parseInt(PropertiesUtil.getValue("news.page.count")));
		vo.setNewsTitle(title);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		int totalRecord = newsMapperCustomer.findCountByIfTilteAndreleaseDate(vo);
		vo.setTotalRecord(totalRecord);
		List<News> data = newsMapperCustomer.findByIfTilteAndreleaseDateAndLimit(vo);
		vo.setData(data);
		return vo ;
	}
	@Override
	public void doCreate(String fileName, String title, String author,
			Integer typeId, Integer isHead, Integer isImage, Integer isHot,
			String content) throws Exception {
		TNews news = new TNews() ;
		news.setImagename(fileName);
		news.setTitle(title);
		news.setAuthor(author);
		news.setTypeid(typeId);
		if(isHead == null){
			isHead = 0;
		}
		news.setIshead(isHead);
		if(isImage == null){
			isImage = 0;
		}
		news.setIsimage(isImage);
		if(isHot == null){
			isHot = 0;
		}
		news.setIshot(isHot);
		news.setContent(content);
		news.setReleasedate(new Date());
		news.setClick(1);
		tNewsMapper.insertSelective(news) ;
	}
	@Override
	public void doUpdate(Integer newsId, String fileName, String title,
			String author, Integer typeId, Integer isHead, Integer isImage,
			Integer isHot, String content) throws Exception {
		News news = newsMapperCustomer.findByNewsId(newsId);
		if(fileName != null && !"".equals(fileName)){
			news.setImagename(fileName);
		}
		news.setTitle(title);
		news.setAuthor(author);
		news.setTypeid(typeId);
		news.setIshead(isHead);
		news.setIsimage(isImage);
		news.setIshot(isHot);
		news.setContent(content);
		tNewsMapper.updateByPrimaryKey(news) ;
	}
	@Override
	public void doDelete(Integer newsId) throws Exception {
		tNewsMapper.deleteByPrimaryKey(newsId) ;
	}
}
