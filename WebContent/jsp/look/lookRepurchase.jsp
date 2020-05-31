<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>退货查询界面</title>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>


<%-- <script src="${path}/res/tools/layui/lay/modules/layer.js"></script> --%>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<%-- <link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/> --%>
<script type="text/javascript"  src="${path}/res/tools/layui/layui.js"></script>
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
<fieldset class="layui-elem-field">
<!-- <div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">退货信息查询界面 </h2>
	     <div class="clearfix"></div>
	</div> -->
	<h1 style="margin-bottom:10px;text-align: center;">查询员工考勤信息</h1>

<table class="layui-table">

		<tr>
			<th>退货编号</th>
			<th>订单编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>进货日期</th>
			<th>供应商</th>
			<th>退货原因</th>
			<th>操作</th>
		</tr>

		<c:set var="totalPrice"  value="0"></c:set>

		<c:forEach items="${repurchase}" var="repurchase">
			<tr>
				<td>${repurchase.repurid}</td>
				<td>${repurchase.purid}</td>
				<td>${repurchase.shopid}</td>
				<td>${repurchase.shopname}</td>
				<td>${repurchase.shopnum}</td>
				<td>${repurchase.purdate}</td>
				<td>${repurchase.reson}</td>
				<td>${repurchase.mark}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${repurchase.purid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${repurchase.purid})">
                   
                 </td>
			</tr>
		</c:forEach>
	</table>

<!-- 分页按钮 -->
<div id="div01" style="width: auto;margin-left: 500px;margin-top:10px ">
   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/supplierShow?nowpage=${page}">
            <c:if test="${page==nowPage}">
                 <button class="layui-btn layui-btn-normal layui-btn-sm" style="color: red;">${page}</button>
            </c:if>
            <c:if test="${page!=nowPage}">
                  <button class="layui-btn layui-btn-normal layui-btn-sm">${page}</button>
            </c:if>
        </a>
   </c:forEach>
</div>
<c:if test="${not empty repurchasemsg}">
<span style="color: red;">${repurchasemsg}</span>

</c:if>	

<div  class="layui-form-item" >
			    <div  id="lab1" class="layui-input-block" style="float: right;margin-right: 135px;" >
			      <button  type="button" class="layui-btn layui-btn-normal" ><a href="${path}/repurchaseShow" target="frame1">返回</a></button>
			    </div>
			  </div>
</fieldset>

</body>


<script type="text/javascript">
/* ;!function(){
	  //无需再执行layui.use()方法加载模块，直接使用即可
	  var form = layui.form
	  ,layer = layui.layer;
	  
	  //…
	}(); */

layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	   
	});

	//修改
	function update(shopId,obj) {
		//alert("更新");
		window.location.href="${path}/operationSupplier?operation=1&operationSupplier="+supplierId+"&newNumber="+obj.val();
		layer.open({
		      type: 1,
		      area: ['600px', '400px'],
		      title:'更新供应商',
		     // skin: 'demo-class',
		      offset: 'auto',//坐标水平居中	
		      btnAlign: 'c',//按钮对齐方式
		      closeBtn: 2//关闭按钮
		      ,anim: 1  
		      ,resize:false//固定大小
		      //,btn: ['确定', '取消', '返回']
		    	,yes: function(index, layero){
		        //按钮【按钮一】的回调
		        alert("按钮一");
		      }
		      ,cancel: function(){ 
		    	    //右上角关闭回调
		    	    //return false //开启该代码可禁止点击该按钮关闭
		    	  }
		      ,shadeClose: true, //点击遮罩关闭
		      content: $('#form2')
		    });
	}
	//删除
	function del(purid) {
		//alert("正在删除")
		//alert("退货id为"+purid)
		window.location.href="${path}/operationRepurchase?operation=4&purid="+purid;
		//alert("运行结束")
	}
	


</script>
</html>