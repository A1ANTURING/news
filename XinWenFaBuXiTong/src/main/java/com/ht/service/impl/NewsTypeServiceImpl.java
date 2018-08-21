package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.mapper.NewsMapperCustomer;
import com.ht.mapper.NewsTypeMapperCustomer;
import com.ht.mapper.TNewstypeMapper;
import com.ht.pojo.News;
import com.ht.pojo.NewsType;
import com.ht.pojo.TNewstype;
import com.ht.pojo.TNewstypeExample;
import com.ht.service.NewsTypeService;
import com.ht.utils.PropertiesUtil;
import com.ht.vo.NewsFindByTypeIdVo;

@Service("newsTypeService")
public class NewsTypeServiceImpl implements NewsTypeService {
	
	private TNewstypeMapper tNewstypeMapper ;
	
	private NewsTypeMapperCustomer newsTypeMapperCustomer ;
	
	private NewsMapperCustomer newsMapperCustomer ;
	
	public NewsMapperCustomer getNewsMapperCustomer() {
		return newsMapperCustomer;
	}
	@Resource
	public void setNewsMapperCustomer(NewsMapperCustomer newsMapperCustomer) {
		this.newsMapperCustomer = newsMapperCustomer;
	}
	public NewsTypeMapperCustomer getNewsTypeMapperCustomer() {
		return newsTypeMapperCustomer;
	}
	@Resource
	public void setNewsTypeMapperCustomer(
			NewsTypeMapperCustomer newsTypeMapperCustomer) {
		this.newsTypeMapperCustomer = newsTypeMapperCustomer;
	}

	public TNewstypeMapper gettNewstypeMapper() {
		return tNewstypeMapper;
	}
	
	@Resource
	public void settNewstypeMapper(TNewstypeMapper tNewstypeMapper) {
		this.tNewstypeMapper = tNewstypeMapper;
	}

	@Override
	public List<NewsType> findAll() throws Exception {
		List<NewsType> newsTypeList = newsTypeMapperCustomer.findAll();
		NewsFindByTypeIdVo vo = new NewsFindByTypeIdVo(1,Integer.parseInt(PropertiesUtil.getValue("other.news.count"))) ; 
		for(int i=0 ; i < newsTypeList.size() ; i++){
			vo.setTypeId(newsTypeList.get(i).getNewstypeid());
			List<News> news = newsMapperCustomer.findByTypeIdAndLimit(vo);
			if(news != null && news.size() > 0){
				newsTypeList.get(i).setNews(news);
			}
		}
		
		return newsTypeList ;
	}
	@Override
	public List<TNewstype> findAllNotNews() throws Exception {
		List<TNewstype> newsTypeList = tNewstypeMapper.selectByExample(new TNewstypeExample());
		return newsTypeList;
	}
	@Override
	public void doCreate(String newsTypeName) throws Exception {
		TNewstype newsType = new TNewstype();
		newsType.setTypename(newsTypeName);
		tNewstypeMapper.insertSelective(newsType) ;
	}
	@Override
	public void doUpdate(Integer newsTypeId, String newsTypeName)
			throws Exception {
		TNewstype newsType = new TNewstype();
		newsType.setNewstypeid(newsTypeId);
		newsType.setTypename(newsTypeName);
		tNewstypeMapper.updateByPrimaryKey(newsType) ;
		
	}
	@Override
	public boolean doDelete(Integer newsTypeId) throws Exception {
		boolean flag = false ;
		int count = newsMapperCustomer.findCountByTypeId(newsTypeId);
		if(count == 0){ //如果下面没有新闻就删除，如果有那么就不删除
			flag = true ;
			tNewstypeMapper.deleteByPrimaryKey(newsTypeId) ;
		}
		return flag ;
	}
	@Override
	public TNewstype findByNewsTypeId(Integer newsTypeId) throws Exception {
		TNewstype newsType = tNewstypeMapper.selectByPrimaryKey(newsTypeId);
		return newsType;
	}

}
