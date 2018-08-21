<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function linkDelete(linkId){
		if(confirm("确认要删除这条友情链接吗？")){
			$.post("${pageContext.request.contextPath}/admin/link/delete.action",{linkId:linkId},
				function(result){
					if(result.flag){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/admin/link/list.action";
					}else{
						alert("删除失败");
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
		友情链接管理&nbsp;&nbsp;>&nbsp;&nbsp;
		友情链接维护&nbsp;&nbsp;
	</div>
	<div class="data_content">
		<table class="table table-hover table-bordered">
			<tr>
				<th>序号</th>
				<th>链接名称</th>
				<th>链接地址</th>
				<th>联系人邮件</th>
				<th>排列顺序</th>
				<th>操作</th>
			</tr>
			<c:forEach var="link" items="${linkList }" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${link.linkname }</td>
					<td>${link.linkurl }</td>
					<td>${link.email }</td>
					<td>${link.ordernum }</td>
					<td><button class="btn btn-mini btn-info" type="button" onclick="javascript:window.location='${pageContext.request.contextPath}/admin/link/editUI/${link.linkid} '">修改</button>&nbsp;&nbsp;
					<button class="btn btn-mini btn-danger" type="button" onclick="linkDelete(${link.linkid})">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>