<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Java Standard Tag Library</h1>
	<h2>if</h2>
	<c:if test="${year % 4 == 0 && year % 100 != 0}">
		<h3>Nam nhuan</h3>
	</c:if>
	
	<h2>choose</h2>
	<c:choose>
		<c:when test="${hours < 12}">
			<h3>Good morning</h3>
		</c:when>
		<c:when test="${hours > 17}">
			<h3>Good evening</h3>
		</c:when>
		<c:otherwise>
			<h3>Hello</h3>
		</c:otherwise>
	</c:choose>
	
	<h2>forEach</h2>
	<ul>
	<c:forEach var="s" items="${list}" 
		begin="1" end="4" varStatus="st">
		<li>${st.index}. ${s}</li>
	</c:forEach>
	</ul>
	
	<h2>SET & REMOVE</h2>
	<c:set var="name" value="Nguyen Van Teo" scope="page"/>
	<c:remove var="name" scope="page"/>
	${name}
	
	<h2>Number Format</h2>
	<ul>
		<li>${num1}</li>
		<li>${num2}</li>
		<li><fmt:formatNumber value="${num1}" type="currency"/></li>
		<li><fmt:formatNumber value="${num1}" pattern="#,###.###"/></li>
		<li><fmt:formatNumber value="${num2}" type="percent"/></li>
	</ul>
	
	<h2>Date Format</h2>
	<ul>
		<li>${now}</li>
		<li><fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/></li>
		<li><fmt:formatDate value="${now}" pattern="HH:mm:ss aa"/></li>
	</ul>
</body>
</html>