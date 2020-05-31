<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工注册界面</title>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>

<%-- <script src="${path}/res/tools/layui/lay/modules/layer.js"></script> --%>
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

<%-- <form action="${path}/staffRegiter" method="post">
	员工编号:<input type="text" name="staffid"> <br/>
	员工名:<input type="text" name="username"> <br/>
	密码:<input type="password" name="password"> <br/>
	<input type="submit" value="注册" >
	<input type="reset" value="重置">
	
</form> --%>




<form class="layui-form" action="${path}/staffRegiter" id="form1" method="post"
		style="margin-top: 50px; text-align: center;">
	<div id="divf" class="layui-form-item" style=" width: 400px;">
		<p style="font-size: 20px;">请输入注册的员工信息</p>
		</div>
	
	<%-- 	<div id="divf" class="layui-form-item"
			style="border: 1px blue solid; width: 400px;">
			<label id="lab1" class="layui-form-label">员工id</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="staffid1" type="text" name="staffid" required
					lay-verify="required" placeholder="请输入员工id" autocomplete="on"
					class="layui-input">
			</div>
		</div>  --%>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工姓名</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="staffname" name="staffname" type="text"
					required lay-verify="required" placeholder="请输入员工姓名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<%-- <div id="divf" class="layui-form-item"
			style="border: 1px blue solid; width: 400px;">
			<label id="lab1" class="layui-form-label">身份证号码</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" type="text" name="idnum" required
					lay-verify="required" placeholder="请输入身份证号码" autocomplete="on"
					class="layui-input">
			</div>
		</div>  --%>
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">员工性别</label>
			<div class="layui-input-inline">
			<select id="sex" name="sex"  lay-verify="">
						<option  value="" >请选择员工性别</option>
						<option  name="sex" >男</option>
						<option  name="sex" >女</option>
					</select> 
				<%-- <input value="${stock.shopid}" type="text" name="sex" required
					lay-verify="required" placeholder="请输入性别" autocomplete="on" 
					class="layui-input"> --%>
			</div>
		</div> 
		<div id="divf" class="layui-form-item"
			style=" width:400px;">
			<label id="lab1" class="layui-form-label">电话号码</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="tel" type="text" name="tel" required 
				lay-verify="required" placeholder="请输入电话号码" autocomplete="on"
					class="layui-input">
			</div>
		</div> 
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">员工地址</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" type="text" id="staffadd" name="staffadd" required
					lay-verify="required" placeholder="请输入员工地址" autocomplete="on"
					class="layui-input">
			</div>
		</div> 
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">员工学历</label>
			<div class="layui-input-inline">
			<select id="staffedu" name="staffedu"  lay-verify="">
						<option  value="" >请选择员工学历</option>
						<option  value="1" >初中</option>
						<option  value="2" >高中</option>
						<option  value="1" >中专</option>
						<option  value="2" >大专</option>
						<option  value="1" >本科</option>
				</select> 
				<%-- <input value="${stock.shopid}" type="text" name="staffedu" required
					lay-verify="required" placeholder="请输入员工" autocomplete="on"
					class="layui-input"> --%>
			</div>
		</div> 
		<div id="divf" class="layui-form-item"
			style="">
			<label id="lab1" class="layui-form-label">登录密码</label>
			<div class="layui-input-inline">
				<input value="${stock.shopid}" id="staffpassword" type="text" name="staffpassword" required
					lay-verify="required" placeholder="请输入登录密码" autocomplete="on"
					class="layui-input">
			</div>
		</div> 

		 <div id="divf" class="layui-form-item" style=" width: 400px;">
			    <div class="layui-input-block" style="margin: 0 auto;">
			     <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" type="submit" id="confirm">确认</button>
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
		window.location.href="${path}/jsp/stafflogin.jsp";
		toRegis
	}

layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});


$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $staffid = $.trim($("#staffid1").val());//商品id
        alert("商品id为："+$staffid)
        var $staffname = $.trim($("#staffname").val());
        alert("商品名称为："+$staffname)
      	/*var $idnum = $.trim($("#idnum").val());*/
      /* var $sex = $.trim($("#sex").val()); */
      	var $tel = $.trim($("#tel").val());
      	/* var $staffadd = $.trim($("#staffadd").val()); */
      	var $staffedu = $.trim($("#staffedu").val());
      	var $staffpassword = $.trim($("#staffpassword").val());
      	
      	 if ($staffid =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*/.test($("#staffid1").val())){
        	alert("商品id为："+$saleid)
        	layer.msg('输入错误，请输入正确的客户id',function() {time:2000});
       		return false;
       }
		
    	if ($staffname =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入员工名称',function() {time:2000});
             return false;
        	}
    	
    	/*if ($idnum =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户电话',function() {time:2000});
           	return false;
     		}else if (!/^1[34578]\d{9}$/.test($("#idnum").val())) {
            	alert("电话号码是"+$suptel)
            	layer.msg('请输入正确的电话号码！',function() {time:2000});
            	return false; 
    		} */
		
    /* 	if ($sex =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入负责人',function() {time:2000});
             return false;
        	} */
    	
    	if ($tel =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入电话号码',function() {time:2000});
           	return false;
     		}else if (!/^1[34578]\d{9}$/.test($("#tel").val())) {
            	alert("电话号码是"+$suptel)
            	layer.msg('请输入正确的电话号码！',function() {time:2000});
            	return false; 
    		}
		
    /* 	if ($staffadd =='') {
            alert("您还未输入商品类型,请输入商品id")
            layer.msg('请输入员工住址',function() {time:2000});
            return false;
       	} */
   	
   	/* if ($staffedu =='') {
          	alert("您还未输入商品id,请输入商品id")
          	layer.msg('请输入客户地址',function() {time:2000});
          	return false;
    	} */
   	
   	if ($staffpassword =='') {
        alert("您还未输入商品类型,请输入商品id")
        layer.msg('请输入密码',function() {time:2000});
        return false;
   	}
	
	
    });  
});	

</script>
</html>