<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>考勤信息页面</title>

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
<c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}</span>
</c:if>
<fieldset class="layui-elem-field">
<div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">员工考勤信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
 	<div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">员工ID</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="staffid"  placeholder="请输入员工ID"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectshop()">查询商品</button>
			 	</div>		   
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>员工ID</th>
			<th>员工姓名</th>
			<th>入职时间</th>
			<th>出勤次数</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${attendsBypage}" var="attend">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${attend.staffid}</td>
				<td>${attend.staffname}</td>
				<td>${attend.stafftime}</td>
				<td>${attend.attendtime}</td>
				<td>${attend.mark}</td>
                 <td>
            		 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${attend.staffid})">
                  	 <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${attend.staffid})">
                  </td>
			</tr>
		</c:forEach>
	</table>

<div>
	<!--分页文字信息  -->
	<div style="width: auto;float: left;display: inline-block;margin-top: 2px;">当前 ${nowPage}页,总 ${allpage}页,共${totalsize}条记录</div>
	<!-- 分页按钮 -->
<div style="width: auto;margin-left: 500px;display: inline-block;">

   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/attendShow?nowpage=${page}">
            <c:if test="${page==nowPage}">
                 <button class="layui-btn layui-btn-normal layui-btn-sm" style="color: red;">${page}</button>
            </c:if>
            <c:if test="${page!=nowPage}">
                  <button class="layui-btn layui-btn-normal layui-btn-sm">${page}</button>
            </c:if>
        </a>
   </c:forEach>
</div>
</div>
	
</fieldset>

</body>

<script type="text/javascript">


layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});


function selectshop() {//查询信息
	var staffid=$("#staffid").val();
	if (staffid=="") {
		alert("查询无效请，请输入供应商id")
	}else{
		window.location.href="${path}/operationAttend?operation=5&staffid="+staffid;
	}
}


//修改
function update(staffid) {
	layer.open({
	      type: 2,
	      area: ['600px', '500px'],
	      title:'修改员工考勤信息',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 0//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    //return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: "${path}/operationAttend?operation=2&staffid="+staffid
	    });
}
//删除
function del(staffid) {
	window.location.href="${path}/operationAttend?operation=4&staffid="+staffid;
}

</script>

</html>