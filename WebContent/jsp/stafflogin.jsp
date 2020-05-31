<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 标签位置 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工登录页面</title>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">

	#id1 {
		margin: 0 auto;
		width: 100%;
		height: 600px;
		/* background-image: url(imgs/login.jpg); */
		border-top: 1px solid black;

		}

	#login {
		width: 380px;
		height: 300px;
		background-color: rgba(0, 0, 0, 0.5);
		margin-left: 100px;
		margin-top: 50px;
		border: 1px solid black;
			}

	#login_2 {
				
		color: white;
		width: 350px;
		margin: 50px 30px;	
			}
			
			

 	body{
	
	background-image: url(${path}/res/imgs/mu.jpg);
	background-size: 100% ; 

	} 
	
	
	#p{
	margin:0 auto;
	margin-top: 200px;
	}

	span{
				font-size: 12px;
				color: red;
			}


</style>
</head>
<body >
<%-- <body background="${path}/res/imgs/zhubg.jpg" class="layui-layout-body">
 --%>
<!--empty 判断对象是否为空
为空是 true
不为空是 false
  -->
  
  <div id="id1"
		style="">
		<div id="login" style="margin: 0 auto;margin-top: 100px;">
			<div id="login_2">
				<form action="${path}/staffLogin" method="post">
					<table cellspacing="5px" align="center">
					<%-- <c:if test="${not empty message}">
 <span style="color:  red;margin: 0 auto;">${message}11</span>
</c:if> --%>
						<tr height="50px">
							<td>员工账号:</td>
							<td><input type="text" name="username"
								value="" onfocus="changeSpan('span1')"  /></td>
							<td ><span id="span1">&nbsp;${staffnameErr}</span>

							</td>
						</tr>
						<tr height="50px">
							<td>员工密码:</td>
							<td><input type="password" name="password"
								 onfocus="changeSpan('span2')" /></td>
							<td width="70px;"><span id="span2">&nbsp;${staffpasswordErr}</span></td>
						</tr>
						<%-- <tr height="50px">
							<td>验证码:</td>
							<td><input type="text" name="vcode" size="5"
								onfocus="changeSpan('span3')" />&nbsp;<img id="vimg"
								src="${path }/ServletVerifyImg" /></td>
							<td><span id="span3">&nbsp;${vcodeErr }</span></td>
						</tr> --%>
						<tr height="80px">
							<td>&nbsp;</td>
							<td>
								<input type="submit" class="layui-btn  layui-btn-sm  layui-btn-normal" value="登录" onclick="login()">
								<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="注册" onclick="toRegis()">
								<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="返回" onclick="back()">
							</td>
						</tr>
						<!-- <tr height="30px">
							<td>&nbsp;</td>

							
							 </td>
						</tr> -->
						
					</table>
					
				</form>
			</div>
		</div>
	</div>
  
<%--   <c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}11</span>
</c:if> --%>
<%--         <c:if test="${not empty msg} ">
		<span style="color: red">${msg}</span>
			</c:if>  --%>
  <%-- <div id="p" style="width:300px;height:200px;margin: 0 auot;">
	<div  class="layui-col-md12"  align="center" style="width:300px;height:200px;margin: 0 auot;">
      <div class="layui-card">
        <div  class="layui-card-header" style="width:auto;height:50px;margin: 0 auot;">员工登录</div>
        <div   class="layui-card-body" style="width:auto;height:100px;margin: 0 auot;">

		<form action="${path}/staffLogin" method="post">
	
		<i class="layui-icon "></i>  
			员工账号:<input type="text" name="username"> <br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password"> <br/>
			<div class="layui-card-body" style="width:auto;height:50px;margin: 0 auot;">
			<input type="submit" class="layui-btn  layui-btn-sm  layui-btn-normal" value="登录" onclick="login()">
			<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="注册" onclick="toRegis()">
			<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="返回" onclick="back()">
				</div>
			</form>
        </div>
      </div>
    </div>
  	
  </div> --%>

</body>
<script type="text/javascript">
	
function toRegis() {
	//跳转页面
	window.location.href="${path}/jsp/staffregister.jsp";
}

function changeSpan(id) {
	document.getElementById(id).innerHTML = "&nbsp";
} 
function back() {
	window.location.href="${path}/index.jsp";
}
</script>
</html>