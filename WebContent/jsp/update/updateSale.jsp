<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>更新商品类别信息</title>

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
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">销售编号</label>
			<div class="layui-input-inline">
				<input value="${sale.saleid}" type="text" name="saleid" required
					lay-verify="required" placeholder="请输入销售编号" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品编号</label>
			<div class="layui-input-inline">
				<input value="${sale.saleid}" name="shopid" type="text"
					required lay-verify="required" placeholder="请输入商品编号"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">商品名称</label>
			<div class="layui-input-inline">
				<input value="${sale.shopname}" type="text" name="shopname" required
					lay-verify="required" placeholder="请输入商品名称" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">商品价格</label>
			<div class="layui-input-inline">
				<input value="${sale.shopprice}" name="shopprice" type="text"
					required lay-verify="required" placeholder="请输入商品价格"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">商品数量</label>
			<div class="layui-input-inline">
				<input value="${sale.shopnum}" type="text" name="shopnum" required
					lay-verify="required" placeholder="请输入商品数量" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item"
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">销售总价</label>
			<div class="layui-input-inline">
				<input value="${sale.totalprice}" type="text" name="totalprice" required
					lay-verify="required" placeholder="请输入销售总价" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">销售日期</label>
			<div class="layui-input-inline">
				 <input id="saledate" type="text" value="${sale.saledate}" name="saledate" class="layui-input"  placeholder="请选择销售日期" required lay-verify="required" autocomplete="off" >
				
				<%-- <input value="${sale.saledate}" name="saledate" type="text"
					required lay-verify="required" placeholder="请输入销售日期"
					autocomplete="off" class="layui-input"> --%>
			</div>
		</div>
<%-- 		<div id="divf" class="layui-form-item"
			style="border: 1px blue solid; width: 400px;">
			<label id="lab1" class="layui-form-label">客户id</label>
			<div class="layui-input-inline">
				<input value="${sale.cusid}" type="text" name="cusid" required
					lay-verify="required" placeholder="请输入销售编号" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">客户姓名</label>
			<div class="layui-input-inline">
				<input value="${sale.cusname}" name="cusname" type="text"
					required lay-verify="required" placeholder="请输入商品编号"
					autocomplete="off" class="layui-input">
			</div>
		</div> --%>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<input value="${sale.mark}" name="mark" type="text"
					required lay-verify="required" placeholder="请输入商品编号"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item" >
			<div id="lab1" class="layui-input-block">
				<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo"
					type="button" onclick="sub()">确定</button>
				<button type="button" class="layui-btn layui-btn-normal"
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
		elem: '#saledate'
		,trigger: 'click'
		,method:"post"
		,lang:"en"
	});
});


	function sub() {
		//alert("更新中")
		$.ajax({
			url : "${path}/updateSale",
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
	}
	function back() {
		//alert("返回")
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//alert("窗体为：" + index)
		parent.layer.close(index);//关闭窗口
	}
</script>
</html>