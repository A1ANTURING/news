package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.mapper.LinkMapperCustomer;
import com.ht.mapper.TLinkMapper;
import com.ht.pojo.TLink;
import com.ht.service.LinkService;

@Service("linkService")
public class LinkServiceImpl implements LinkService {
	
	private LinkMapperCustomer linkMapperCustomer ;
	
	private TLinkMapper tLinkMapper ;
	
	public LinkMapperCustomer getLinkMapperCustomer() {
		return linkMapperCustomer;
	}
	
	@Resource
	public void setLinkMapperCustomer(LinkMapperCustomer linkMapperCustomer) {
		this.linkMapperCustomer = linkMapperCustomer;
	}

	public TLinkMapper gettLinkMapper() {
		return tLinkMapper;
	}
	
	@Resource
	public void settLinkMapper(TLinkMapper tLinkMapper) {
		this.tLinkMapper = tLinkMapper;
	}

	@Override
	public List<TLink> findAllByOrderNumASC() throws Exception {
		
		return linkMapperCustomer.findAllByOrderNumASC() ; 
	}

	@Override
	public void doCreate(String linkName, String linkUrl, String email,
			Integer orderNum) throws Exception {
		TLink link = new TLink() ;
		link.setLinkname(linkName);
		link.setLinkurl(linkUrl);
		link.setEmail(email);
		link.setOrdernum(orderNum);
		linkMapperCustomer.doCreate(link);
	}

	@Override
	public void doUpdate(int linkId, String linkName, String linkUrl,
			String email, String orderNum) throws Exception {
		if(orderNum == null){
			orderNum = "999" ;
		}
		TLink link = new TLink() ;
		link.setLinkid(linkId);
		link.setEmail(email);
		link.setLinkname(linkName);
		link.setLinkurl(linkUrl);
		link.setOrdernum(Integer.parseInt(orderNum));
		linkMapperCustomer.doUpdate(link);
	}

	@Override
	public void doDelete(int linkId) throws Exception {
		linkMapperCustomer.doDelete(linkId);
	}

	@Override
	public TLink findByLinkId(int linkId) throws Exception {
		TLink link = linkMapperCustomer.findByLinkId(linkId);
		
		return link;
	}
	

}
