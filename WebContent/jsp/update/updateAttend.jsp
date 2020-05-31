<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>更新考勤</title>

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
			style="width: 400px;">
			<label id="lab1" class="layui-form-label">员工ID</label>
			<div class="layui-input-inline">
				<input value="${attend.staffid}" type="text" name="staffid" required
					lay-verify="required" placeholder="请输入员工ID" autocomplete="on"
					class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">员工姓名</label>
			<div class="layui-input-inline">
				<input value="${attend.staffname}" name="staffname" type="text"
					required lay-verify="required" placeholder="请输入员工姓名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">入职时间</label>
			<div class="layui-input-inline">
				<%-- <input type="text" value="${attend.stafftime}" name="stafftime" required
					lay-verify="required" placeholder="请输入考勤时间" autocomplete="off"
					class="layui-input"> --%>
					 <input type="text" class="layui-input" value="${attend.stafftime}" name="stafftime" required id="purdate" name="purdate" required lay-verify="required" autocomplete="off" >
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label"
				style="margin: 0px auto;">出勤次数</label>
			<div class="layui-input-inline">
				<input type="text" value="${attend.attendtime}" name="attendtime"
					required lay-verify="required" placeholder="请输入考勤次数"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label">备注</label>
			<div class="layui-input-inline">
				<input type="text" value="${attend.mark}" name="mark"
					required lay-verify="required" placeholder="请输入备注"
					autocomplete="off" class="layui-input">
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
	</form>
</body>
<script type="text/javascript">

/* layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	}); */
	
layui.use('laydate', function() {//日期控件
	var laydate = layui.laydate;
	//常规用法
	laydate.render({
		elem: '#purdate'
		,trigger: 'click'
		,method:"post"
		,lang:"en"
	});
});
	function sub() {
		//alert("更新中")
		$.ajax({
			url : "${path}/updateAttend",
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