<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="dataHeader navi">
		当前位置：&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/index.action">主页</a>&nbsp;&nbsp;>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/news/list/${news.tNewstype.newstypeid}/1">${news.tNewstype.typename }</a>&nbsp;&nbsp;>&nbsp;&nbsp;
		${news.title }
	</div>
	<div>
		<div class="news_title"><h3>${news.title }</h3></div>
		<div class="news_info">
			发布时间：[<fmt:formatDate value="${news.releasedate }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>]&nbsp;&nbsp;作者：${news.author }
			&nbsp;&nbsp;新闻类别：[${news.tNewstype.typename }]&nbsp;&nbsp;阅读次数：${news.click }
		</div>
		<div class="news_content">
			${news.content }
		</div>
	</div>
	<div class="upDownPage">
		<c:if test="${previous == null }">
			<p>上一篇：没有了</p>
		</c:if>
		<c:if test="${previous != null }">
			<p>上一篇：<a href="${pageContext.request.contextPath }/news/show/${previous.newsid}">${previous.title }</a></p>
		</c:if>
		
		<c:if test="${next == null }">
			<p>下一篇：没有了</p>
		</c:if>
		<c:if test="${next != null }">
			<p>下一篇：<a href="${pageContext.request.contextPath }/news/show/${next.newsid}">${next.title }</a></p>
		</c:if>
	</div>
</div>

<div class="data_list comment_list"> 
	<div class="dataHeader">用户评论</div>
	<div class="commentDatas">
		<c:forEach var="comment" items="${commentList }">
			<div class="comment">
				<font>${comment.userip }：</font>${comment.content }&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commenttime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;]
			</div>
		</c:forEach>
	</div>
</div>

<div class="publish_list">
	<form action="${pageContext.request.contextPath }/comment/create/${news.newsid }" method="post">
		<div>
			<textarea style="width: 98%" rows="3" id="content" name="content"></textarea>
		</div>
		<div class="publishButton">
			<button class="btn btn-primary" type="submit">发表评论</button>
		</div>
	</form>
</div>