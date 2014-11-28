<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/scheduleDetail/list" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/scheduleDetail/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<input type="text" name="search_LIKE_title" value="${param.search_LIKE_title}"/>			
				</li>
			</ul>
			<div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="ScheduleDetail:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="250" rel="ScheduleDetail_view" href="${contextPath }/management/scheduleDetail/view/{slt_uid}"><span>查看赛程明细</span></a></li>
			</shiro:hasPermission>		
			<shiro:hasPermission name="ScheduleDetail:save">
				<li><a class="add" target="dialog" mask="true" width="530" height="250" rel="ScheduleDetail_save" href="${contextPath }/management/scheduleDetail/create"><span>添加赛程明细</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="ScheduleDetail:edit">
				<li><a class="edit" target="dialog" mask="true" width="530" height="250" rel="ScheduleDetail_edit" href="${contextPath }/management/scheduleDetail/update/{slt_uid}"><span>编辑赛程明细</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="ScheduleDetail:delete">
				<li><a class="delete" target="selectedTodo" rel="ids" href="${contextPath }/management/scheduleDetail/delete" title="确认要删除选定赛程明细?"><span>删除赛程明细</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>赛程</th>
				<th>体育场</th>
				<th>分组名称</th>
				<th>名称</th>
				<th>排序</th>
				<th>比赛日期</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>球队1</th>
				<th>球队2</th>
				<th>比分1</th>
				<th>比分2</th>
				<th>视频地址</th>
				<th>比赛介绍地址</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${scheduleDetails}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.idSchedule}</td>
				<td>${item.idStadium}</td>
				<td>${item.groupName}</td>
				<td>${item.name}</td>
				<td>${item.sort}</td>
				<td><fmt:formatDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${item.idTeam1}</td>
				<td>${item.idTeam2}</td>
				<td>${item.score1}</td>
				<td>${item.score2}</td>
				<td>${item.videoUrl}</td>
				<td>${item.descUrl}</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${item.status}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 分页 -->
	<dwz:pagination page="${page }"/>
</div>