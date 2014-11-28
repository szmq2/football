<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
		<label>名称：</label>
		<span class="unit">${stadium.name}</span>
	</p>
	<p>
		<label>介绍：</label>
		<span class="unit">${stadium.descs}</span>
	</p>
	<p>
		<label>省市区：</label>
		<span class="unit">${stadium.area}</span>
	</p>
	<p>
		<label>地址：</label>
		<span class="unit">${stadium.address}</span>
	</p>
	<p>
		<label>经度：</label>
		<span class="unit">${stadium.longitude}</span>
	</p>
	<p>
		<label>纬度：</label>
		<span class="unit">${stadium.latitude}</span>
	</p>
	<p>
		<label>介绍地址：</label>
		<span class="unit">${stadium.descUrl}</span>
	</p>
	<p>
		<label>视频地址：</label>
		<span class="unit">${stadium.videoUrl}</span>
	</p>
	<p>
		<label>创建时间：</label>
		<span class="unit">${stadium.createTime}</span>
	</p>
	<p>
		<label>更新时间：</label>
		<span class="unit">${stadium.updateTime}</span>
	</p>
	<p>
		<label>状态：</label>
		<span class="unit">${stadium.status}</span>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>