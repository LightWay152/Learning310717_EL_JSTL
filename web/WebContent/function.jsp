<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Java Standard Tag Library - Functions</h1>
	${msg}
	<p>${fn:length(msg)} ky tu</p>
	<p>${fn:substring(msg, 0, 100)}...</p>
	<p>${fn:substringBefore(msg, '16-9')}...</p>
	<p>${fn:length(fn:split(msg, ' '))} tu</p>
	${fn:escapeXml(msg)}
</body>
</html>