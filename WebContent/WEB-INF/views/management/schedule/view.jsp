<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
		<label>名称：</label>
		<span class="unit">${schedule.name}</span>
	</p>
	<p>
		<label>介绍：</label>
		<span class="unit">${schedule.descs}</span>
	</p>
	<p>
		<label>开始时间：</label>
		<span class="unit">${schedule.startTime}</span>
	</p>
	<p>
		<label>结束时间：</label>
		<span class="unit">${schedule.endTime}</span>
	</p>
	<p>
		<label>创建时间：</label>
		<span class="unit">${schedule.createTime}</span>
	</p>
	<p>
		<label>更新时间：</label>
		<span class="unit">${schedule.updateTime}</span>
	</p>
	<p>
		<label>状态：</label>
		<span class="unit">${schedule.status}</span>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>