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
	height: 200px;
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
	left: 25%;
}
</style>
</head>
<body style="">
<fieldset class="layui-elem-field">
	<form class="layui-form" id="form2"
		style="margin-top: 20px; text-align: center; ">
		扫描二维码查看商品信息<br />
		<hr>
		<div  class="layui-form-item"
			style="width: 200px;margin: 0 auto;margin-top: 20px;">

<img src="${path}/res/imgs/${qrcode}.jpg"  width="100px" height="100px"></img>


</div>
<hr>
		<div class="layui-form-item" style="width: 100%;margin-top: 20px;">
			<div  class="layui-input-block" style="margin: 0 auto;">
				
				<button type="button" class="layui-btn layui-btn-normal"
					onclick="back()">
					返回
				</button>
				<!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			</div>
		</div>
	</form>
	</fieldset>
</body>
<script type="text/javascript">
	
	function back() {
		//alert("返回")
		window.parent.location.reload();//刷新父窗体

		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//alert("窗体为：" + index)
		parent.layer.close(index);//关闭窗口
	}
</script>
</html>