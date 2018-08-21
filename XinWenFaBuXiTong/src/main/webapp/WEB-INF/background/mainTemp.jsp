<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/style/news.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>


</head>
<body>
<div class="container">
<jsp:include page="common/head.jsp"/>

<div class="row-fluid">
	<div class="span3">
		<div class="newsMenu">
			<ul class="nav nav-tabs nav-stacked">
				  <li><a href="${pageContext.request.contextPath }/login.action"><strong>主页</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/news/list/1.action"><strong>新闻管理</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/news/addUI.action">&nbsp;&nbsp;新闻添加</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/news/list/1.action">&nbsp;&nbsp;新闻维护</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/comment/list/1.action"><strong>新闻评论管理</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/comment/list/1.action">&nbsp;&nbsp;新闻评论维护</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/newsType/list.action"><strong>新闻类别管理</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/newsType/addUI.action">&nbsp;&nbsp;新闻类别添加</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/newsType/list.action">&nbsp;&nbsp;新闻类别维护</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/link/list.action"><strong>友情连接管理</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/link/addUI.action">&nbsp;&nbsp;友情连接添加</a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/link/list.action">&nbsp;&nbsp;友情连接维护</a></li>
				  <li><a href="#"><strong>系统管理</strong></a></li>
				  <li><a href="${pageContext.request.contextPath }/admin/application/refresh.action">&nbsp;&nbsp;刷新服务器缓存</a></li>
			</ul>
		</div>
	</div>
	<div class="span9">
		<jsp:include page="${mainPage }"></jsp:include>
	</div>
</div>
<jsp:include page="common/foot.jsp"/>
</div>
</body>
</html>