package com.ht.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Comment;
import com.ht.pojo.TComment;
import com.ht.service.CommentService;
import com.ht.utils.JsonFlag;
import com.ht.vo.NewsFindByTypeIdVo;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {
	
	private CommentService commentService ;

	public CommentService getCommentService() {
		return commentService;
	}	
	@Resource
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	@RequestMapping(value="/list/{pageNum}",method={RequestMethod.GET})
	public String list(Model model,@PathVariable String pageNum,String startDate,String endDate) throws Exception {
		try{
			if(pageNum == null || "".equals(pageNum)){
				pageNum = "1" ;
			}
		}catch(Exception e){
			model.addAttribute("error", "别捣乱！") ;
			return "foreground/error" ;
		}
		NewsFindByTypeIdVo<Comment> vo = commentService.findByPageAndDate(Integer.parseInt(pageNum), startDate, endDate);
		model.addAttribute("vo", vo) ;
		model.addAttribute("mainPage", "comment/commentList.jsp") ;
		return "background/mainTemp" ;
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	public @ResponseBody JsonFlag delete(Integer commentId) throws Exception{
		JsonFlag jsonFlag = new JsonFlag() ;
		try{
			commentService.doDelete(commentId);
			jsonFlag.setFlag(true);
		}catch(Exception e){
			jsonFlag.setFlag(false);
		}
		
		return jsonFlag ;
	}
	
	@RequestMapping(value="/deletePiliang",method={RequestMethod.POST})
	public @ResponseBody JsonFlag deletePiliang(String commentIds) throws Exception{
		JsonFlag jsonFlag = new JsonFlag() ;
		try{
			String[] ids = commentIds.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for (String id : ids) {
				list.add(Integer.parseInt(id)) ;
			}
			commentService.doDeletePiliang(list);
			jsonFlag.setFlag(true);
		}catch(Exception e){
			jsonFlag.setFlag(false);
		}
		
		return jsonFlag ;
	}
	
}	
