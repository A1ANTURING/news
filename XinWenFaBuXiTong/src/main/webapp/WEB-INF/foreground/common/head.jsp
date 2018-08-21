<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="span12">
		<img src="${pageContext.request.contextPath}/images/logo.png" width="200px" height="30px">
	</div>
</div>
<div class="row-fluid">
	<div class="span12">
		<div class="navbar">
		  <div class="navbar-inner">
		    <a class="brand" href="${pageContext.request.contextPath }/index.action">首页</a>
		    <ul class="nav">
		    	<c:forEach var="newsType" items="${newsTypeList }">
		    		<li><a href="${pageContext.request.contextPath }/news/list/${newsType.newstypeid }/1">${newsType.typename }</a></li>
		    	</c:forEach>
		    </ul>
		  </div>
		</div>
	</div>
</div>