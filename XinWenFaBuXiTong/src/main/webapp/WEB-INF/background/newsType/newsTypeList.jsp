<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function newsTypeDelete(newsTypeId){
		if(confirm("确认要删除这条新闻类别吗？")){
			$.post("${pageContext.request.contextPath}/admin/newsType/delete.action",{newsTypeId:newsTypeId},
				function(result){
					if(result.flag){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/admin/newsType/list.action";
					}else{
						alert("该类别下有新闻，不能删除");
					}
				}
			);
		}
	}
</script>
</head>
<body>
<div class="data_list backMain">
	<div class="dataHeader navi">
		当前位置：&nbsp;&nbsp;
		主页&nbsp;&nbsp;>&nbsp;&nbsp;
		新闻类别管理&nbsp;&nbsp;>&nbsp;&nbsp;
		新闻类别维护&nbsp;&nbsp;
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th>序号</th>
				<th>新闻类别名称</th>
				<th>操作</th>
			</tr>
			<c:forEach var="newsType" items="${newsTypeList }" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${newsType.typename }</td>
					<td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/admin/newsType/editUI/${newsType.newstypeid }'">修改</button>&nbsp;&nbsp;
					<button class="btn btn-mini btn-danger" type="button" onclick="newsTypeDelete(${newsType.newstypeid})">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>