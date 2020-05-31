<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员注册界面</title>
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
		<div id="divf" class="layui-form-item" style="text-align: center;border: 1px blue solid; width: 400px;">
		 <span style="color: red;font-size: 18px;">${message}</span>
		 </div>
		</c:if>
<form class="layui-form" action="${path}/adminRegister" id="form1" 
		style="margin-top: 50px; text-align: center; ">
		<div id="divf" class="layui-form-item" style=" width: 400px;">
		<p style="font-size: 20px;">请输入注册的管理员信息</p>
		</div>
		<%-- <div id="divf" class="layui-form-item"
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
					required lay-verify="required" placeholder="请输入管理员账号"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item"
			style="">
			<label id="lab1" class="layui-form-label">管理员密码</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="adminpassword" type="password" name="adminpassword" required
					lay-verify="required" placeholder="请输入管理员密码" autocomplete="on"
					class="layui-input">
			</div>
		</div> 

		 <div id="divf" class="layui-form-item" style=" width: 400px;">
			    <div class="layui-input-block" style="margin: 0 auto;">
			     <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" type="submit" id="confirm">注册</button>
			      <button type="reset" class="layui-btn layui-btn-normal">重置</button>
			      <button type="button" class="layui-btn layui-btn-normal" onclick="back()">返回</button>
			    </div>
			  </div>
	</form>


</body>


<script type="text/javascript">
;!function(){
	  //无需再执行layui.use()方法加载模块，直接使用即可
	  var form = layui.form
	  ,layer = layui.layer;
	  
	  //…
	}();
	
	function back() {
		//跳转页面
		alert("dinaji ")
		window.location.href="${path}/jsp/login.jsp";
	}

layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});


$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $adminid = $.trim($("#adminid").val());//商品id
       // alert("商品id为："+$adminid)
        var $adminname = $.trim($("#adminname").val());
        //alert("管理员名称为："+$adminname)
      	var $adminpassword = $.trim($("#adminpassword").val());
        //alert("管理员名称为："+$adminpassword)
    /*   	 if ($staffid =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*//* .test($("#staffid1").val())){
        	alert("商品id为："+$saleid)
        	layer.msg('输入错误，请输入正确的客户id',function() {time:2000});
       		return false;
       } */ 
		
    	if ($adminname =='') {
             //alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入管理员账号',function() {time:2000});
             return false;
        	}
    	
   		if ($adminpassword =='') {
        //alert("您还未输入商品类型,请输入商品id")
        layer.msg('请输入管理员密码',function() {time:2000});
        return false;
  	 	}
	
   		alert("注册成功")
	
    });  
});	

</script>
</html>