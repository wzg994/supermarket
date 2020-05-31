<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>超市管理系统</title>

<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>

</head>
<body onload="showtime()">
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
			<!-- <form name=clock >  
<input name=thetime style="font-size: 9pt;border:0" size=100>  
</form>  -->
		 <div class="layui-logo" >你好！${user.username}欢迎使用
		
		 </div>
		  <ul class="layui-nav layui-layout-left" style="margin-top:20px;">
		   <li id="clock1" style="">
  			</li>
		  </ul>	
		 
		 <ul class="layui-nav layui-layout-right" >
		     
		      
		      <li class="layui-nav-item">
		        <a href="javascript:;">
		          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
		          
		        </a>
		        <dl class="layui-nav-child">
		       <dd><a onclick="update('${user.username}')">基本资料</a></dd>
		       <dd><a href="${path}/jsp/update/adminupdatePass.jsp" >修改密码</a></dd>
		         <%--  <dd><button  onclick="update(${staff.staffname})">基本资料</button></dd> 	 --%>
		          <!--  <dd><a href="">修改密码</a></dd>-->
		        </dl>
		      </li>
		      <li class="layui-nav-item"><a href="${path}/quit?operatioan=1">退出</a></li>
		    </ul>
		  </div>
		  
		  <div class="layui-side layui-bg-black">
		    <div class="layui-side-scroll">
		      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
		      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		        <li class="layui-nav-item">
		          <a class="" href="javascript:;">进货管理</a>
		          <dl class="layui-nav-child">
		            <dd><a href="${path}/purchaseShow" target="frame1">进货信息</a></dd>
		            <dd><a href="${path}/repurchaseShow" target="frame1">退货信息</a></dd>
		          </dl>
		        </li>
				<li class="layui-nav-item">
				  <a class="" href="javascript:;">商品信息管理</a>
				  <dl class="layui-nav-child">
				    <dd><a href="${path}/productshow" target="frame1">商品信息</a></dd>
				    <dd><a href="${path}/typeShow" target="frame1">商品类别</a></dd>
				    <dd><a href="${path}/stockShow" target="frame1">商品存库</a></dd>
				    <!--  <dd><a href="javascript:;">库存预警</a></dd>-->
				  </dl>
				</li>
				<li class="layui-nav-item">
				  <a class="" href="javascript:;">销售管理</a>
				  <dl class="layui-nav-child">
				    <dd><a href="${path}/saleShow" target="frame1">销售信息</a></dd>
				    <!-- <dd><a href="javascript:;">顾客退货办理</a></dd>-->
				  </dl>
				</li>
				<%-- <li class="layui-nav-item">
				  <a class="" href="javascript:;">客户信息管理</a>
				  <dl class="layui-nav-child">
				    <dd><a href="${path}/customerShow" target="frame1">客户信息</a></dd>
				  </dl>
				</li> --%>
		        <li class="layui-nav-item">
		          <a href="javascript:;">供应商管理</a>
		          <dl class="layui-nav-child">
		            <dd><a href="${path}/supplierShow" target="frame1">供应商信息</a></dd>
		          </dl>
		        </li>
				<li class="layui-nav-item">
				  <a href="javascript:;">员工信息管理</a>
				  <dl class="layui-nav-child">
				    <dd><a href="${path}/staffShow" target="frame1">员工信息</a></dd>
				    <dd><a href="${path}/attendShow" target="frame1">员工考勤</a></dd>
				  </dl>
				</li>
		      </ul>
		 </div>
	 </div>
		  
		  <div class="layui-body" style="margin-left: 20px">
		   <!--empty 判断对象是否为空
		为空是 true
		不为空是 false
	  -->
 
<%--  <span id="sp1" style="color:  red;margin: 0 auto;">${msg}</span> --%>



 <!--库存不足提示区  -->
<%-- <c:if test="${not empty msg}">
 <span style="color:  red;margin: 0 auto;">${msg}11</span>
</c:if> --%>


 <!-- <div id="dd1" class="layui-body" style="margin-left: 20px;height: 20px;border: 1px pink solid;">
 
 </div> -->
        
		    <!-- 内容主体区域 1-->
		    <div style="padding: 20px;">

		    <iframe name="frame1" style="width: 1100px;height: 500px;scrolling:no;" frameborder="0">
			
			
		</iframe>
		
		</div>
		  </div>
		  
		  <div class="layui-footer" style="text-align: center;">
		    <!-- 底部固定区域 -->
		  <h2>超市管理系统</h2> 
		  </div>
		</div>
</body>
<script type="text/javascript">

var timerID = null;  
var timerRunning = false;  

function showtime() {  
    var now = new Date();  
    var year=now.getFullYear(); //获取年份 
    var month=now.getMonth(); //获取月份 
    month=month+1; 
  	if(month<10){month="0"+month}
    var date=now.getDate(); //获取日期 
    if(date<10){date="0"+date}
    var day=now.getDay(); //获取星期 
    var hour=now.getHours(); //获取小时 
    if(hour<10){hour="0"+hour}
    var minu=now.getMinutes(); //获取分钟 
    if(minu<10){minu="0"+minu}
    var sec=now.getSeconds(); //获取秒钟 
    if(sec<10){sec="0"+sec}
    
    var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
    var week=arr_week[day]; //获取中文的星期 
    var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间 
    clock1.innerHTML=time; //显示系统时间 
    //document.clock.thetime.value = time;  
    timerID = setTimeout("showtime()", 1000);  
    timerRunning = true;  
} 



//setInterval("test()",2000);

//window.onload=function(){
function test(){
	$.ajax({
		type:"post",
		url:"${path}/UserServlet",
		//async : true,
		data:{
			"msg":"${msg}"
			//"username":	${user.username}
		},
		dataType:"text",
		success:function(result){
			//if (result!="") {
				console.log("kong"+result);
				var m1=document.getElementById("dd1");
				m1.innerHTML=" <span style='color:  red;margin: 0 auto;height:10px;'>"+result+"</span>";
				//location.reload(true);
				//}else {
					//var m1=document.getElementById("dd1");
				//	m1.innerHTML=" <span style='color:  red;margin: 0 auto;'></span>";
				
		//	}
			//var m=document.getElementById("sp1");
			//m.innerHTML=result;
			//console.log("11"+result);
			//var m1=document.getElementById("ddd");
			//m1.innerHTML=" <span style='color:  red;margin: 0 auto;'>${msg}</span>"
		}
	}); 
	

	
};


layui.use(['layer', 'form',], function(){
	   layer = layui.layer;
	   form = layui.form; 
	});
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		
		//修改
		function update(username) {
			//alert("显示管理员名字为"+username);
			//window.location.href="${path}/operationPurchase?operation=2&purid="+purid;
			layer.open({
			      type: 2,
			      area: ['600px', '400px'],
			      title:'管理员信息',
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
			      content: "${path}/operationmaster?operation=2&username="+username
			    });
		}
		
		
		//修改
	/* 	function update() {
			alert("打开");
			
			layer.open({
			      type: 1,
			      area: ['600px', '400px'],
			      title:'更新供应商',
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

			    });
		} */

/* function name(${ empty user}) {
	
} */		
	


</script>
</html>