package com.ht.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.pojo.News;
import com.ht.service.NewsService;
import com.ht.utils.JsonFlag;
import com.ht.vo.NewsFindByTypeIdVo;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
	private NewsService newsService ;
	
	public NewsService getNewsService() {
		return newsService;
	}
	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping("/list/{pageNum}")
	public String list(HttpServletRequest request,Model model,@PathVariable Integer pageNum,String title,String startDate,String endDate) throws Exception{

		NewsFindByTypeIdVo<News> vo = newsService.findByIfTilteAndreleaseDateAndLimit(title, startDate, endDate, pageNum);
		model.addAttribute("vo", vo) ;
		model.addAttribute("mainPage", "news/newsList.jsp") ;
		return "background/mainTemp" ;
	}

	@RequestMapping("/addUI")
	public String addUI(Model model) throws Exception{
		model.addAttribute("mainPage", "news/newsAdd.jsp") ;
		return "background/mainTemp" ;
	}

	@RequestMapping(value="/add",method={RequestMethod.POST})
	public String add(HttpServletRequest request,Model model,@RequestParam(value = "file", required = false) MultipartFile file
			,String title,String author,Integer typeId,
			Integer isHead,Integer isImage,Integer isHot,
			String content) throws Exception{
		String fileName = file.getOriginalFilename(); ;
		if(fileName != null && !"".equals(fileName)){
			String path = request.getSession().getServletContext().getRealPath("userImage");  
//	      String fileName = new Date().getTime()+".jpg"; 
			int lastDian = fileName.lastIndexOf(".");
			String subfix = fileName.substring(lastDian);
			fileName = new Date().getTime() + subfix;
			File targetFile = new File(path, fileName); 
			if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
			//保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		}
        newsService.doCreate(fileName, title, author, typeId, isHead, isImage, isHot, content);
		return "redirect:/admin/news/list/1.action" ;
	}
	
	@RequestMapping("/editUI/{newsId}")
	public String editUI(Model model,@PathVariable Integer newsId) throws Exception{
		News news = newsService.findByNewsId(newsId);
		model.addAttribute("news", news) ;
		model.addAttribute("mainPage", "news/newsEdit.jsp") ;
		return "background/mainTemp" ;
	}
	
	@RequestMapping(value="/edit/{newsId}",method={RequestMethod.POST})
	public String edit(HttpServletRequest request,@PathVariable Integer newsId,@RequestParam(value = "file", required = false) MultipartFile file
			,String title,String author,Integer typeId,
			Integer isHead,Integer isImage,Integer isHot,
			String content) throws Exception{
		String fileName = file.getOriginalFilename(); ;
		if(fileName != null && !"".equals(fileName)){
			String path = request.getSession().getServletContext().getRealPath("userImage");  
//	      String fileName = new Date().getTime()+".jpg"; 
			int lastDian = fileName.lastIndexOf(".");
			String subfix = fileName.substring(lastDian);
			fileName = new Date().getTime() + subfix;
			File targetFile = new File(path, fileName); 
			if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
			//保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		}
		newsService.doUpdate(newsId, fileName, title, author, typeId, isHead, isImage, isHot, content);
		return "redirect:/admin/news/list/1.action" ;
	}
	
	@RequestMapping("/delete")
	public @ResponseBody JsonFlag delete(Integer newsId) throws Exception{
		JsonFlag jsonFlag = new JsonFlag() ;
		try {
			newsService.doDelete(newsId);
			jsonFlag.setFlag(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonFlag.setFlag(false);
		}
		
		return jsonFlag ;
	}
}
