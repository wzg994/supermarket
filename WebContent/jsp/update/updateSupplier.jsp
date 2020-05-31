<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>更新供应商</title>

<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>
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
		
			 
			<form class="layui-form"  id="form2"  
			style="margin-top: 20px;text-align:center;" >

			  <div id="divf" class="layui-form-item" style="width: 400px;">
			    <label id="lab1" class="layui-form-label">供应商编号</label>
			    <div class="layui-input-inline">
			      <input id="supid" value="${supplier.supid}" type="text" name="supid" required  lay-verify="required" placeholder="请输入供应商编号" autocomplete="on" class="layui-input" >
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
			   <%-- <div id="divf" class="layui-form-item" style="width: 400px">
			    <label id="lab1" class="layui-form-label" style="margin: 0px auto;">负责人</label>
			    <div class="layui-input-inline">
			      <input type="text" value="${supplier.person}" name="supperson" required lay-verify="required" placeholder="请输入负责人" autocomplete="off" class="layui-input">
			    </div>
			  </div> --%>
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
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="button" id="cx">确定</button>
			      <button type="button" class="layui-btn layui-btn-primary" onclick="back()">返回</a></button>
			     <!--  <button type="reset" class="layui-btn layui-btn-primary">重置</button> -->
			    </div>
			  </div>
			</form>
</body>
<script type="text/javascript">
function sub() {
	//alert("更新中")
	$.ajax({
		url:"${path}/updateSupplie",
		type:"post",
		dataType:"json",
		data:$("#form2").serialize(),
		success:function(result){
			if (result.type==1) {
				//alert("OK")
				 window.parent.location.reload();//刷新父窗体
				
		         var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		         //alert("窗体为："+index)
		         parent.layer.close(index);//关闭窗口
			}
			
		}
	})
}
function back() {
	//alert("返回")
		window.parent.location.reload();//刷新父窗体
				
		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		//11alert("窗体为："+index)
		parent.layer.close(index);//关闭窗口
}
$(document).ready(function(){
    $('#cx').click(function(){  //name为标识
       // var $purid = $.trim($("#purid").val());//供应商id
       
        var $supid = $.trim($("#supid").val());
        alert("供应商idid为："+$supid)
      	var $supname = $.trim($("#supname").val());
        alert("商品名称商idid为："+$supname)
    	var $suptel = $.trim($("#suptel").val());
      	var $address = $.trim($("#address").val());
      	//var $purdate = $.trim($("#purdate").val());
      	//var $supname = $.trim($("#supname").val());
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
         if($supid == ''){
         	alert("商品id为"+$shopid)
            layer.msg('请输入商品ID',function() {time:2000}); 
             return false;  
         } 
       if($supname == ''){  
            layer.msg('请输入商品名称！',function() {time:2000});
            return false; 
        }
       
       if($suptel == ''){  
           layer.msg('请输入商品价格！',function() {time:2000});
           return false; 
       }else if (!/^1[34578]\d{9}$/.test($("#suptel").val())) {
			alert("您还未输入商品id,请输入商品价格"+$shopprice)
          	layer.msg('输入错误,请输入正确的商品价格,如xx.xx',function() {time:2000});
          	return false;
		}
       
       if ($address =='') {
         	
         	layer.msg('请输入商品数量',function() {time:2000});
         	return false;
   		}
       
       
       
     alert("更新中")
   	$.ajax({
   		url:"${path}/updateSupplie",
   		type:"post",
   		dataType:"json",
   		data:$("#form2").serialize(),
   		success:function(result){
   			if (result.type==1) {
   				//alert("OK")
   				 window.parent.location.reload();//刷新父窗体
   				
   		         var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
   		         //alert("窗体为："+index)
   		         parent.layer.close(index);//关闭窗口
   			}
   			
   		}
   	})
     
    });  
});


</script>
</html>