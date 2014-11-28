<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<div class="pageContent">
	<div class="pageFormContent" layoutH="58">
		<p>
		<label>赛程：</label>
		<span class="unit">${scheduleDetail.idSchedule}</span>
	</p>
	<p>
		<label>体育场：</label>
		<span class="unit">${scheduleDetail.idStadium}</span>
	</p>
	<p>
		<label>分组名称：</label>
		<span class="unit">${scheduleDetail.groupName}</span>
	</p>
	<p>
		<label>名称：</label>
		<span class="unit">${scheduleDetail.name}</span>
	</p>
	<p>
		<label>排序：</label>
		<span class="unit">${scheduleDetail.sort}</span>
	</p>
	<p>
		<label>比赛日期：</label>
		<span class="unit">${scheduleDetail.date}</span>
	</p>
	<p>
		<label>开始时间：</label>
		<span class="unit">${scheduleDetail.startTime}</span>
	</p>
	<p>
		<label>结束时间：</label>
		<span class="unit">${scheduleDetail.endTime}</span>
	</p>
	<p>
		<label>球队1：</label>
		<span class="unit">${scheduleDetail.idTeam1}</span>
	</p>
	<p>
		<label>球队2：</label>
		<span class="unit">${scheduleDetail.idTeam2}</span>
	</p>
	<p>
		<label>比分1：</label>
		<span class="unit">${scheduleDetail.score1}</span>
	</p>
	<p>
		<label>比分2：</label>
		<span class="unit">${scheduleDetail.score2}</span>
	</p>
	<p>
		<label>视频地址：</label>
		<span class="unit">${scheduleDetail.videoUrl}</span>
	</p>
	<p>
		<label>比赛介绍地址：</label>
		<span class="unit">${scheduleDetail.descUrl}</span>
	</p>
	<p>
		<label>创建时间：</label>
		<span class="unit">${scheduleDetail.createTime}</span>
	</p>
	<p>
		<label>更新时间：</label>
		<span class="unit">${scheduleDetail.updateTime}</span>
	</p>
	<p>
		<label>状态：</label>
		<span class="unit">${scheduleDetail.status}</span>
	</p>
	</div>
	
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>