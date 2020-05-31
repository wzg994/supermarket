<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工信息界面</title>
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
<fieldset class="layui-elem-field">
<div class="x_title row">
	<h2 style="margin-bottom:10px;text-align: center;">管理员信息列表 </h2>
	     <div class="clearfix"></div>
	</div>
<hr>
 <div  style="margin-top:10px;" >
		 <div  class="layui-form-item" style="margin-top: 10px">
			 <label class="layui-form-label" style="color: black;">管理员名称</label>
			 <div  class="layui-input-inline">
			 <input type="text" id="staffid" name="te1" placeholder="请输入管理员名称"  class="layui-input">
			 	</div>
			 <div style="float: left">
			 <button id="btn1" class="layui-btn layui-btn-normal layui-btn-sm" onclick="selectstaff()">查询管理员</button>
			 	</div>		   
			 <div>
			 <button id="btn2" class="layui-btn layui-btn-normal layui-btn-sm" style="float: right;margin-right: 10px" onclick="addshop()" >新增管理员</button>
	 			</div>
		</div>				 
	 </div> 
	

<table class="layui-table">

		<tr>
			<th>管理员编号</th>
			<th>管理员姓名</th>
			<th>管理员密码</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${adminBypage}" var="admin">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td>${admin.id}</td>
				<td>${admin.username}</td>
				<td>${admin.password}</td>
                 <td>
                 <input type="button" class="layui-btn layui-btn-sm" value="修改" onclick="update(${admin.id})">
                   <input type="button" class="layui-btn layui-btn-sm" value="删除"  onclick="del(${admin.id})">
                   
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
        <a href="${path}/adminShow?nowpage=${page}">
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
<c:if test="${not empty adminerr}">
<span style="color:  red;margin: 0 auto;">${adminerr}</span>
</c:if>


<form class="layui-form" action="${path}/addAdmin" id="form1" hidden="hidden" style="margin-top: 20px;text-align:center;width: 400px;">
			
			
			<c:if test="${not empty adminerr}">


 			<div id="divf" class="layui-form-item" >
			 
			 <span style="color:  red;margin: 0 auto;">${adminerr}</span>
			   <!--  <label id="lab1" class="layui-form-label">管理员编号</label>
			    <div class="layui-input-inline">
			      <input id="id" type="text" name="id"  required  lay-verify="required" placeholder="请输入员工编号" autocomplete="on" class="layui-input">
			    </div> -->
			  </div> 
			  </c:if>
			  <div id="divf" class="layui-form-item" >
			    <label id="lab1" class="layui-form-label">管理员ID1</label>
			    <div class="layui-input-inline">
			      <input id="id" type="text" name="id"  required  lay-verify="required" placeholder="请输入管理员ID" autocomplete="on" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item" >
			    <label id="lab1" class="layui-form-label">管理员账号</label>
			    <div class="layui-input-inline">
			      <input id="username" name="username"  type="text"  required lay-verify="required" placeholder="请输入管理员账号" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			  <div id="divf" class="layui-form-item" >
			    <label id="lab1" class="layui-form-label">管理员密码</label>
			    <div class="layui-input-inline">
			      <input id="password" type="text" name="password"  required lay-verify="required" placeholder="请输入管理员密码" autocomplete="off" class="layui-input">
			    </div>
			  </div>
			   
			  <div class="layui-form-item" >
			    <div id="lab1" class="layui-input-block">
			      <button class="layui-btn layui-btn-primary" lay-submit lay-filter="formDemo" type="submit" id="cx">确认</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			      <button type="button" class="layui-btn layui-btn-primary" ><a href="${path}/staffShow">返回</a></button>
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
function update(staffid) {
	//alert("更新商品id为"+staffid);
	//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
	layer.open({
	      type: 2,
	      area: ['600px', '400px'],
	      title:'更新员工信息',
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
	      content: "${path}/operationAdmin?operation=2&id="+staffid
	    });
}
//删除
function del(staffid) {
	window.location.href="${path}/operationStaff?operation=4&staffid="+staffid;
}

function addshop() {
	layer.open({
	      type: 1,
	      area: ['600px', '400px'],
	      title:'新增员工',
	      offset: 'auto',//坐标水平居中	
	      btnAlign: 'c',//按钮对齐方式
	      closeBtn: 2//关闭按钮
	      ,anim: 1  
	      ,resize:false//固定大小
	    	,yes: function(index, layero){
	        //按钮【按钮一】的回调
	       // alert("按钮一");
	      }
	      ,cancel: function(){ 
	    	    //右上角关闭回调
	    	    //return false //开启该代码可禁止点击该按钮关闭
	    	  }
	      ,shadeClose: true, //点击遮罩关闭
	      content: $('#form1')
	    });
	

} 

function selectstaff() {//查询信息
	//alert("staffid为："+$("#staffid").val())
	var staffid=$("#staffid").val();
	if (staffid=="") {
		alert("查询无效请，请输入管理员名称")
	}else{
		//alert("查询")
		window.location.href="${path}/operationAdmin?operation=5&username="+staffid;
		//alert("已经查询")
	}
	
}

$(document).ready(function(){
    $('#confirm').click(function(){  //name为标识
        var $staffid = $.trim($("#staffid1").val());//商品id
        alert("商品id为："+$staffid)
        var $staffname = $.trim($("#staffname").val());
        alert("商品名称为："+$staffname)
      	var $idnum = $.trim($("#idnum").val());
      	var $sex = $.trim($("#sex").val());
      	var $tel = $.trim($("#tel").val());
      	var $staffadd = $.trim($("#staffadd").val());
      	var $staffedu = $.trim($("#staffedu").val());
      	var $staffpassword = $.trim($("#staffpassword").val());
      	
      	 if ($staffid =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户id',function() {time:2000});
           	return false;
     		}else if(!/^[1-9]\d*/.test($("#staffid1").val())){
        	alert("商品id为："+$saleid)
        	layer.msg('输入错误，请输入正确的客户id',function() {time:2000});
       		return false;
       }
		
    	if ($staffname =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入客户名字',function() {time:2000});
             return false;
        	}
    	
    	if ($idnum =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户电话',function() {time:2000});
           	return false;
     		}else if (!/^1[34578]\d{9}$/.test($("#idnum").val())) {
            	alert("电话号码是"+$suptel)
            	layer.msg('请输入正确的电话号码！',function() {time:2000});
            	return false; 
    		} 
		
    	if ($sex =='') {
             alert("您还未输入商品类型,请输入商品id")
             layer.msg('请输入负责人',function() {time:2000});
             return false;
        	}
    	
    	if ($tel =='') {
           	alert("您还未输入商品id,请输入商品id")
           	layer.msg('请输入客户地址',function() {time:2000});
           	return false;
     		}
		
    	if ($staffadd =='') {
            alert("您还未输入商品类型,请输入商品id")
            layer.msg('请输入负责人',function() {time:2000});
            return false;
       	}
   	
   	if ($staffedu =='') {
          	alert("您还未输入商品id,请输入商品id")
          	layer.msg('请输入客户地址',function() {time:2000});
          	return false;
    	}
   	
   	if ($staffpassword =='') {
        alert("您还未输入商品类型,请输入商品id")
        layer.msg('请输入负责人',function() {time:2000});
        return false;
   	}
	
	
    });  
});	

</script>
</html>