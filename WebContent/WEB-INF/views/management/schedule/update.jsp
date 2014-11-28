<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath}/management/schedule/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${schedule.id}"/>
	<div class="pageFormContent" layoutH="58">
	<p>
		<label>名称：</label>
		<input type="text" name="name" maxlength="20" value="${schedule.name}" class="input-medium"/>
	</p>
	<p>
		<label>介绍：</label>
		<input type="text" name="descs" maxlength="500" value="${schedule.descs}" class="input-medium"/>
	</p>
	<p>
		<label>开始时间：</label>
		<input type="text" name="startTime" class="input-medium date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${schedule.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>结束时间：</label>
		<input type="text" name="endTime" class="input-medium date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${schedule.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>状态：</label>
		<dwz:dic themeName="状态" paramName="status" className="combox" selectedValue="${schedule.status}">
		</dwz:dic>
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