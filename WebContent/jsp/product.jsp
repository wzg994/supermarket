<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>产品信息页面</title>

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
	<h2 style="margin-bottom:10px;text-align: center;">商品信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
 	<div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">商品名称</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="proid"  placeholder="请输入商品名称"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectshop()">查询商品</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增商品</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>商品id</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>商品日期</th>
			<th>供应商</th>
			<th>商品类别</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${shopsBypage}" var="shop">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${shop.proid}</td>
				<td>${shop.pname}</td>
				<td>${shop.price}</td>
				<td>${shop.pronum}</td>
				<td>${shop.prodate}</td>
				<th>${shop.supname}</th>
				<th>${shop.typename}</th>
                 <td>
            		 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${shop.proid})">
            		 <input type="button" class="layui-btn layui-btn-sm" value="查看"  onclick="look(${shop.proid})">
                  	 <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${shop.proid})">
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
        <a href="${path}/productshow?nowpage=${page}">
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

	<form class="layui-form" action="${path}/addProduct" id="form1" hidden="hidden"
		style="margin-top: 20px; text-align: center;">
		
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label">商品ID</label>
			<div class="layui-input-inline">
				<input id="productid"  type="text" name="proid" required
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
				<input id="supname" type="text" value="" name="supname" required
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
						<option  value="" >请选择商品类别</option>
						<c:forEach items="${protype}" var="protype">
						<option  name="typename" >${protype.typename}</option>
						</c:forEach>
						</select> 
			</div>
		</div>
		 <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="confirm">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary"  ><a href="${path}/productshow">返回</a></button>
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
	//alert("purid为："+$("#proid").val())
	var shopname=$("#proid").val();
	if (shopname=="") {
		alert("查询无效请，请输入商品名称")
	}else{
		//alert("查询")
		window.location.href="${path}/operationProduct?operation=5&shopname="+shopname;
		//alert("已经查询")
	}
	
}


//修改
function update(proid) {
	//alert("更新商品id为"+proid);
	//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
	layer.open({
	      type: 2,
	      area: ['600px', '500px'],
	      title:'更新商品信息',
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
	      content: "${path}/operationProduct?operation=2&proid="+proid
	    });
}
//删除
function del(proid) {
	window.location.href="${path}/operationProduct?operation=4&proid="+proid;
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'新增商品',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
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

function look(proid) {
	//alert("要查看的商品id"+proid)
	layer.open({
		type: 2,
	      area: ['520px', '520px'],
	      title:'商品信息二维码',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	      ,scrollbar:false//滚动条
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    //return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: ["${path}/LookServlet?proid="+proid,"no"]
	    });
	

} 

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

/* function selectshop() {
	$.ajax({
		url:"${path}/updateSupplier",
		type:"get",
		dataType:"json",
		data:$("#text1").serialize(),
		success:function(result){
			if (result.type==1) {
				alert("OK")
				 window.parent.location.reload();
		         var index = parent.layer.getFrameIndex(window.name);
		         parent.layer.close(index);
			}
			
		}
	})
} */

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
      /*  
       if(!/[A-Za-z0-9_\-\u4e00-\u9fa5]+ /.test($("#proname").val())){
        	alert("正确商品id为"+$proname)
       	return true;
       }else {
       	alert("请输入正确商品id")
       	layer.msg('输入错误，请输入正确的商品名称',function() {time:2000});
       	return false;
		} 
       
       if(!/[1-9]\d*.\d*|0\.\d*[1-9]\d*/
     
       /*   else if (!/^(\\d|[1-9]\\d|100|0)$/.test($("#purid").val())) {
        	alert("订单id是"+$purid)
        	layer.msg('请输入正确的订单id！',function() {time:2000});
        	return false; 
		} */
		
        /*  if(shopid == ^\-?[0-9]+$){
         	alert("商品id为"+$shopid)
             layer.msg('商品单号不能为空',function() {time:2000}); 
             return false;  
         } else if (!/^[0-9]?[0-9]?$|100/.test($("#shopid").val())) {
         	alert("商品ID是"+$shopid)
         	layer.msg('请输入正确的商品ID！',function() {time:2000});
         	return false; 
 		}
       if($shopname == ^\-?[0-9]*\.?[0-9]*$){ //所有的数字 小数 
            layer.msg('请输入商品名称！',function() {time:2000});
            return false; 
        } */
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