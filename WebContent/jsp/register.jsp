<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>

<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>
<style type="text/css">

#div02{
   float: left;  
   width: 300px;
   height: 300px;
   border: 1px blue solid;
}

#div03{
   float: left;  
   width: auto;
   height: auto;
   border: 1px blue solid;
   margin-top:10px;
   margin-bottom:10px;
   margin-right: 20px;
   float: right;
}
#divf{
	position:relative;
   	left:30%;
	margin-top: 10px;
	}
		
#lab1{
    display: inline-block;
    text-align: left;
}
</style>
</head>
<body>

<!-- 
		empty  判断对象是否为空 
		为空是   true
		不为空是 false
		 -->
		 
		<c:if test="${not empty message}">
		 <span style="color:  red">${message}</span>
		</c:if>
<form class="layui-form" action="${path}/adminRegister" id="form1" 
		style="margin-top: 20px; text-align: center; ">
		<div id="divf" class="layui-form-item" style="border: 1px blue solid; width: 400px;">
		<p style="font-size: 20px;">请输入注册的管理员信息</p>
		</div>
	<%-- 	<div id="divf" class="layui-form-item"
			style="border: 1px blue solid; width: 400px;">
			<label id="lab1" class="layui-form-label">员工id</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="adminid" type="text" name="adminid" required
					lay-verify="required" placeholder="请输入员工id" autocomplete="on"
					class="layui-input">
			</div>
		</div>  --%>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">管理员账号</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="adminname" name="adminname" type="text"
					required lay-verify="required" placeholder="请输入员工姓名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item"
			style="">
			<label id="lab1" class="layui-form-label">管理员密码</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="adminpassword" type="text" name="adminpassword" required
					lay-verify="required" placeholder="请输入商品类别ID" autocomplete="on"
					class="layui-input">
			</div>
		</div> 

		 <div id="divf" class="layui-form-item" style="width: 400px;">
			    <div class="layui-input-block" style="margin: 0 auto;">
			     <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" type="submit" id="confirm">注册</button>
			      <button type="reset" class="layui-btn layui-btn-normal">重置</button>
			      <button type="button" class="layui-btn layui-btn-normal" onclick="back()">返回</button>
			    </div>
			  </div>
	</form>


</body>
<script type="text/javascript">

</script>
</html>