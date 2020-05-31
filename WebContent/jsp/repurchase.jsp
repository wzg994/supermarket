<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>退货信息界面</title>
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

</style>
</head>
<body>

<c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}</span>
</c:if>
<fieldset class="layui-elem-field">
 	<div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">退货信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
	<!-- 查询退货订单 -->
	 	<div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">退货订单</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="repurid" name="supid" placeholder="请输入退货商品名称"  class="layui-input" >
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectshop()">查询退货订单</button>
			 	</div>		   
			
		</div>				 
	 </div> 

<table class="layui-table">

		<tr>
			<th>退货编号</th>
			<th>订单编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>进货时间</th>
			<!-- <th>退货时间</th> -->
			<th>供应商</th>
			<th>退货原因</th>
			
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${repurchasesByPage}" var="repurchase">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${repurchase.repurid}</td>
				<td>${repurchase.purid}</td>
				<td>${repurchase.shopid}</td>
				<td>${repurchase.shopname}</td>
				<td>${repurchase.shopprice}</td>
				<td>${repurchase.shopnum}</td>
				<td>${repurchase.purdate}</td>
				<%-- <td>${repurchase.redate}</td> --%>
				<td>${repurchase.mark}</td>
				<td>${repurchase.reson}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${repurchase.repurid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${repurchase.repurid})">
                   
                 </td>
			</tr>
		</c:forEach>
	</table>

<div style="">
	<!--分页文字信息  -->
	<div style="width: auto;float: left;display: inline-block;margin-top: 2px;">当前 ${nowPage}页,总 ${allpage}页,共${totalsize}条记录</div>
	<!-- 分页按钮 -->
<div style="width: auto;margin-left: 500px;display: inline-block;">

   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/repurchaseShow?nowpage=${page}">
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




<form class="layui-form"  id="form1" hidden="hidden" style="margin-top: 20px;text-align:center">
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商编号</label>
			    <div class="layui-input-inline">
			      <input value="${supplier.supid}" type="text" name="supid" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商名字</label>
			    <div class="layui-input-inline">
			      <input id="num" value="${supplier.supname}" name="supname" type="text" name="password" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商电话</label>
			    <div class="layui-input-inline">
			      <input type="text" value="${supplier.suptel}" name="suptel" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">负责人</label>
			    <div class="layui-input-inline">
			      <input type="text" value="" name="supperson" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			 
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
			</form>
			
			<form class="layui-form" action="${path}/updateSupplier" id="form2" hidden="hidden" style="margin-top: 20px;text-align:center">
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商编号</label>
			    <div class="layui-input-inline">
			      <input value="${supplier.supid}" type="text" name="supid" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商名字</label>
			    <div class="layui-input-inline">
			      <input id="num" value="${supplier.supname}" name="supname" type="text" name="password" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">供应商电话</label>
			    <div class="layui-input-inline">
			      <input type="text" value="${supplier.suptel}" name="suptel" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div class="layui-form-item">
			    <label class="layui-form-label">负责人</label>
			    <div class="layui-input-inline">
			      <input type="text" value="" name="supperson" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			 
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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

layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});



//修改
function update(repurid) {
	//alert("更新repurid"+repurid);
	//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
	layer.open({
	      type: 2,
	      area: ['600px', '480px'],
	      title:'更新退货信息',
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
	      content: "${path}/operationRepurchase?operation=2&repurid="+repurid
	    });
}
//删除
function del(repurid) {
	//alert("正在删除")
	//alert("退货id为"+repurid)
	window.location.href="${path}/operationRepurchase?operation=1&repurid="+repurid;
	//alert("运行结束")
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'新增商品',
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
	      content: $('#form1')
	    });
	

} 

function selectshop() {//查询信息
	//alert("repurid为："+$("#repurid").val())
	var repurid=$("#repurid").val();
	if (repurid=="") {
		alert("查询无效，请输入商品名称")
	}else{
		//alert("查询")
		window.location.href="${path}/operationRepurchase?operation=4&shopname="+repurid;
	}
	
}

</script>
</html>