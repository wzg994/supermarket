<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 标签位置 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录页面</title>

<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>


<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">
	#p{
	margin:0 auto;
	margin-top: 200px;
	}



</style>
</head>
<body background="${path}/res/imgs/background.jpg" class="layui-layout-body">
<!--empty 判断对象是否为空
为空是 true
不为空是 false
  -->
<%-- <c:if test="${not empty message}">
 <span style="color:  red">${message}</span>
</c:if> --%>
  <div id="p"  title="登录界面"     
	style="width:300px;height:200px;margin: 0 auot;">
	<div   class="layui-col-md12"  align="center" style="width:300px;height:200px;margin: 0 auot;">
      <div class="layui-card">
        <div class="layui-card-header" style="width:auto;height:50px;margin: 0 auot;">管理员登录界面</div>
        <div class="layui-card-body" style="width:auto;height:100px;margin: 0 auot;">
          <c:if test="${not empty message} ">
		<span style="color: red">${message}</span>
			</c:if>
		<form action="${path}/login" method="post">
			用户名:<input type="layui-text" id="na" name="username"> <br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码:<input id="ps" type="password" name="password"> <br/>
			<div class="layui-card-body" style="width:auto;height:50px;margin: 0 auot;">
			<input type="submit" class="layui-btn  layui-btn-sm  layui-btn-normal" value="登录" onclick="login()">
			<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="注册" onclick="toRegis()">
				</div>
			</form>
        </div>
      </div>
    </div>
  	
  </div>

</body>
<script type="text/javascript">
	
function toRegis() {
	//跳转页面
	alert($("#na").val());
	window.location.href="${path}/jsp/adminregister.jsp";
	toRegis
}
function login() {
	alert("ok"${user});
/* 	alert("登录信息，用户名："+$("#na").val()+"密码："+$("#ps").val());
	 if(${not empty message}){
		  alert("用户不存在，请重新输入");
 }else{
	 alert("登录成功");
	 } */
	if(${not empty user}){
		 alert("成功登录：");
	 };
	 if(${ not empty message}){
		alert("用户名或者密码错误,请重新输入");
	};
}
</script>
</html>