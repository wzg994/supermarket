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
		style="margin-top: 20px; text-align: center;margin: 0 auto;">
		<div id="divf" class="layui-form-item" style=" width: 400px;">
			<label id="lab1" class="layui-form-label">退货编号</label>
			<div class="layui-input-inline">
				<input id="repurid" value="${repurchase.repurid}" type="text" name="purid" required
					lay-verify="required" placeholder="请输入供应商编号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style=" width: 400px;">
			<label id="lab1" class="layui-form-label">订单编号</label>
			<div class="layui-input-inline">
				<input id="purid" value="${repurchase.purid}" type="text" name="purid" required
					lay-verify="required" placeholder="请输入供应商编号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品编号</label>
			<div class="layui-input-inline">
				<input id="shopid" value="${repurchase.shopid}" name="shopid" type="text"
					required lay-verify="required" placeholder="请输入商品编号"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input id="shopname" type="text" value="${repurchase.shopname}" name="shopname" required
					lay-verify="required" placeholder="请输入商品名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品价格</label>
			<div class="layui-input-inline">
				<input id="shopprice" type="text" value="${repurchase.shopprice}" name="shopprice" required
					lay-verify="required" placeholder="请输入商品价格" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style=" margin: 0px auto;">商品数量</label>
			<div class="layui-input-inline">
				<input id="shopnum" type="text" value="${repurchase.shopnum}" name="shopnum"
					required lay-verify="required" placeholder="请输入商品数量"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">进货时间</label>
			<div class="layui-input-inline">
			 <input id="purdate" type="text" value="${repurchase.purdate}" name="purdate" class="layui-input" placeholder="请选择日期" 
			 required lay-verify="required" autocomplete="off" >
				<%-- <input  id="purdate" type="text" value="${repurchase.purdate}" name="purdate"
					required lay-verify="required" placeholder="进货时间"
					autocomplete="off" class="layui-input"> --%>
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">退货原因</label>
			<div class="layui-input-inline">
				<input id="reson" type="text" value="${repurchase.reson}" name="reson" required
					lay-verify="required" placeholder="请输入退货原因" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<input id="mark" type="text" value="${repurchase.mark}" name="mark" required
					lay-verify="required" placeholder="请输入备注" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div id="lab1" class="layui-input-block">
				<button class="layui-btn layui-btn-primary lay-submit lay-filter="formDemo"
					type="button" onclick="sub()">确定</button>
				<button type="button" class="layui-btn layui-btn-primary"
					onclick="back()">
					<a href="${path}/supplierShow">返回</a>
				</button>
				<!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">

layui.use('laydate', function() {//日期控件
	var laydate = layui.laydate;
	//常规用法
	laydate.render({
		elem: '#prodate'
		,trigger: 'click'
		,method:"post"
		,lang:"en"
	});
});


	function sub() {
		alert("更新中")
		$.ajax({
			url : "${path}/updateRepurchase",
			type : "post",
			dataType : "json",
			data : $("#form2").serialize(),
			success : function(result) {
				if (result.type == 1) {
					alert("OK")
					window.parent.location.reload();//刷新父窗体

					var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
					alert("窗体为：" + index)
					parent.layer.close(index);//关闭窗口
				}

			}
		})
	}
	function back() {
		//alert("返回")
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//alert("窗体为：" + index)
		parent.layer.close(index);//关闭窗口
	}
	$(document).ready(function(){
	    $('#cx').click(function(){  //name为标识
	       var $purid = $.trim($("#purid").val());//供应商id
	       
	        var $shopid = $.trim($("#shopid").val());
	        alert("供应商idid为："+$shopid)
	      	var $shopname = $.trim($("#shopname").val());
	        alert("商品名称商idid为："+$shopname)
	    	var $shopprice = $.trim($("#shopprice").val());
	      	var $shopnum = $.trim($("#shopnum").val());
	      	//var $purdate = $.trim($("#purdate").val());
	      	var $supname = $.trim($("#supname").val());
 
	         if($purid == ''){
	        	alert("订单id为"+id)
	            layer.msg('订单号不能为空',function() {time:2000}); 
	            return false;  
	        }
	       /*   else if (!/^(\\d|[1-9]\\d|100|0)$/.test($("#purid").val())) {
	        	alert("订单id是"+$purid)
	        	layer.msg('请输入正确的订单id！',function() {time:2000});
	        	return false; 
			} */
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
	          	layer.msg('输入错误,请输入正确的商品价格,如xx.xx',function() {time:2000});
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
	       
	      /*  if($supname == ''){  
	           layer.msg('请输入供应商名称！',function() {time:2000});
	           return false; 
	       } */
	       
	     alert("更新中")
	   	$.ajax({
	   		url:"${path}/updateSupplie",
	   		type:"post",
	   		dataType:"json",
	   		data:$("#form2").serialize(),
	   		success:function(result){
	   			if (result.type==1) {
	   				//alert("OK")
	   				 window.parent.location.reload();//刷新父窗体
	   				
	   		         var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
	   		         //alert("窗体为："+index)
	   		         parent.layer.close(index);//关闭窗口
	   			}
	   			
	   		}
	   	})
	     
	    });  
	});
	
	
</script>
</html>