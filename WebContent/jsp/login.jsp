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
<script type="text/javascript"  src="${path}/res/tools/layui/layui.js"></script>
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
			
	#p{
	margin:0 auto;
	margin-top: 200px;
	}

 	body{
	
	background-image: url(${path}/res/imgs/mu.jpg);
	background-size: 100% ; 

	} 
	
	span{
				font-size: 12px;
				color: red;
			}

</style>
</head>
<body >
<!--empty 判断对象是否为空
为空是 true
不为空是 false
  -->
  

	<div id="id1"
		style="">
		<div id="login" style="margin: 0 auto;margin-top: 100px;">
			<div id="login_2">
				<form action="${path}/login" method="post">
					<table cellspacing="5px" align="center">
					<%-- <c:if test="${not empty message}">
 <span style="color:  red;margin: 0 auto;">${message}11</span>
</c:if> --%>
						<tr height="50px">
							<td>管理员账号:</td>
							<td><input type="text" name="username"
								value="" onfocus="changeSpan('span1')"  /></td>
							<td ><span id="span1">&nbsp;${usernameErr}</span>

							</td>
						</tr>
						<tr height="50px">
							<td>管理员密码:</td>
							<td><input type="password" name="password"
								 onfocus="changeSpan('span2')" /></td>
							<td width="70px;"><span id="span2">&nbsp;${passwordErr}</span></td>
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


  <%-- <div id="p"  title="登录界面"     
	style="width:300px;height:200px;margin: 0 auot;">
	<div   class="layui-col-md12"  align="center" style="width:300px;height:200px;margin: 0 auot;">
     
      <div class="layui-card">
     
        <div class="layui-card-header" style="width:auto;height:50px;margin: 0 auot;">管理员登录界面</div>
        <div class="layui-card-body" style="width:auto;height:100px;margin: 0 auot;">
           <c:if test="${not empty message}">
 <span style="color:  red;margin: 0 auto;">${message}11</span>
</c:if>
		<form action="${path}/login" method="post">
			管理员账号:<input type="layui-text" id="na" name="username"> <br/>
			管理员密码:<input id="ps" type="password" name="password"> <br/>
			<div class="layui-card-body" style="width:auto;height:50px;margin: 0 auot;">
			<input type="submit" class="layui-btn  layui-btn-sm  layui-btn-normal" value="登录" onclick="login()">
			<input type="button" class="layui-btn  layui-btn-sm  layui-btn-normal" value="注册" onclick="toRegis()">
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
	//alert($("#na").val());
	window.location.href="${path}/jsp/adminregister.jsp";
	toRegis
}

function changeSpan(id) {
	document.getElementById(id).innerHTML = "&nbsp";
} 

function back() {
	window.location.href="${path}/index.jsp";
}

function login() {
	//alert("ok"${user});
/* 	alert("登录信息，用户名："+$("#na").val()+"密码："+$("#ps").val());
	 if(${not empty message}){
		  alert("用户不存在，请重新输入");
 }else{
	 alert("登录成功");
	 } */
	 
	 
	//if(${not empty user}){
	//	 alert("成功登录：");
	// };
	// if(${ not empty message}){
	//	alert("用户名或者密码错误,请重新输入");
	//};
}
</script>
</html>