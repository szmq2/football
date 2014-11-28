<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>球队创建</title>
<link href="${contextPath}/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${contextPath}/styles/jquerymobile/jquery.mobile-1.4.5.min.css">

<!-- form验证 -->
<link rel="stylesheet" href="${contextPath}/styles/validationEngine/css/validationEngine.jquery.css" type="text/css"/>
<script src="${contextPath}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${contextPath}/styles/validationEngine/js/languages/jquery.validationEngine-zh_CN.js" type="text/javascript" charset="utf-8"></script>
<script src="${contextPath}/styles/validationEngine/js/jquery.validationEngine-2.6.4.js" type="text/javascript" charset="utf-8"></script>

<script src="${contextPath}/styles/jquerymobile/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
	<c:forEach var="item" items="${stadiums}">
		<div>
		<a href="${item.descUrl}">
		<button>${item.name}</button><br/>
		</a>
		${item.descs}<br/>
		地址：${item.address}
		</div>
	</c:forEach>
</body>
</html>