<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>
<style type="text/css">
#div01{
   float: left;  
   width: 300px;
   height: 300px;
   border: 1px red solid;
}



</style>
</head>
<body>
	<h1>首页</h1>
	<h2>
		<a href="index.jsp">登入页面</a>
	</h2>
	<h3>
	<a href="${path}/jsp/menu.jsp">进入系统</a>
	
	</h3>
	<button>进入系统</button>
	<h2>
	<a href="${path}/getcar">查看我的购物车</a>
	</h2>
	<h2><a href="${path}/jsp/upload.jsp">文件上传页面</a></h2>
	<span>${filePath}</span>
<hr/>
<!-- 商品展示 -->
<div style="width: auto;height: 1000px;">
   <!-- 遍历商品 -->
   <c:forEach var="shop" items="${shopsBypage}">
      <div id="div01">
          <img src="${path}${shop.img}"  width="300px" height="200px"/>
          商品名称:<span>${shop.name}</span> <br/>
          商品价格:<span>${shop.price}</span> <br/>
          商品数量:<span>${shop.p_small}</span> <br/>
          <button onclick="addcar(${shop.id},${shop.p_small})">加入购物车</button>
   
       </div>
   </c:forEach>
</div>
<!-- 分页按钮 -->
<div style="width: 200px;margin-left: 500px;margin-top:-400px ">
   <c:forEach begin="1"   end="${allpage}"  var="page">
        <a href="${path}/shopsByPage?nowpage=${page}">
            <c:if test="${page==nowPage}">
                 <button style="color: red">${page}</button>
            </c:if>
            <c:if test="${page!=nowPage}">
                  <button>${page}</button>
            </c:if>
        </a>
   </c:forEach>
</div>
</body>
 <script type="text/javascript">
  function addcar(shoppId,shopnum) {
	   if(${empty user}){
		  alert("请先登入");
  }else {
		 $.ajax({
			 type:"post",
			 url:"${path}/user/addcar",
			 data:{  //给后台传参数  请求参数
				 "shoppId": shoppId,
				 "shopnum": shopnum
			 },
			 dataType:"json",
			 success:function(result){
				  if(result.type==1){
					  alert("添加购物车成功！")
					  
				  }else if (result.type==2) {
					  alert("商品已卖完!!!")
				}else{
					  location.reload();
					  alert("购物车数量加1")
				  }
				 
			 }		 
		 });
	} 
	  
	  
    }

</script>
</html>