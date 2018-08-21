<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#checkedAll").click(function(){
			if($(this).prop("checked")==true){
				$("input[name='commentIds']").prop("checked",true);
			}else{
				$("input[name='commentIds']").prop("checked",false);
			}
		});
		
	});
	
	function commentsDelete(){
		var chk_value=[];
		$('input[name="commentIds"]:checked').each(function(){
			chk_value.push($(this).val());
		});
		if(chk_value.length==0){
			alert("请选择要删除的数据");
			return;
		}
		var commentIds=chk_value.join(",");
		if(confirm("确认要删除这些评论吗？")){
			$.post("${pageContext.request.contextPath}/admin/comment/deletePiliang.action",{commentIds:commentIds},
				function(result){
					if(result.flag){
						alert("成功删除"+chk_value.length+"条数据");
						window.location.href="${pageContext.request.contextPath}/admin/comment/list/1.action";
					}else{
						alert("批量删除失败");
					}
				}
			);
		}
	}

	function commentDelete(commentId){
		if(confirm("确认要删除这条评论吗？")){
			$.post("${pageContext.request.contextPath}/admin/comment/delete.action",{commentId:commentId},
				function(result){
					if(result.flag){
						alert("删除成功！");
						window.location.href="${pageContext.request.contextPath}/admin/comment/list/1.action";
					}else{
						alert("删除失败！");
					}
				}
			);
		}
	}
</script>
<body>
<div class="data_list backMain">
	<div class="dataHeader navi">
		当前位置：&nbsp;&nbsp;
		主页&nbsp;&nbsp;>&nbsp;&nbsp;
		新闻评论管理&nbsp;&nbsp;>&nbsp;&nbsp;
		新闻评论维护&nbsp;&nbsp;
	</div>
	<div class="search_content" style="vertical-align: middle;padding-right: 20px;">
		<div style="float: left;padding-top: 10px;">
			<button class="btn btn-mini btn-danger" type="button" onclick="commentsDelete()">批量删除</button>
		</div>
		<div style="float: right;">
			<form action="${pageContext.request.contextPath}/admin/comment/list/1.action" method="GET">
				评论日期：<input type="text" id="s_bCommentDate" name="startDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${vo.startDate }"/>
				&nbsp;到&nbsp;<input type="text" id="s_aCommentDate" name="endDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${vo.endDate }"/>
				&nbsp;&nbsp;<button class="btn btn-mini btn-primary" type="submit" style="margin-top: -8px;">查询</button>
			</form>
		</div>
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th><input type="checkbox" id="checkedAll"/></th>
				<th>序号</th>
				<th>评论内容</th>
				<th>评论主题</th>
				<th>评论时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="comment" items="${vo.data }" varStatus="status">
				<tr>
					<td><input type="checkbox" name="commentIds" value="${comment.commentid}"/></td>
					<td>${status.index+1 }</td>
					<td><a title="${comment.content }">${fn:substring(comment.content,0,15) }...</a></td>
					<td><a title="${comment.news.title }" target="_blank" href="${pageContext.request.contextPath }/news/show/${comment.newsid}.action">${fn:substring(comment.news.title,0,15) }...</a></td>
					<td><fmt:formatDate value="${comment.commenttime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td><button class="btn btn-mini btn-danger" type="button" onclick="commentDelete('${comment.commentid}')">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="pagination pagination-centered">
  		<ul>
  			<li><a href="${pageContext.request.contextPath }/admin/comment/list/1.action?startDate=${vo.startDate}&endDate=${vo.endDate}">首页</a></li>
			<c:if test="${vo.pageNumber == 1 }">
				<li class="disabled"><span>&laquo;</span></li>
			</c:if>
			<c:if test="${vo.pageNumber != 1 }">
				<li><a href="${pageContext.request.contextPath }/admin/comment/list/${vo.pageNumber - 1}.action?startDate=${vo.startDate}&endDate=${vo.endDate}">&laquo;</a></li>
			</c:if>
			
			<c:forEach varStatus="statu" begin="1" end="${vo.totalPage }" step="1">
				<c:if test="${vo.pageNumber == statu.count }">
					<li class="active"><span>${statu.count }</span></li>
				</c:if>
				<c:if test="${vo.pageNumber != statu.count}">
					<li><a href="${pageContext.request.contextPath }/admin/comment/list/${statu.count}.action?startDate=${vo.startDate}&endDate=${vo.endDate}">${statu.count }</a></li>
				</c:if>
			</c:forEach>
			
			<c:if test="${vo.pageNumber == vo.totalPage}">
				<li class="disabled"><span>&raquo;</span></li>
			</c:if>
			<c:if test="${vo.pageNumber != vo.totalPage}">
				<li><a href="${pageContext.request.contextPath }/admin/comment/list/${vo.pageNumber + 1}.action?startDate=${vo.startDate}&endDate=${vo.endDate}">&raquo;</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/admin/comment/list/${vo.totalPage}.action?startDate=${vo.startDate}&endDate=${vo.endDate}">尾页</a></li>
  		</ul>
  	</div>
</div>
</body>
</html>