<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>供应商查询界面</title>
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

	

<table class="layui-table">

		<tr>
			<th>客户编号</th>
			<th>客户姓名</th>
			<th>客户电话</th>
			<th>负责人</th>
			<th>客户地址</th>
			<th>客户邮箱</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${customer}" var="customer">
			<tr>
				<td>${customer.cusid}</td>
				<td>${customer.cusname}</td>
				<td>${customer.custel}</td>
				<td>${customer.person}</td>
				<td>${customer.address}</td>
				<td>${customer.email}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${purchase.purid})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${purchase.purid})">
                   
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
<div  class="layui-form-item"style="width: 400px">
			    <div  id="lab1" class="layui-input-block" >
			     <!--  <button class="layui-btn" lay-submit lay-filter="formDemo" type="button" onclick="sub()">确定</button> -->
			      <button type="button" class="layui-btn layui-btn-normal"  ><a href="${path}/customerShow" >返回</a></button>
			    </div>
			  </div>




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


//添加
/* function selectshop(supId) {
	window.location.href="${path}/operationSupplier?operation=1&supplierId="+supId
}  */

//修改
function update(supplierId) {
	alert("更新  supplierId "+supplierId);
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
//删除
function del(supplierId) {
	alert("正在删除")
	window.location.href="${path}/operationSupplier?operation=4&supplierId="+supplierId;
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

/* function sub() {
	alert("确定")
		window.parent.location.reload();//刷新父窗体		
		var index = parent.layer.getFrameIndex(window.name);//获取窗口索引
		alert("窗体为："+index)
		parent.layer.close(index);//关闭窗口
} */
function selectshop() {
	alert($("#supid1").val())
	var supid=$("#supid1").val();
	if (supid=="") {
		alert("查询无效请，请输入供应商id")
	}else{
		alert("查询")
		window.location.href="${path}/operationSupplier?operation=5&supplierId="+supid;
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
    $('#cx').click(function(){  
        var id = $.trim($("#supid").val());
        alert("初始id为："+id)
        var $name = $.trim($("#supname").val());
      	var $3 = $.trim($("#suptel").val());
      /*   var $4 = $.trim($("#stock").val());
        var $5 = $.trim($("#remarks").val());    */
         if(id == ''){
        	alert("id为"+id)
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
      if($3 == ''){  
            layer.msg('请输入电话号码！',function() {time:2000});
            return false; 
        }else if (!/^1[34578]\d{9}$/.test($("#suptel").val())) {
        	alert("电话号码是"+3)
			alert("请输入正确的电话号码")
		}
       /*  if($4 == ''){  
            layer.msg('请输入商品库存！',function() {time:2000});
            return false; 
        }  */ 
     
    });  
});

</script>
</html>