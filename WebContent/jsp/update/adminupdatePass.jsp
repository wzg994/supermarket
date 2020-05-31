<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员修改密码界面</title>
<link href="${path}/res/tools/layui/css/layui.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${path}/res/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">
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
		style="margin-top: 20px; text-align: center; ">
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">旧密码:</label>
			<div class="layui-input-inline">

			<input type="password" name="oo" id="oldP" required
					lay-verify="required" placeholder="请输入旧密码" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">新密码:</label>
			<div class="layui-input-inline">
		
				<input  type="password" name="aa" id="newP"
					required lay-verify="required" placeholder="请输入新密码"
					autocomplete="off" class="layui-input">
			</div>
		</div>

	
		<div  id="divf" class="layui-form-item" style="width: 300px;">
			<div  id="lab1" class="layui-input-block">
				<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo"
					type="button" onclick="sub()">确定</button>
				<button type="button" class="layui-btn layui-btn-normal"
					onclick="back()">
					返回
				</button>
				<!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			</div>
		</div>
	</form>
</body>
	<script type="text/javascript">
		var oldP=document.getElementById("oldP");
		var newP=document.getElementById("newP");
		function sub(){
			if(oldP.value==""||newP.value==""){
				alert("不能为空");
				return;
			}
			
			$.ajax({
				type:"post",
				url:"${path}/updatePass",
				data:{
					"oldP":oldP.value,
					"newP":newP.value,
					//"staffid":${staff.staffid}
				},
				dataType:"text",
				success:function(result){
					if(result==-1){
						alert("旧密码错误");
					}
					if(result==2){
						alert("新密码与旧密码一致");
					}
					if(result==1){
						alert("修改成功，请重新登陆");
						location.href="${path}/jsp/login.jsp";
					}
				}
			});
		}
		
		function back() {
			window.location.href="${path}/jsp/user/adminmenu.jsp";
		}
	</script>
</html>