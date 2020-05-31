<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>商品信息页面</title>

<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>


<%-- <script src="${path}/res/tools/layui/lay/modules/layer.js"></script> --%>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/>
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

	

<table class="layui-table" style="margin-top: 20px">

		<tr>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品数量</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${shopsBypage}" var="shop">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<!--  <td><img src="${path}${shop.img}"  width="100px" height="100px"></img></td>-->
				<td>${shop.name}</td>
				<td>${shop.price}</td>
				<td>${shop.p_small}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="一" onclick="subNum(${shop.id})">
                 
                  <input type="text"  size="2"  value="${shop.p_small}"  onchange="updateNum(${shop.id },$(this))">
                   <input type="button"  class="layui-btn layui-btn-sm" value="十"  onclick="addNum(${shop.id})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${shop.id})">
                   
                  <!--  <button onclick="addcar(${shop.id},${shop.p_small})">加入购物车</button> -->
                 </td>
			</tr>
		</c:forEach>
	</table>

<!-- 分页按钮 -->
<div id="div01" style="width: auto;margin-left: 500px;margin-top:10px ">
   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/shopShow?nowpage=${page}">
            <c:if test="${page==nowPage}">
                 <button class="layui-btn layui-btn-normal layui-btn-sm" style="color: red;">${page}</button>
            </c:if>
            <c:if test="${page!=nowPage}">
                  <button class="layui-btn layui-btn-normal layui-btn-sm">${page}</button>
            </c:if>
        </a>
   </c:forEach>
</div>




<form class="layui-form" action="" id="form1" hidden="hidden">
			  <div class="layui-form-item">
			    <label class="layui-form-label">商品名称</label>
			    <div class="layui-input-inline">
			      <input type="text" name="title" required  lay-verify="required" placeholder="请输入商品名称" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">商品数量</label>
			    <div class="layui-input-inline">
			      <input id="num" name="num" type="text" name="password" required lay-verify="required" placeholder="请输入商品数量" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">商品价格</label>
			    <div class="layui-input-inline">
			      <input type="text" name="password" required lay-verify="required" placeholder="请输入商品价格" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			 
			  <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
			</form>

</body>
<script>
;!function(){
  //无需再执行layui.use()方法加载模块，直接使用即可
  var form = layui.form
  ,layer = layui.layer;
  
  //…
}();
</script> 
<script type="text/javascript">


layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});

//商品数量减少
function subNum(shopId){
	window.location.href="${path}/operationshop?operation=2&shoppId="+shopId;
}
//添加
function addNum(shopId) {
	window.location.href="${path}/operationshop?operation=1&shoppId="+shopId;
}

//修改
function updateNum(shopId,obj) {
	window.location.href="${path}/operationshop?operation=3&shoppId="+shopId+"&newNumber="+obj.val();
}
//删除
function del(shopId) {
	window.location.href="${path}/operationshop?operation=4&shoppId="+shopId;
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
	      ,btn: ['确定', '取消', '返回']
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


/*判断输入id是不是数字  */
/* function checkinid()
{
	var num = document.getElementById('inid').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo1").innerHTML=" ";
		return true;
		}else{
			document.getElementById("demo1").innerHTML="请输入正确的订单id！";
			document.getElementById('inid').value="";
			document.getElementById('inid').focus();
			return false;
			}
		}
else{
		document.getElementById("demo1").innerHTML="请输入订单id！";
	document.getElementById('inid').focus();
	return false;
	}
} */

/*  校验商品名称*/
/* function checkname(){
	var name=document.getElementById('pname').value;
   	if(name){
	document.getElementById("demo2").innerHTML=" ";
	return true;
}else{
	document.getElementById("demo2").innerHTML="请输入商品名称！";
	document.getElementById('pname').focus();
	return false;
}
} */


/*判断输入的id是不是数字  */
/* function checkproid()
{
	var num = document.getElementById('proid').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo3").innerHTML=" ";
		return true;
		}else{
			document.getElementById("demo3").innerHTML="请输入正确的商品id！";
			document.getElementById('proid').value="";
			document.getElementById('proid').focus();
			return false;
			}
		}
else{
		document.getElementById("demo3").innerHTML="请输入商品id！";
	document.getElementById('proid').focus();
	return false;
	} */
/*  }*/
/* function checknum()
{
	var num = document.getElementById('num').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo4").innerHTML=" ";
		return true;
		}else{
			document.getElementById("demo4").innerHTML="请输入正确的商品数量！";
			document.getElementById('num').value="";
			document.getElementById('num').focus();
			return false;
			}
		}
else{
		document.getElementById("demo4").innerHTML="请输入商品数量！";
	document.getElementById('num').focus();
	return false;
	}
}
 */
/* 校验整个表单 */
/* function checkall(){
			 var inid=checkinid();
	         var name = checkname();  
	         var proid=checkproid(); 
	         var num=checknum(); 
	         
	         if(inid&&name&&proid&&num){  
				 alert("添加成功"); 
	             return true;
	         }else{  
		 			alert("添加失败，请重新填写数据");
	             return false;
	 			
	         }  
} */




</script>

</html>