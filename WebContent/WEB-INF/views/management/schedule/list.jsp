<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/schedule/list" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/schedule/list" onsubmit="return navTabSearch(this)">
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
			<shiro:hasPermission name="Schedule:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="250" rel="Schedule_view" href="${contextPath }/management/schedule/view/{slt_uid}"><span>查看赛程</span></a></li>
			</shiro:hasPermission>		
			<shiro:hasPermission name="Schedule:save">
				<li><a class="add" target="dialog" mask="true" width="530" height="250" rel="Schedule_save" href="${contextPath }/management/schedule/create"><span>添加赛程</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Schedule:edit">
				<li><a class="edit" target="dialog" mask="true" width="530" height="250" rel="Schedule_edit" href="${contextPath }/management/schedule/update/{slt_uid}"><span>编辑赛程</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Schedule:delete">
				<li><a class="delete" target="selectedTodo" rel="ids" href="${contextPath }/management/schedule/delete" title="确认要删除选定赛程?"><span>删除赛程</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>名称</th>
				<th>介绍</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${schedules}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.name}</td>
				<td>${item.descs}</td>
				<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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