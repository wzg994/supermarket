<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>客户信息界面</title>
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
	<div class="x_title row">
	    <h2>客户信息列表 </h2>
	     <div class="clearfix"></div>
	           </div>
 	<div  style="margin-top:10px;border: 1px blue solid;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">客户名称</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="cusid" name="te1" placeholder="请输入客户名称"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectscustomer()">查询客户信息</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增客户</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>客户编号</th>
			<th>客户姓名</th>
			<th>客户电话</th>
			<th>负责人</th>
			<th>客户地址</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${customersBypages}" var="customer">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${customer.cusid}</td>
				<td>${customer.cusname}</td>
				<td>${customer.custel}</td>
				<td>${customer.person}</td>
				<td>${customer.address}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${customer.cusid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${customer.cusid})">
                   
                 </td>
			</tr>
		</c:forEach>
	</table>

<!-- 分页按钮 -->
<div id="div01" style="width: auto;margin-left: 500px;margin-top:10px ">
   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/customerShow?nowpage=${page}">
            <c:if test="${page==nowPage}">
                 <button class="layui-btn layui-btn-normal layui-btn-sm" style="color: red;">${page}</button>
            </c:if>
            <c:if test="${page!=nowPage}">
                  <button class="layui-btn layui-btn-normal layui-btn-sm">${page}</button>
            </c:if>
        </a>
   </c:forEach>
</div>




<form class="layui-form" action="${path}/addCustomer" id="form1" hidden="hidden" style="margin-top: 20px;text-align:center">
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">客户id</label>
			    <div class="layui-input-inline">
			      <input id="cusid1"  type="text" name="cusid" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">客户名字</label>
			    <div class="layui-input-inline">
			      <input id="cusname" value="${supplier.supname}" name="cusname" type="text" name="password" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">客户电话</label>
			    <div class="layui-input-inline">
			      <input id="custel" type="text" value="${supplier.suptel}" name="custel" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">负责人</label>
			    <div class="layui-input-inline">
			      <input id="person" type="text" value="" name="person" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">地址</label>
			    <div class="layui-input-inline">
			      <input id="address" type="text" value="" name="address" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			 
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="confirm">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary"  ><a href="${path}/customerShow">返回</a></button>
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
function update(cusid) {
	alert("更新商品id为"+cusid);
	//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
	layer.open({
	      type: 2,
	      area: ['600px', '400px'],
	      title:'更新商品信息',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    //return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: "${path}/operationCustomer?operation=2&cusid="+cusid
	    });
}

//删除
function del(cusid) {
	alert("正在删除")
	window.location.href="${path}/operationCustomer?operation=4&cusid="+cusid;
}

function selectscustomer() {//查询信息
	alert("cusid为："+$("#cusid").val())
	var cusid=$("#cusid").val();
	if (cusid=="") {
		alert("查询无效请，请输入供应商id")
	}else{
		alert("查询")
		window.location.href="${path}/operationCustomer?operation=5&cusid="+cusid;
		alert("已经查询")
	}
	
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


$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $cusid = $.trim($("#cusid1").val());//商品id
        alert("商品id为："+$cusid)
        var $cusname = $.trim($("#cusname").val());
        alert("商品名称为："+$cusname)
      	var $custel = $.trim($("#custel").val());
      	var $person = $.trim($("#person").val());
      	var $address = $.trim($("#address").val());
      	
      	 if ($cusid =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*/.test($("#cusid1").val())){
        	alert("商品id为："+$saleid)
        	layer.msg('输入错误，请输入正确的客户id',function() {time:2000});
       		return false;
       }
		
    	if ($cusname =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入客户名字',function() {time:2000});
             return false;
        	}
    	
    	if ($custel =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户电话',function() {time:2000});
           	return false;
     		}else if (!/^1[34578]\d{9}$/.test($("#custel").val())) {
            	alert("电话号码是"+$suptel)
            	layer.msg('请输入正确的电话号码！',function() {time:2000});
            	return false; 
    		} 
		
    	if ($person =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入负责人',function() {time:2000});
             return false;
        	}
    	
    	if ($address =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户地址',function() {time:2000});
           	return false;
     		}
		
    	
    });  
});	

</script>
</html>