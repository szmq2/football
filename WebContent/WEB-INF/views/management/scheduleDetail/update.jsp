<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="${contextPath }/management/scheduleDetail/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<input type="hidden" name="id" value="${scheduleDetail.id}"/>
	<div class="pageFormContent" layoutH="58">
	<p>
		<label>赛程：</label>
		<input type="text" name="idSchedule" maxlength="10" value="${scheduleDetail.idSchedule}" class="input-medium"/>
	</p>
	<p>
		<label>体育场：</label>
		<input type="text" name="idStadium" maxlength="10" value="${scheduleDetail.idStadium}" class="input-medium"/>
	</p>
	<p>
		<label>分组名称：</label>
		<input type="text" name="groupName" maxlength="20" value="${scheduleDetail.groupName}" class="input-medium"/>
	</p>
	<p>
		<label>名称：</label>
		<input type="text" name="name" maxlength="20" value="${scheduleDetail.name}" class="input-medium"/>
	</p>
	<p>
		<label>排序：</label>
		<input type="text" name="sort" maxlength="10" value="${scheduleDetail.sort}" class="input-medium"/>
	</p>
	<p>
		<label>比赛日期：</label>
		<input type="text" name="date" class="input-medium date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${scheduleDetail.date}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>开始时间：</label>
		<input type="text" name="startTime" class="input-medium date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${scheduleDetail.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>结束时间：</label>
		<input type="text" name="endTime" class="input-medium date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${scheduleDetail.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>球队1：</label>
		<input type="text" name="idTeam1" maxlength="10" value="${scheduleDetail.idTeam1}" class="input-medium"/>
	</p>
	<p>
		<label>球队2：</label>
		<input type="text" name="idTeam2" maxlength="10" value="${scheduleDetail.idTeam2}" class="input-medium"/>
	</p>
	<p>
		<label>比分1：</label>
		<input type="text" name="score1" maxlength="10" value="${scheduleDetail.score1}" class="input-medium"/>
	</p>
	<p>
		<label>比分2：</label>
		<input type="text" name="score2" maxlength="10" value="${scheduleDetail.score2}" class="input-medium"/>
	</p>
	<p>
		<label>视频地址：</label>
		<input type="text" name="videoUrl" maxlength="500" value="${scheduleDetail.videoUrl}" class="input-medium"/>
	</p>
	<p>
		<label>比赛介绍地址：</label>
		<input type="text" name="descUrl" maxlength="500" value="${scheduleDetail.descUrl}" class="input-medium"/>
	</p>
	<p>
		<label>状态：</label>
		<dwz:dic themeName="状态" paramName="status" className="combox" selectedValue="${scheduleDetail.status}">
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