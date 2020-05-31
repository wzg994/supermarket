<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进货信息界面</title>

<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>


<%-- <script src="${path}/res/tools/layui/lay/modules/layer.js"></script> --%>
<%-- <link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/> --%>
<%-- <link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/> --%>
<%-- <script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script> --%>

<link rel="stylesheet" href="${path}/res/tools/layui/css/layui.css"  type="text/css"  media="all" />
<%-- <script type="text/javascript"  src="${path}/res/jquery/jquery-3.4.1.js" charset="utf-8"></script> --%>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js" charset="utf-8"></script>
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
	<h2 style="margin-bottom:10px;text-align: center;">进货信息列表 </h2>
	     <div class="clearfix"></div>
	     
	</div>
	<hr>
 	<div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">商品名称</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="sepurid" name="supid" placeholder="请输入进货的商品名称"  class="layui-input" >
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectshop()">查询货物</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >进货</button>
	 			</div>
		</div>				 
	 </div> 

<table class="layui-table">

		<tr>
			<th>订单编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>进货日期</th>
			<th>供应商</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${purchasesBypage}" var="purchase">
			<c:set var="totalPrice"   value="${sale.shopprice*sale.shopnum}"></c:set>
			<tr>
				<td>${purchase.purid}</td>
				<td>${purchase.shopid}</td>
				<td>${purchase.shopname}</td>
				<td>${purchase.shopprice}</td>
				<td>${purchase.shopnum}</td>
				<td>${purchase.purdate}</td>
				<td>${purchase.supname}</td>
				<td>
				<input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${purchase.purid})">
				<input type="button" class="layui-btn layui-btn-sm" value="退单"  onclick="del(${purchase.purid})">
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
        <a href="${path}/purchaseShow?nowpage=${page}">
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

<form class="layui-form" action="${path}/addPurchase" id="form1" hidden="hidden" style="margin-top: 20px;text-align:center;width: 400px;">
			 <!--  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">订单编号</label>
			    <div class="layui-input-inline">
			      <input id="purid"  type="text" name="purid" required  lay-verify="required" placeholder="请输入订单编号" autocomplete="on" class="layui-input">
			    </div>
			  </div> -->
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品ID</label>
			    <div class="layui-input-inline">
			      <input id="shopid" value="${purchase.shopid}" name="shopid" type="text"  required lay-verify="required" placeholder="请输入商品ID" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品名称</label>
			    <div class="layui-input-inline">
			      <input id="shopname" type="text" value="${purchase.shopname}" name="shopname" required lay-verify="required" placeholder="请输入商品名称" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品价格</label>
			    <div class="layui-input-inline">
			      <input id="shopprice" type="text" value="${purchase.shopprice}" name="shopprice" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品数量</label>
			    <div class="layui-input-inline">
			      <input id="shopnum" type="text" value="${purchase.shopnum}" name="shopnum" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">进货日期</label>
			    <div  class="layui-input-inline">
			    <input type="text" class="layui-input" id="purdate" name="purdate" placeholder="请选择进货日期" required lay-verify="required" autocomplete="off" >
			      <%-- <input id="purdate"type="text" value="${purchase.purdate}" name="purdate" required lay-verify="required" placeholder="请输入进货日期" autocomplete="off" class="layui-input"> --%>
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">供应商</label>
			    <div class="layui-input-inline">
			      <input id="supname" type="text"  name="supname" required lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="cx">确定</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary" ><a href="${path}/purchaseShow">返回</a></button>
			    </div>
			  </div>
			</form>
			

</body>


<script type="text/javascript">


layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});


function selectshop() {//查询信息
	//alert("purid为："+$("#sepurid").val())
	var purid=$("#sepurid").val();
	if (purid=="") {
		alert("查询无效，请输入商品名称")
	}else{
		//alert("查询")
		window.location.href="${path}/operationPurchase?operation=3&shopname="+purid;
	}
	
}

//修改
function update(purid) {
	//alert("更新purid"+purid);
	//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
	layer.open({
	      type: 2,
	      area: ['600px', '500px'],
	      title:'更新进货信息',
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
	      content: "${path}/operationPurchase?operation=2&purid="+purid
	    });
}
//删除
function del(purid) {//退单
	//alert("正在退单")
	window.location.href="${path}/operationPurchase?operation=1&purid="+purid;
}



function addshop() {
	layer.open({
	      type: 1,
	      area: ['580px', '450px'],
	      title:'进货界面',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,method:"post"
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

$(document).ready(function(){
    $('#cx').click(function(){  //name为标识
       // var $purid = $.trim($("#purid").val());//供应商id
       
        var $shopid = $.trim($("#shopid").val());
        //alert("供应商idid为："+$shopid)
      	var $shopname = $.trim($("#shopname").val());
        //alert("商品名称商idid为："+$shopname)
    	var $shopprice = $.trim($("#shopprice").val());
      	var $shopnum = $.trim($("#shopnum").val());
      	//var $purdate = $.trim($("#purdate").val());
      	var $supname = $.trim($("#supname").val());
/* 
         if(purid == ''){
        	alert("订单id为"+id)
            layer.msg('商品单号不能为空',function() {time:2000}); 
            return false;  
        }  */
       /*   else if (!/^(\\d|[1-9]\\d|100|0)$/.test($("#purid").val())) {
        	alert("订单id是"+$purid)
        	layer.msg('请输入正确的订单id！',function() {time:2000});
        	return false; 
		} */
         if($shopid == ''){
         	//alert("商品id为"+$shopid)
            layer.msg('请输入商品ID',function() {time:2000}); 
             return false;  
         } 
        /*  else if (!/^[0-9]?[0-9]?$|100/.test($("#shopid").val())) {
         	//alert("商品ID是"+$shopid)
         	layer.msg('请输入正确的商品ID！',function() {time:2000});
         	return false; 
 		} */
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
       
       if($supname == ''){  
           layer.msg('请输入供应商名称！',function() {time:2000});
           return false; 
       }
       
      /* if($suptel == ''){  
            layer.msg('请输入电话号码！',function() {time:2000});
            return false; 
        }else if (!/^1[34578]\d{9}$/.test($("#suptel").val())) {
        	alert("电话号码是"+$suptel)
        	layer.msg('请输入正确的电话号码！',function() {time:2000});
        	return false; 
		} */
     /*  if($person == ''){  
          layer.msg('请输入负责人！',function() {time:2000});
          alert("负责人是"+$person)
          return false; 
      }
      if($address == ''){  
          layer.msg('请输入供应商地址！',function() {time:2000});
          return false; 
      } */
     
    });  
});
</script>
</html>