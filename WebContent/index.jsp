<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 标签位置 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">
	#p{
	margin:0 auto;
	/* background: url(res/imgs/timg.jpg) repeat; */
	}
	body{
	
	background-image: url(res/imgs/bgmenu.jpg);
	background-size: 100% ; 

	}
	
	#zhu{
	margin:0 auto;
	}


</style>
</head>
<body >
<!--empty 判断对象是否为空
为空是 true
不为空是 false
  -->
 	 
  <div id="zhu" style="width:100%;height:100%;">
  <div style="float:right; width:180px;height:50px;margin-top:20px;">
  	<div>
 	<%--  <h2 ><a href="${path}/jsp/suplogin.jsp" style="color: yellow;float: right;">超级管理员登录</a></h2> --%>
  	</div>
  	</div>
  <div id="p"  title="登录界面"     
	style="width:300px;height:50px;margin: 0 auot;margin-top: 150px;" >
        <div  style="width:auto;height:100px;color: black;font-size: 15px;margin-top: 20px;">
     
      <span style="font-size: 40px;color: blue;margin-left: -20%;margin-top:200px;">超&nbsp;&nbsp;&nbsp;&nbsp;市&nbsp;&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;系&nbsp;&nbsp;&nbsp;&nbsp;统</span>
     </div>   	
  </div>
  
  <div style="width:300px;height:200px;margin:0 auto;margin-top:30px;">
  	<div>
  	<!--超级管理员登入路口-->
 	  <button type="button" style="display:block;margin:0 auto"class="layui-btn layui-btn-normal" onclick="suplogin()">超级管理员登录</button></br>
 	  <!--管理员登入路口-->
      <button type="button" style="display:block;margin:0 auto" class="layui-btn layui-btn-normal" style="margin-top: 10px;" onclick="adminlogin()">管理员登录</button></br>
      <!--员工登入路口-->
      <button type="button" style="display:block;margin:0 auto" class="layui-btn layui-btn-normal" style="margin-top: 10px;" onclick="stafflogin()">员工登录</button>
  	</div>
  
  	<div style="margin-top: 20px">
 	<%--  <h2><a href="${path}/jsp/stafflogin.jsp" style="color:aqua;">员工登录</a></h2> --%>
  	</div>
</div>

</div>
</body>
<script type="text/javascript">
	
function suplogin() {

	window.location.href="${path}/jsp//suplogin.jsp";
	toRegis
}

function adminlogin() {
	window.location.href="${path}/jsp//login.jsp";
}

function stafflogin() {
	window.location.href="${path}/jsp//stafflogin.jsp";
}
</script>
</html>