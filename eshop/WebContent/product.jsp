<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<style>
	.nn-prod{
		text-align: center;
		width:33%;
		display: inline-block;
	}
	.nn-prod>div{
		box-shadow:0 0 5px gray;
		border-radius:10px;
		margin: 5px;
		position: relative;
	}
	.nn-prod>div>div img{
		height: 150px;
		max-width: 95%;
	}
	.nn-prod>div>img{
		position: absolute;
		top:0px;
		right: 0px;
	}
	</style>
</head>
<body>
	<h1>Product List</h1>
	<c:forEach var="p" items="${list}">
	<div class="nn-prod">
		<div>
			<div class="nn-name">${p.name}</div>
			<div>
				<img src="images/products/${p.image}">
			</div>
			<div class="nn-price">
				<fmt:formatNumber value="${p.unitPrice}" type="currency"/>
			</div>
			<c:choose>
				<c:when test="${p.category.id % 4 == 0}">
					<img src="images/new_icon.gif">	
				</c:when>
				<c:when test="${p.category.id % 4 == 1}">
					<img src="images/promo_icon.gif">	
				</c:when>
				<c:when test="${p.category.id % 4 == 2}">
					<img src="images/special_icon.gif">	
				</c:when>
			</c:choose>
		</div>
	</div>
	</c:forEach>
</body>
</html>