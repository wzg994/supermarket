<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改商品</title>

<link href="${path}/res/tools/layui/css/layui.css" type="text/css" rel="stylesheet" />
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
<form class="layui-form"  id="form2"
		style="margin-top: 20px; text-align: center;">
		
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">商品ID</label>
			<div class="layui-input-inline">
				<input id="productid"  value="${product.proid}" type="text" name="proid" required
					lay-verify="required" placeholder="请输入商品ID" autocomplete="on"
					class="layui-input">
			</div> 
		</div> 
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input id="proname" value="${product.pname}" name="proname" type="text"
					required lay-verify="required" placeholder="请输入商品名称"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品价格</label>
			<div class="layui-input-inline">
				<input id="proprice" type="text" value="${product.price}" name="proprice" required
					lay-verify="required" placeholder="请输入商品价格" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style=" margin: 0px auto;">商品数量</label>
			<div class="layui-input-inline">
				<input id="pronum" type="text" value="${product.pronum}" name="pronum"
					required lay-verify="required" placeholder="请输入商品数量"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">进货日期</label>
			<div class="layui-input-inline">
			 <input id="prodate" type="text" value="${product.prodate}" name="prodate" class="layui-input" id="purdate" name="purdate" placeholder="请选择进货日期" required lay-verify="required" autocomplete="off" >
				<%-- <input id="prodate" type="text" value="${product.prodate}" name="prodate"
					required lay-verify="required" placeholder="请输入进货日期"
					autocomplete="off" class="layui-input"> --%>
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">供应商</label>
			<div class="layui-input-inline">
				<input id="supname" type="text"  value="${product.supname}" name="supname" required
					lay-verify="required" placeholder="请输入供应商名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品类别</label>
			<div class="layui-input-inline">
				<%-- <input type="text" value="${product.supname}" name="typename" required
					lay-verify="required" placeholder="请输入商品类别" autocomplete="off"
					class="layui-input"> --%>
					<select id="typename" name="typename"  lay-verify="">
						<option  value="${product.typename}" >${product.typename}</option>
						<c:forEach items="${protype}" var="protype">
						<option  name="typename" >${protype.typename}</option>
						</c:forEach>
						</select> 
			</div>
		</div>
		 <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="button" id="confirm">确认</button>
			     <!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			      <button type="button" class="layui-btn layui-btn-primary"  onclick="back()">返回</a></button>
			    </div>
			  </div>
	</form>

	<%-- <form class="layui-form" id="form2"
		style="margin-top: 20px; text-align: center; ">
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">商品ID</label>
			<div class="layui-input-inline">
				<input value="${product.proid}" type="text" name="proid" required
					lay-verify="required" placeholder="请输入商品ID" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input value="${product.pname}" name="proname" type="text"
					required lay-verify="required" placeholder="请输入商品名称"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品价格</label>
			<div class="layui-input-inline">
				<input type="text" value="${product.price}" name="proprice" required
					lay-verify="required" placeholder="请输入商品价格" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style="margin: 0px auto;">商品数量</label>
			<div class="layui-input-inline">
				<input type="text" value="${product.pronum}" name="pronum"
					required lay-verify="required" placeholder="请输入商品数量"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">进货日期</label>
			<div class="layui-input-inline">
			<input type="text" class="layui-input" value="${product.prodate}" id="prodate" name="prodate" placeholder="请选择进货日期" required lay-verify="required" autocomplete="off" >
				<input type="text" value="${product.prodate}" name="prodate"
					required lay-verify="required" placeholder="请输入进货日期"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">*供应商</label>
			<div class="layui-input-inline">
				<input type="text" value="${product.supname}" name="supname" required
					lay-verify="required" placeholder="请输入供应商名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品类别</label>
			<div class="layui-input-inline">
				<input type="text" value="${product.supname}" name="typename" required
					lay-verify="required" placeholder="请输入商品类别" autocomplete="off"
					class="layui-input">
					<select id="typename" name="typename"  lay-verify="">
						<option  value="" >${product.typename}</option>
						<c:forEach items="${protype}" var="protype">
						<option  name="typename" >${protype.typename}</option>
						</c:forEach>
						</select> 
			</div>
		</div>
		<div class="layui-form-item" >
			<div id="lab1" class="layui-input-block">
				<button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo"
					type="button" onclick="sub()">确定</button>
				<button type="button" class="layui-btn layui-btn-primary"
					onclick="back()">
					<a href="${path}/supplierShow">返回</a>
				</button>
				<!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			</div>
		</div>
	</form> --%>
	
	
</body>
<script type="text/javascript">


layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});
	
	
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


	/* function sub() {
		//alert("更新中")
		$.ajax({
			url : "${path}/updateProduct",
			type : "post",
			dataType : "json",
			data : $("#form2").serialize(),
			success : function(result) {
				if (result.type == 1) {
					alert("OK")
					window.parent.location.reload();//刷新父窗体

					var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
					//alert("窗体为：" + index)
					parent.layer.close(index);//关闭窗口
				}

			}
		})
	} */
	function back() {
		//alert("返回")
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//alert("窗体为：" + index)
		parent.layer.close(index);//关闭窗口
	}
	$(document).ready(function(){
	    $('#confirm').click(function(){  //name为标识
	        var $proid = $.trim($("#productid").val());//商品id
	       // alert("商品id为："+$proid)
	        var $proname = $.trim($("#proname").val());
	       // alert("商品名称为："+$proname)
	      	var $proprice = $.trim($("#proprice").val());
	      	var $pronum = $.trim($("#pronum").val());
	      	var $prodate = $.trim($("#prodate").val());
	      	var $supname = $.trim($("#supname").val());
	      	var $typename = $.trim($("#typename").val());

	    /*   	if ($proid ==''&&$proname =='') {
	      		alert("您还未输入商品id,请输入商品id")
	          	layer.msg('您还未输入商品id,请输入商品名称',function() {time:2000});
	          	return false;
			} */
	      	
	      	 if ($proid =='') {
	           //	alert("您还未输入商品id,请输入商品id")
	           	layer.msg('请输入商品id',function() {time:2000});
	           	return false;
	     		}else if(!/^[1-9]\d*/.test($("#productid").val())){
	        	//alert("商品id为："+$proid)
	        	layer.msg('输入错误，请输入正确的商品id',function() {time:2000});
	       		return false;
	       }
	      	if ($proname =='') {
	          	//alert("您还未输入商品id,请输入商品id")
	          	layer.msg('请输入商品名称',function() {time:2000});
	          	return false;
	    		} 
	      	/* else{
	       	alert("请输入正确商品id"+$proid)
	       	
	       	return false;
			}  */
	       
			if ($proprice =='') {
	          	//alert("您还未输入商品id,请输入商品id")
	          	layer.msg('请输入商品价格',function() {time:2000});
	          	return false;
	    		}else if (!/[1-9]\d*.\d\d|0\.\d\d/.test($("#proprice").val())) {
	    			alert("您还未输入商品id,请输入商品价格"+$proprice)
	              	layer.msg('输入错误,请输入正确的商品价格,如xx.xx',function() {time:2000});
	              	return false;
				}
			
			if ($pronum =='') {
	          	//alert("您还未输入商品,请输入商品数量")
	          	layer.msg('请输入商品数量',function() {time:2000});
	          	return false;
	    		}else if (!/^([1-9]|[1-9]\d|[1-9]\d\d|1000)$/.test($("#pronum").val())) {
	    			//alert("您输入商品数量11为"+$pronum)
	              	layer.msg('商品数量输入错误,输入范围为1-1000,请重新输入',function() {time:2000});
	              	return false;
				}
			
			/* if ($prodate =='') {
	          	alert("您还未输入商品id,请输入商品id")
	          	layer.msg('请输入生产日期',function() {time:2000});
	          	return false;
	    		} */
			
			if ($supname =='') {
	          	//alert("您还未输入商品id,请输入商品id")
	          	layer.msg('请输入供应商名称',function() {time:2000});
	          	return false;
	    		}
	    		
	    	if ($typename =='') {
	            // alert("您还未输入商品类型,请输入商品id")
	             layer.msg('您还未选择商品类型，请选择',function() {time:2000});
	             return false;
	        	}
	    	
	    	//alert("更新中")
			$.ajax({
				url : "${path}/updateProduct",
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