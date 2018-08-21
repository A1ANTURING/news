package com.ht.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.TLink;
import com.ht.service.LinkService;
import com.ht.utils.JsonFlag;

@Controller
@RequestMapping("/admin/link")
public class AdminLinkController {
	private LinkService linkService;

	public LinkService getLinkService() {
		return linkService;
	}

	@Resource
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public String list(Model model) throws Exception{
		List<TLink> linkList = linkService.findAllByOrderNumASC();
		model.addAttribute("mainPage", "link/linkList.jsp") ;
		model.addAttribute("linkList", linkList) ;
		return "background/mainTemp" ;
	}
	
	@RequestMapping(value="/addUI",method={RequestMethod.GET})
	public String addUI(Model model) throws Exception {
		model.addAttribute("mainPage", "link/linkAdd.jsp");
		return "background/mainTemp";
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public String add(String linkName,String linkUrl,String linkEmail,Integer orderNum) throws Exception{
		linkService.doCreate(linkName, linkUrl, linkEmail, orderNum);
		return "redirect:/admin/link/list.action" ;
	}
	
	@RequestMapping(value="/editUI/{linkId}",method={RequestMethod.GET})
	public String editUI(Model model,@PathVariable Integer linkId) throws Exception{
		TLink link = linkService.findByLinkId(linkId);
		model.addAttribute("link", link) ;
		model.addAttribute("mainPage", "link/linkEdit.jsp") ;
		
		return "background/mainTemp" ; 
	}
	
	@RequestMapping(value="/edit",method={RequestMethod.POST})
	public String edit(Integer linkId,String linkName,String linkUrl,String linkEmail,Integer orderNum) throws Exception{
		linkService.doUpdate(linkId,linkName,linkUrl,linkEmail,orderNum.toString());
		return "redirect:/admin/link/list.action" ;
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public @ResponseBody JsonFlag delete(Integer linkId) throws Exception{
		boolean flag = false ;
		try{
			linkService.doDelete(linkId);
			flag = true ;
		}catch(Exception e){
			flag = false ;
		}
		JsonFlag jsonFlag = new JsonFlag();
		jsonFlag.setFlag(flag);
		return jsonFlag ;
	}
}
