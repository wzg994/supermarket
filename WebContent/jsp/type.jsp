<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品类别界面</title>
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
	<h2 style="margin-bottom:10px;text-align: center;">商品类别信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
 <div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">商品类别</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="typeid" placeholder="请输入员工名称"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selecttype()">查询商品类别</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增商品类别</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>商品类别编号</th>
			<th>商品类别名称</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${typesBypage}" var="staff">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${staff.typeid}</td>
				<td>${staff.typename}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${staff.typeid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${staff.typeid})">
                   
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
        <a href="${path}/typeShow?nowpage=${page}">
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



<form class="layui-form" action="${path}/addType" id="form1" hidden="hidden"
		style="margin-top: 20px; text-align: center;">
		<div id="divf" class="layui-form-item"
			style=" width: 400px;">
			<label id="lab1" class="layui-form-label" style="width: 100px;">商品类别编号</label>
			<div class="layui-input-inline">
				<input id="typeid1" value="" type="text" name="typeid" required
					lay-verify="required" placeholder="请输入商品类别ID" autocomplete="on"
					class="layui-input">
			</div>
		</div> 
		<div id="divf" class="layui-form-item" style="width: 400px">
			<label id="lab1" class="layui-form-label" style="width: 100px;">商品类别名称</label>
			<div class="layui-input-inline">
				<input id="typename" value="" name="typename" type="text"
					required lay-verify="required" placeholder="请输入商品类别名称"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		

		 <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="confirm">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary"  ><a href="${path}/typeShow">返回</a></button>
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
function update(typeid) {
	//alert("更新商品类别id为"+typeid);
	layer.open({
	      type: 2,
	      area: ['600px', '400px'],
	      title:'修改商品类别信息',
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
	      content: "${path}/operationType?operation=2&typeid="+typeid
	    });
	//alert("更新执行完毕")
	}
//删除
function del(typeid) {
	window.location.href="${path}/operationType?operation=4&typeid="+typeid;
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'新增商品类别',
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

function selecttype() {//查询信息
	//alert("typeid为："+$("#typeid").val())
	var typeid=$("#typeid").val();
	if (typeid=="") {
		alert("查询无效请，请输入商品类别")
	}else{
		//alert("查询")
		window.location.href="${path}/operationType?operation=5&typeid="+typeid;
		//alert("已经查询")
	}
	
}

$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $typeid = $.trim($("#typeid1").val());//商品id
        //alert("商品id为："+$typeid)
        var $typename = $.trim($("#typename").val());
       // alert("商品名称为："+$typename)
      	var $proprice = $.trim($("#proprice").val());
      	var $pronum = $.trim($("#pronum").val());
      	var $prodate = $.trim($("#prodate").val());
      	var $supname = $.trim($("#supname").val());
      	var $typename = $.trim($("#typename").val());
	
      	 if ($typeid =='') {
           	//alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入商品id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*/.test($("#typeid1").val())){
        	//alert("商品id为："+$typeid)
        	layer.msg('输入错误，请输入正确的商品id',function() {time:2000});
       		return false;
       }
		
    	if ($typename =='') {
            // alert("您还未输入商品类型,请输入商品id")
             layer.msg('您还未输入商品类型，请输入',function() {time:2000});
             return false;
        	}
    });  
});	       
</script>
</html>