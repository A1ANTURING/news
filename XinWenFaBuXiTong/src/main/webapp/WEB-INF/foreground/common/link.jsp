<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
	<div class="span12">
		<div class="link">
			<div class="linkHeader">友情链接</div>
			<div class="datas">
				<ul>
					<c:forEach var="link" items="${linkList }">
						<li><a href="${link.linkurl }" target="_blank">${link.linkname }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>