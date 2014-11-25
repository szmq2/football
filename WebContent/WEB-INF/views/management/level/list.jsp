<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%>
<dwz:paginationForm action="${contextPath }/management/level/list" page="${page }">
	<input type="hidden" name="search_LIKE_title" value="${param.search_LIKE_title}"/>
</dwz:paginationForm>

<form method="post" action="${contextPath }/management/level/list" onsubmit="return navTabSearch(this)">
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
			<shiro:hasPermission name="Level:view">
				<li><a iconClass="magnifier" target="dialog" mask="true" width="530" height="250" rel="Level_view" href="${contextPath }/management/level/view/{slt_uid}"><span>查看队伍等级</span></a></li>
			</shiro:hasPermission>		
			<shiro:hasPermission name="Level:save">
				<li><a class="add" target="dialog" mask="true" width="530" height="250" rel="Level_save" href="${contextPath }/management/level/create"><span>添加队伍等级</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Level:edit">
				<li><a class="edit" target="dialog" mask="true" width="530" height="250" rel="Level_edit" href="${contextPath }/management/level/update/{slt_uid}"><span>编辑队伍等级</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="Level:delete">
				<li><a class="delete" target="selectedTodo" rel="ids" href="${contextPath }/management/level/delete" title="确认要删除选定队伍等级?"><span>删除队伍等级</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="137" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>等级名称</th>
				<th>等级排序</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${levels}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.name}</td>
				<td>${item.sort}</td>
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