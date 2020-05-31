<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>更新商品类别信息</title>

<link href="${path}/res/tools/layui/css/layui.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="${path}/res/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">
#div02 {
	float: left;
	width: 300px;
	height: 300px;
	border: 1px blue solid;
}

#div03 {
	float: left;
	width: auto;
	height: auto;
	border: 1px blue solid;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-right: 20px;
	float: right;
}

#divf {
	position: relative;
	left: 30%;
	margin-top: 10px;
}

#lab1 {
	display: inline-block;
	text-align: left;
}
</style>
</head>
<body>
	<form class="layui-form" id="form2"
		style="margin-top: 20px; text-align: center;">
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">员工ID</label>
			<div class="layui-input-inline">
				<input id="staffid1" value="${staff.staffid}" type="text" name="staffid" required
					lay-verify="required" placeholder="请输入员工ID" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工姓名</label>
			<div class="layui-input-inline">
				<input id="staffname" value="${staff.staffname}" name="staffname" type="text"
					required lay-verify="required" placeholder="请输入员工姓名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工身份证</label>
			<div class="layui-input-inline">
				<input id="idnum" type="text" value="${staff.idnum}" name="idnum" required
					lay-verify="required" placeholder="请输入员工身份证" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label">员工性别</label>
			    <div class="layui-input-inline">
			   		<select id="sex" name="sex"  lay-verify="">
						<option  value="${staff.sex}" name="sex" >${staff.sex}</option>
						<option  name="sex" >男</option>
						<option  name="sex" >女</option>
					</select> 
			    <!--   <input id="sex" type="text" name="sex"  required  lay-verify="required" placeholder="请输入员工性别" autocomplete="on" class="layui-input"> -->
			    </div>
			  </div>
		<%-- <div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style="margin: 0px auto;">员工性别</label>
			<div class="layui-input-inline">
				<input type="text" value="${staff.sex}" name="sex"
					required lay-verify="required" placeholder="员工性别"
					autocomplete="off" class="layui-input">
			</div>
		</div> --%>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工电话</label>
			<div class="layui-input-inline">
				<input id="tel" type="text" value="${staff.tel}" name="tel"
					required lay-verify="required" placeholder="请输入员工电话"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工地址</label>
			<div class="layui-input-inline">
				<input  id="staffadd" type="text" value="${staff.staffadd}" name="staffadd" required
					lay-verify="required" placeholder="员工地址" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		 <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label">员工学历</label>
			    <div class="layui-input-inline">
			  		<select id="staffedu" name="staffedu"  lay-verify="">
						<option  value="${staff.staffedu}">${staff.staffedu}</option>
						<option  name="staffedu">初中</option>
						<option  name="staffedu" >高中</option>
						<option  name="staffedu" >中专</option>
						<option  name="staffedu" >大专</option>
						<option  name="staffedu" >本科</option>
					</select> 
			   <%--    <input id="staffedu" name="staffedu" value="${staff.staffedu}" type="text"  required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input"> --%>
			    </div>
			  </div>
		<%-- <div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工学历</label>
			<div class="layui-input-inline">
				<input type="text" value="${staff.staffedu}" name="staffedu" required
					lay-verify="required" placeholder="员工学历" autocomplete="off"
					class="layui-input">
			</div>
		</div> --%>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工密码</label>
			<div class="layui-input-inline">
				<input  id="staffpassword" type="text" value="${staff.staffpassword}" name="staffpassword" required
					lay-verify="required" placeholder="请输入员工密码" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div id="lab1" class="layui-input-block">
				<button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo"
					type="button"  onclick="sub()" >确定</button>
				<button type="button" class="layui-btn layui-btn-primary"
					onclick="back()">
					返回
				</button>
				<!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">

layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});

	function sub() {
		
		
					
					window.parent.location.reload();//刷新父窗体

					var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
				
					parent.layer.close(index);//关闭窗口
				

		
	}
	function back() {
		
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
	
		parent.layer.close(index);//关闭窗口
	}
</script>
</html>