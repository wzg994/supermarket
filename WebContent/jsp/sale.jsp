<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>销售信息界面</title>
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
#divf {
	position: relative;
	margin: 0 auto;
	margin-top: 10px;
}

#lab1 {
	display: inline-block;
	margin-left: 120px;
}

</style>
</head>
<body>
<c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}</span>
</c:if>
<fieldset class="layui-elem-field">
<div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">销售信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
 <div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;width: 100px;">销售商品信息</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="saleid" placeholder="请输入销售商品名称"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectsale()">查询销售商品</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增销售商品</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>销售编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>销售总价</th>
			<th>销售日期</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${saleBypage}" var="sale">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${sale.shopprice*sale.shopnum}"></c:set>
			<tr>
				<td>${sale.saleid}</td>
				<td>${sale.shopid}</td>
				<td>${sale.shopname}</td>
				<td>${sale.shopprice}</td>
				<td>${sale.shopnum}</td>
				<td>${totalPrice}</td>
				<td>${sale.saledate}</td>
				<td>${sale.mark}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${sale.saleid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${sale.saleid})">
                   
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
        <a href="${path}/saleShow?nowpage=${page}">
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




<form class="layui-form" action="addSale" id="form1" hidden="hidden" style="margin: 0 auto;">
			  <div id="divf" class="layui-form-item" >
			    <label id="lab1" class="layui-form-label" style="">销售编号</label>
			    <div class="layui-input-inline" style="margin: 0 auto;">
			      <input id="saleid1" type="text"  name="saleid" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品编号</label>
			    <div class="layui-input-inline">
			      <input id="shopid" name="shopid" type="text" name="password" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品名称</label>
			    <div class="layui-input-inline">
			      <input id="shopname" type="text" name="shopname" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			 <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品价格</label>
			    <div class="layui-input-inline">
			      <input id="shopprice" type="text" name="shopprice" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">商品数量</label>
			    <div class="layui-input-inline">
			      <input id="shopnum" type="text" name="shopnum" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">销售总价</label>
			    <div class="layui-input-inline">
			      <input id="totalprice" type="text" name="totalprice" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">销售日期</label>
			    <div class="layui-input-inline">
			    <input id="saledate" type="text" value="${product.prodate}" name="saledate" class="layui-input"  placeholder="请选择销售日期" required lay-verify="required" autocomplete="off" >
			      <!-- <input id="saledate" type="text" name="saledate" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    --> 
			    </div>
			  </div>
			 
			  <div id="divf" class="layui-form-item">
			    <label id="lab1" class="layui-form-label">备注</label>
			    <div class="layui-input-inline">
			      <input id="mark" type="text" name="mark" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  
			  <div id="divf" class="layui-form-item">
			    <div class="layui-input-block" style="margin-left:180px;">
			      <button class="layui-btn layui-btn-primary"  lay-submit lay-filter="formDemo" type="submit" id="confirm">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary"  ><a href="${path}/saleShow">返回</a></button>
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

//修改
function update(saleid) {
	//alert("更新商品类别id为"+saleid);
	layer.open({
	      type: 2,
	      area: ['600px', '400px'],
	      title:'更新商品销售信息',
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
	      content: "${path}/operationSale?operation=2&saleid="+saleid
	    });
	//alert("更新执行完毕")
	}
//删除
function del(saleid) {
	window.location.href="${path}/operationSale?operation=4&saleid="+saleid;
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '450px'],
	      title:'新增销售信息',
	     // skin: 'demo-class',
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

function selectsale() {//查询信息
	//alert("saleid为："+$("#saleid").val())
	var saleid=$("#saleid").val();
	if (saleid=="") {
		alert("查询无效，请输入供应商id")
	}else{
		//alert("查询")
		window.location.href="${path}/operationSale?operation=5&saleid="+saleid;
		//alert("已经查询")
	}
	
}


$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $saleid = $.trim($("#saleid1").val());//商品id
        //alert("商品id为："+$saleid)
        var $shopid = $.trim($("#shopid").val());
        //alert("商品名称为："+$shopid)
      	var $shopname = $.trim($("#shopname").val());
      	var $shopprice = $.trim($("#shopprice").val());
      	var $shopnum = $.trim($("#shopnum").val());
      	var $totalprice = $.trim($("#totalprice").val());
      	var $saledate = $.trim($("#saledate").val());
    	/* var $cusid = $.trim($("#cusid").val());
      	var $cusname = $.trim($("#cusname").val()); */
      	var $mark = $.trim($("#mark").val());
      	
      	 if ($saleid =='') {
           //	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入销售id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*/.test($("#saleid1").val())){
        	//alert("商品id为："+$saleid)
        	layer.msg('输入错误，请输入正确的销售id',function() {time:2000});
       		return false;
       }
		
    	if ($shopid =='') {
            // alert("您还未输入商品类型,请输入商品id")
             layer.msg('您还未输入商品id，请输入',function() {time:2000});
             return false;
        	}else if(!/^[1-9]\d*/.test($("#shopid").val())){
            	//alert("商品id为："+$shopid)
            	layer.msg('输入错误，请输入正确的商品id',function() {time:2000});
           		return false;
           }
    	
    	if ($shopname =='') {
           	//alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入商品名称',function() {time:2000});
           	return false;
     		}
		
    	if ($shopprice =='') {
            // alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入商品价格',function() {time:2000});
             return false;
        	}else if (!/[1-9]\d*.\d\d|0\.\d\d/.test($("#shopprice").val())) {
    			//alert("您还未输入商品id,请输入商品价格"+$shopprice)
              	layer.msg('输入错误,请输入正确的商品价格,如xx.xx',function() {time:2000});
              	return false;
			}
    	
    	if ($shopnum =='') {
           //	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入商品数量',function() {time:2000});
           	return false;
     		}else if (!/^([1-9]|[1-9]\d|[1-9]\d\d|1000)$/.test($("#shopnum").val())) {
    			//alert("您输入商品数量11为"+$shopnum)
              	layer.msg('商品数量输入错误,输入范围为1-1000,请重新输入',function() {time:2000});
              	return false;
			}
		
    	if ($totalprice =='') {
            //alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入总价',function() {time:2000});
             return false;
        	}else if($totalprice ==($shopprice*$shopnum)){
        		//alert("总价错误"+totalprice)
                layer.msg('您还未输入商品类型，请输入'+($shopprice*$shopnum),function() {time:2000});
                return false;
        	}
    	
    	
    	if ($saledate =='') {
           //	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入销售日期',function() {time:2000});
           	return false;
     		}
		
    	/* if ($cusid =='') {
             //alert("您还未输入商品类型,请输入商品id")
             layer.msg('您还未输入客户id，请输入',function() {time:2000});
             return false;
        	}
    	if ($cusname =='') {
           	//alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户名称',function() {time:2000});
           	return false;
     		} */
		
    	if ($mark =='') {
            // alert("您还未输入商品类型,请输入商品id")
             layer.msg('您还未输入商品类型，请输入',function() {time:2000});
             return false;
        	} 
    });  
});	
</script>
</html>