<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超级管理员界面</title>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>
</head>
<body>

<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" type="submit" id="confirm" onclick="admin()">管理员信息</button>
<button type="reset" class="layui-btn layui-btn-normal" onclick="staff()">员工信息</button>
<button type="button" class="layui-btn layui-btn-normal" onclick="back()">返回</button>	

 
</body>

<script type="text/javascript">

function admin() {
	//跳转页面
	window.location.href="${path}/operatSupmaster?operation=3";
}
function staff() {
	//跳转页面
	window.location.href="${path}/operatSupmaster?operation=2";

}
function back() {
	//跳转页面
	window.location.href="${path}/index.jsp";
}

</script>
</html>