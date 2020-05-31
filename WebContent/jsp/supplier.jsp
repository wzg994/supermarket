<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>供应商信息界面</title>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>


<%-- <script src="${path}/res/tools/layui/lay/modules/layer.js"></script> --%>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
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
<c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}</span>
</c:if>
<fieldset class="layui-elem-field">
<div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">供应商信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
	<hr>
 	<div  style="margin-top:10px;" >
		 <div class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">供应商名称</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="supid1" name="supid" placeholder="请输入供应商名称 "  class="layui-input" >
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectshop()">查询商品</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增供应商</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>供应商编号</th>
			<th>供应商姓名</th>
			<th>供应商电话</th>
			<th>供应商地址</th>
			<th>供应商备注</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${supplierBypage}" var="supplier">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${supplier.supid}</td>
				<td>${supplier.supname}</td>
				<td>${supplier.suptel}</td>
				<td>${supplier.address}</td>
				<td>${supplier.email}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${supplier.supid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${supplier.supid})">
                   
                 </td>
			</tr>
		</c:forEach>
	</table>

<div >
	<!--分页文字信息  -->
	<div style="width: auto;float: left;display: inline-block;margin-top: 2px;">当前 ${nowPage}页,总 ${allpage}页,共${totalsize}条记录</div>
	<!-- 分页按钮 -->
<div style="width: auto;margin-left: 500px;display: inline-block;">

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
</div>
	
</fieldset>



<form class="layui-form" action="${path}/addSupplier" id="form1" hidden="hidden" style="margin-top: 20px;text-align:center;" >
			  <div id="divf" class="layui-form-item" style="width: 400px;">
			    <label id="lab1" class="layui-form-label">供应商编号</label>
			    <div class="layui-input-inline">
			      <input id="supid" value="${supplier.supid}" lay-verify="supid" type="text" name="supid" required  lay-verify="required" placeholder="请输入供应商编号" autocomplete="on" class="layui-input" >
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label">供应商名称</label>
			    <div class="layui-input-inline">
			      <input id="supname" value="${supplier.supname}" name="supname" type="text"  required lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label">供应商电话</label>
			    <div class="layui-input-inline">
			      <input id="suptel" type="text" value="${supplier.suptel}" name="suptel" required lay-verify="required" placeholder="请输入供应商电话" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label" style="margin: 0px auto;">负责人</label>
			    <div class="layui-input-inline">
			      <input id="supperson" type="text" value="${supplier.person}" name="supperson" required lay-verify="required" placeholder="请输入负责人" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label" >供应商地址</label>
			    <div class="layui-input-inline">
			      <input id="address" type="text" value="${supplier.address}" name="address" required lay-verify="required" placeholder="请输入供应商地址" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label">供应商备注</label>
			    <div class="layui-input-inline">
			      <input id="mark" type="text" value="${supplier.email}" name="email" required lay-verify="required" placeholder="请输入供应备注" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  
			  <div  class="layui-form-item">
			    <div  id="lab1" class="layui-input-block" >
			     <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="cx">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary"  ><a href="${path}/supplierShow">返回</a></button>
			    </div>
			  </div>
			</form>
			
			

			
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
function update(supplierId) {
	//alert("更新  supplierId "+supplierId);
	//window.location.href="${path}/operationSupplier?operation=2&supplierId="+supplierId
 	layer.open({
	      type: 2,
	      area: ['600px', '500px'],
	      title:'更新供应商',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 0//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: "${path}/operationSupplier?operation=2&supplierId="+supplierId
	    });   
	//"${path}/operationSupplier?operation=2&supplierId="+supplierId
}

/* $(document).ready(function(){
    $('#up').click(function(){ 
    	alert("确定")
		window.parent.location.reload();//刷新父窗体
				
		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		alert("窗体为："+index)
		parent.layer.close(index);//关闭窗口
    });  
}); */

//删除
function del(supplierId) {
	//alert("正在删除")
	window.location.href="${path}/operationSupplier?operation=4&supplierId="+supplierId;
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'新增供应商',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	      //,btn: ['确定', '取消', '返回']
	    	/* ,yes: function(index, layero){
	        //按钮【按钮一】的回调
	        alert("按钮一");
	      } */
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    //return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: $('#form1')
	    });
	

} 

function selectshop() {//查询信息
	//alert($("#supid1").val())
	var supid=$("#supid1").val();
	if (supid=="") {
		alert("查询无效请，请输入供应商id")
	}else{
		//alert("查询")
		window.location.href="${path}/operationSupplier?operation=5&supname="+supid;
	}
	
/* 	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'查询商品',
	     // skin: 'demo-class',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮 
	      ,resize:false//固定大小
	      ,content: $('#form2')
	    });  */
	/* $.ajax({
		url:"${path}/operationSupplier",
		type:"get",
		dataType:"json",
		data:$("#text1").serialize(),
		success:function(result){
			if (result.type==5) {
				alert("查询OK")
				 //window.parent.location.reload();
		        // var index = parent.layer.getFrameIndex(window.name);
		         //parent.layer.close(index);
			}
			
		}
	}) */
}

$(document).ready(function(){
    $('#cx').click(function(){  //name为标识
        var id = $.trim($("#supid").val());//供应商id
        //alert("初始id为："+id)
        var $name = $.trim($("#supname").val());
      	var $suptel = $.trim($("#suptel").val());
      	var $person = $.trim($("#supperson").val());
      	var $address = $.trim($("#address").val());
      	var $mark = $.trim($("#mark").val());
      	
      /*   var $4 = $.trim($("#stock").val());
        var $5 = $.trim($("#remarks").val());    */
         if(id == ''){
        	//alert("id为"+id)
            layer.msg('商品单号不能为空',function() {time:2000}); 
            return false;  
        } 
      /*   form.verify({
        	//将用户名是否可用作为验证条件  表单提交时触发
        	,supid:function(value){
        		var datas={supid: value};
        		var message = '';
        		$.ajax({
        			type:"POST",
        			url:"${path}/operationSupplier",
        			async: false, //改为同步请求
        			contentType:'application/json;charset=UTF-8',
        			data:JSON.stringify(datas),
        			dataType:'json',
        			success:function(data){
        				if(data){
        					
        				}else{
        					message ="用户名已存在，请重新输入！"
        				}
        			}
        		});
        		//需要注意  需要将返回信息写在ajax方法外
        		if (message !== '') 
                  	return message;
        	}
        }); */
       if($name == ''){  
            layer.msg('请输入商品名称！',function() {time:2000});
            return false; 
        }
      if($suptel == ''){  
            layer.msg('请输入电话号码！',function() {time:2000});
            return false; 
        }else if (!/^1[34578]\d{9}$/.test($("#suptel").val())) {
        	//alert("电话号码是"+$suptel)
        	layer.msg('请输入正确的电话号码！',function() {time:2000});
        	return false; 
		}
      if($person == ''){  
          layer.msg('请输入负责人！',function() {time:2000});
          //alert("负责人是"+$person)
          return false; 
      }
      if($address == ''){  
          layer.msg('请输入供应商地址！',function() {time:2000});
          return false; 
      }
     /*  if($mark == ''){  
          layer.msg('请输入备注！',function() {time:2000});
          return false; 
      } */
      
       /*  if($4 == ''){  
            layer.msg('请输入商品库存！',function() {time:2000});
            return false; 
        }  */ 
     
    });  
});

</script>
</html>