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
	<form action="${contextPath}/web/team/create" method="post">
	<div class="ui-field-contain">
		<label for="select-native-1">Basic:</label>
		<select name="select-native-1" id="select-native-1">
		    <option value="1">The 1st Option</option>
		    <option value="2">The 2nd Option</option>
		    <option value="3">The 3rd Option</option>
		    <option value="4">The 4th Option</option>
		</select>
	</div>
	<table>
		<tr>
			<td>队伍名称</td>
			<td><input type="text" name="name" /></td>
			<td></td>
		</tr>
		<tr>
			<td>实力自评</td>
			<td><select name="level">
				<option value="">请选择</option>
				<option value="1">湘超</option>
				<option value="2">湘甲</option>
				<option value="3">湘乙</option>
			</select></td>
			<td></td>
		</tr>
		<tr>
			<td>球队人数</td>
			<td><input type="text" name="number" /></td>
			<td></td>
		</tr>
		<tr>
			<td>队伍简介</td>
			<td><input type="text" name="desc" /></td>
			<td></td>
		</tr>
		<tr>
			<td>联系人</td>
			<td><input type="text" name="name" /></td>
			<td></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="phone" /></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button type="submit">确定</button>
				<input type="button" value="取消" />
			</td>
			<td></td>
		</tr>
	</table>
	</form>
</body>
</html>