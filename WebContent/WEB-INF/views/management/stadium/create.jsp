<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.inc.jsp"%> 
<div class="pageContent">
<form method="post" action="${contextPath }/management/stadium/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogReloadNavTab);">
	<div class="pageFormContent" layoutH="58">
	<p>
		<label>名称：</label>
		<input type="text" name="name" maxlength="20" class="input-medium"/>
	</p>	
	<p>
		<label>介绍：</label>
		<input type="text" name="descs" maxlength="500" class="input-medium"/>
	</p>	
	<p>
		<label>省市区：</label>
		<input type="text" name="area" maxlength="10" class="input-medium"/>
	</p>	
	<p>
		<label>地址：</label>
		<input type="text" name="address" maxlength="500" class="input-medium"/>
	</p>	
	<p>
		<label>经度：</label>
		<input type="text" name="longitude" maxlength="12" class="input-medium"/>
	</p>	
	<p>
		<label>纬度：</label>
		<input type="text" name="latitude" maxlength="12" class="input-medium"/>
	</p>	
	<p>
		<label>介绍地址：</label>
		<input type="text" name="descUrl" maxlength="500" class="input-medium"/>
	</p>	
	<p>
		<label>视频地址：</label>
		<input type="text" name="videoUrl" maxlength="500" class="input-medium"/>
	</p><!-- 	
	<p>
		<label>创建时间：</label>
		<input type="text" name="createTime" class="input-medium date" readonly="readonly" style="float:left;"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>	
	<p>
		<label>更新时间：</label>
		<input type="text" name="updateTime" class="input-medium date" readonly="readonly" style="float:left;"/>
		<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
	</p>
	<p>
		<label>状态：</label>
		<input type="text" name="status" maxlength="3" class="input-medium"/>
	</p>-->
	<p>
		<label>状态：</label>
		<dwz:dic themeName="状态" paramName="status" className="combox">
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