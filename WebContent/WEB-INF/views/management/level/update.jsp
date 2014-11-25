<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath }/management/level/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${level.id}"/>
	<div class="pageFormContent" layoutH="58">
	<p>
		<label>等级名称：</label>
		<input type="text" name="name" maxlength="20" value="${level.name}" class="input-medium required validate[required]"/>
	</p>
	<p>
		<label>等级排序：</label>
		<input type="text" name="sort" maxlength="10" value="${level.sort}" class="input-medium"/>
	</p>
	<p>
		<label>创建时间：</label>
		<input type="text" name="createTime" class="input-medium date validate[required]" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${level.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>更新时间：</label>
		<input type="text" name="updateTime" class="input-medium date validate[required]" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${level.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>状态：</label>
		<input type="text" name="status" maxlength="3" value="${level.status}" class="input-medium"/>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>