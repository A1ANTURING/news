<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="dataHeader navi">
		当前位置：&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/index.action">主页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
		${newsVo.data[0].tNewstype.typename }
	</div>
	<div class="datas news_type_list">
		<ul>
			<c:forEach var="news" items="${newsVo.data }">
				<li><span>[<fmt:formatDate value="${news.releasedate }" type="date" pattern="yyyy-MM-dd"/>]</span>&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/news/show/${news.newsid }" title="${news.title }">${fn:substring(news.title,0,42)}</a></li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<ul class='pager'>
			<c:if test="${newsVo.pageNumber == 1 }">
				<li class='disabled'><a href='javascript:void()'>上一页</a></li>
			</c:if>
			<c:if test="${newsVo.pageNumber != 1 }">
				<li><a href="${pageContext.request.contextPath }/news/list/${newsVo.typeId}/${newsVo.pageNumber - 1}">上一页</a></li>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${newsVo.pageNumber == newsVo.totalPage || newsVo.totalPage == 0}">
				<li class='disabled'><a href='javascript:void()'>下一页</a></li>
			</c:if>
			<c:if test="${newsVo.pageNumber != newsVo.totalPage && newsVo.totalPage != 0}">
				<li><a href='${pageContext.request.contextPath }/news/list/${newsVo.typeId}/${newsVo.pageNumber + 1}'>下一页</a></li>
			</c:if>
		</ul>
	</div>
</div>