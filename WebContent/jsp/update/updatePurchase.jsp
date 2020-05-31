<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加商品</title>

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
		style="margin-top: 20px; text-align: center; ">
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">订单ID</label>
			<div class="layui-input-inline">
				<input value="${purchase.purid}" name="purid" type="text"
					required lay-verify="required" placeholder="请输入订单ID"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品ID</label>
			<div class="layui-input-inline">
				<input id="shopid" value="${purchase.shopid}" name="shopid" type="text"
					required lay-verify="required" placeholder="请输入商品ID"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input id="shopname" type="text" value="${purchase.shopname}" name="shopname" required
					lay-verify="required" placeholder="请输入商品名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style=" margin: 0px auto;">商品数量</label>
			<div class="layui-input-inline">
				<input id="shopnum" type="text" value="${purchase.shopnum}" name="shopnum"
					required lay-verify="required" placeholder="请输入商品数量"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style="margin: 0px auto;">商品价格</label>
			<div class="layui-input-inline">
				<input id="shopprice" type="text" value="${purchase.shopprice}" name="shopprice"
					required lay-verify="required" placeholder="请输入商品价格"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">进货日期</label>
			<div class="layui-input-inline">
				<%-- <input type="text" value="${purchase.purdate}" name="purdate"
					required lay-verify="required" placeholder="请输入进货日期"
					autocomplete="off" class="layui-input">
					<input id="prodate" type="text" value="${product.prodate}" name="prodate"
					required lay-verify="required" placeholder="请输入进货日期"
					autocomplete="off" class="layui-input"> --%>
					<input type="text" class="layui-input" id="purdate" value="${purchase.purdate}" name="purdate" placeholder="yyyy-MM-dd" required lay-verify="required" autocomplete="off" >
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">供应商</label>
			<div class="layui-input-inline">
				<input id="supname" type="text" value="${purchase.supname}" name="supname" required
					lay-verify="required" placeholder="供应商" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" >
			<div id="lab1" class="layui-input-block" >
				<button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo"
					type="button" id="cx">确定</button>
				<button type="button" class="layui-btn layui-btn-primary"
					onclick="back()">
					<a href="">返回</a>
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
	
	function back() {
		//alert("返回")
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//alert("窗体为：" + index)
		parent.layer.close(index);//关闭窗口
	}
	
	$(document).ready(function(){
	    $('#cx').click(function(){  //name为标识

	       
	        var $shopid = $.trim($("#shopid").val());
	        //alert("供应商idid为："+$shopid)
	      	var $shopname = $.trim($("#shopname").val());
	        //alert("商品名称商idid为："+$shopname)
	    	var $shopprice = $.trim($("#shopprice").val());
	      	var $shopnum = $.trim($("#shopnum").val());
	      	//var $purdate = $.trim($("#purdate").val());
	      	var $supname = $.trim($("#supname").val());

	         if($shopid == ''){
	         	//alert("商品id为"+$shopid)
	            layer.msg('请输入商品ID',function() {time:2000}); 
	             return false;  
	         } else if (!/^[0-9]?[0-9]?$|100/.test($("#shopid").val())) {
	         	//alert("商品ID是"+$shopid)
	         	layer.msg('请输入正确的商品ID！',function() {time:2000});
	         	return false; 
	 		}
	       if($shopname == ''){  
	            layer.msg('请输入商品名称！',function() {time:2000});
	            return false; 
	        }
	       
	       if($shopprice == ''){  
	           layer.msg('请输入商品价格！',function() {time:2000});
	           return false; 
	       }else if (!/[1-9]\d*.\d\d|0\.\d\d/.test($("#shopprice").val())) {
				//alert("您还未输入商品id,请输入商品价格"+$shopprice)
	          	layer.msg('输入错误,请输入正确的商品价格,如xx.x',function() {time:2000});
	          	return false;
			}
	       
	       if ($shopnum =='') {
	         	//alert("您还未输入商品,请输入商品数量")
	         	layer.msg('请输入商品数量',function() {time:2000});
	         	return false;
	   		}else if (!/^([1-9]|[1-9]\d|[1-9]\d\d|1000)$/.test($("#shopnum").val())) {
	   			//alert("您输入商品数量11为"+$shopnum)
	             	layer.msg('商品数量输入错误,输入范围为1-1000,请重新输入',function() {time:2000});
	             	return false;
				}
	       
	       if($supname == ''){  
	           layer.msg('请输入供应商名称！',function() {time:2000});
	           return false; 
	       }
	       
	       
	   		//alert("更新中")
	   		$.ajax({
	   			url : "${path}/updatePurchase",
	   			type : "post",
	   			dataType : "json",
	   			data : $("#form2").serialize(),
	   			success : function(result) {
	   				if (result.type == 1) {
	   					//alert("OK")
	   					window.parent.location.reload();//刷新父窗体

	   					var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
	   					//alert("窗体为：" + index)
	   					parent.layer.close(index);//关闭窗口
	   				}

	   			}
	   		})
	   	
	    });  
	});
</script>
</html>