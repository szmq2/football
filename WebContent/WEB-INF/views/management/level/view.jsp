<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
		<label>等级名称：</label>
		<span class="unit">${level.name}</span>
	</p>
	<p>
		<label>等级排序：</label>
		<span class="unit">${level.sort}</span>
	</p>
	<p>
		<label>创建时间：</label>
		<span class="unit">${level.createTime}</span>
	</p>
	<p>
		<label>更新时间：</label>
		<span class="unit">${level.updateTime}</span>
	</p>
	<p>
		<label>状态：</label>
		<span class="unit">${level.status}</span>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>