<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<script type="text/javascript">
function newsDelete(newsId){
	if(confirm("确认要删除这条新闻吗？")){
		$.post("${pageContext.request.contextPath}/admin/news/delete.action",{newsId:newsId},
			function(result){
				if(result.flag){
					alert("删除成功!");
					window.location.href="${pageContext.request.contextPath}/admin/news/list/1.action";
				}else{
					alert("删除失败");
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
		新闻管理&nbsp;&nbsp;>&nbsp;&nbsp;
		新闻维护&nbsp;&nbsp;
	</div>
	<div class="search_content" style="vertical-align: middle;">
		<form action="${pageContext.request.contextPath}/admin/news/list/1.action" method="post">
			新闻标题：<input type="text" id="s_title" name="title" style="width:180px" value="${vo.newsTitle }"/>&nbsp;&nbsp;
			发布日期：<input type="text" id="s_bPublishDate" name="startDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${vo.startDate }"/>
			&nbsp;到&nbsp;<input type="text" id="s_aPublishDate" name="endDate" class="Wdate" onclick="WdatePicker()" style="width: 100px;" value="${vo.endDate }"/>
			&nbsp;&nbsp;<button class="btn btn-mini btn-primary" type="submit" style="margin-top: -8px;">查询</button>
		</form>
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th>序号</th>
				<th>新闻标题</th>
				<th>新闻类别</th>
				<th>发布时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${vo.data }" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${fn:substring(news.title,0,5) }...</td>
					<td>${news.tNewstype.typename }</td>
					<td><fmt:formatDate value="${news.releasedate }" type="date" pattern="yyyy-MM-dd"/></td>
					<td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}/admin/news/editUI/${news.newsid }.action'">修改</button>&nbsp;
					<button class="btn btn-mini btn-danger" type="button" onclick="newsDelete(${news.newsid})">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="pagination pagination-centered">
  		<ul>
  			<li><a href="${pageContext.request.contextPath }/admin/news/list/1.action?title=${vo.newsTitle }&startDate=${vo.startDate}&endDate=${vo.endDate}">首页</a></li>
			<c:if test="${vo.pageNumber == 1 }">
				<li class="disabled"><span>&laquo;</span></li>
			</c:if>
			<c:if test="${vo.pageNumber != 1 }">
				<li><a href="${pageContext.request.contextPath }/admin/news/list/${vo.pageNumber - 1}.action?title=${vo.newsTitle }&startDate=${vo.startDate}&endDate=${vo.endDate}">&laquo;</a></li>
			</c:if>
			
			<c:forEach varStatus="statu" begin="1" end="${vo.totalPage }" step="1">
				<c:if test="${vo.pageNumber == statu.count }">
					<li class="active"><span>${statu.count }</span></li>
				</c:if>
				<c:if test="${vo.pageNumber != statu.count}">
					<li><a href="${pageContext.request.contextPath }/admin/news/list/${statu.count}.action?title=${vo.newsTitle }&startDate=${vo.startDate}&endDate=${vo.endDate}">${statu.count }</a></li>
				</c:if>
			</c:forEach>
			
			<c:if test="${vo.pageNumber == vo.totalPage}">
				<li class="disabled"><span>&raquo;</span></li>
			</c:if>
			<c:if test="${vo.pageNumber != vo.totalPage}">
				<li><a href="${pageContext.request.contextPath }/admin/news/list/${vo.pageNumber + 1}.action?title=${vo.newsTitle }&startDate=${vo.startDate}&endDate=${vo.endDate}">&raquo;</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath }/admin/news/list/${vo.totalPage}.action?title=${vo.newsTitle }&startDate=${vo.startDate}&endDate=${vo.endDate}">尾页</a></li>
  		</ul>
  	</div>
</div>
</body>
</html>