package com.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.TNewstype;
import com.ht.service.NewsTypeService;
import com.ht.utils.JsonFlag;

@Controller
@RequestMapping("/admin/newsType")
public class AdminNewsTypeController {
	private NewsTypeService newsTypeService ;

	public NewsTypeService getNewsTypeService() {
		return newsTypeService;
	}
	@Resource
	public void setNewsTypeService(NewsTypeService newsTypeService) {
		this.newsTypeService = newsTypeService;
	}
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public String list(Model model) throws Exception{
		List<TNewstype> newsTypeList = newsTypeService.findAllNotNews();
		model.addAttribute("newsTypeList", newsTypeList) ;
		model.addAttribute("mainPage", "newsType/newsTypeList.jsp") ;
		
		return "background/mainTemp" ;
	}
	
	@RequestMapping(value="/addUI",method={RequestMethod.GET})
	public String addUI(Model model) throws Exception {
		model.addAttribute("mainPage", "newsType/newsTypeAdd.jsp") ;
		return "background/mainTemp" ;
	}	
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public String add(String newsTypeName) throws Exception{
		newsTypeService.doCreate(newsTypeName);
		return "redirect:/admin/newsType/list.action" ;
	}
	
	@RequestMapping(value="/editUI/{newsTypeId}",method={RequestMethod.GET})
	public String editUI(Model model,@PathVariable Integer newsTypeId) throws Exception{
		TNewstype newsType = newsTypeService.findByNewsTypeId(newsTypeId);
		model.addAttribute("newsType", newsType) ;
		model.addAttribute("mainPage", "newsType/newsTypeEdit.jsp") ;
		return "background/mainTemp" ;
	}
	
	@RequestMapping(value="/edit",method={RequestMethod.POST})
	public String edit(String newsTypeName,Integer newsTypeId) throws Exception{
		newsTypeService.doUpdate(newsTypeId, newsTypeName);
		return "redirect:/admin/newsType/list.action" ;
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public @ResponseBody JsonFlag delete(Integer newsTypeId) throws Exception{
		JsonFlag jsonFlag = new JsonFlag();
		boolean flag = newsTypeService.doDelete(newsTypeId);
		jsonFlag.setFlag(flag);
		return jsonFlag ;
	}
}