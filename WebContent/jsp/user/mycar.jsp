<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
<!-- 导入Jquery -->
<script type="text/javascript"  src="${path}/res/jquery/jquery-3.2.1.js"></script>
<!--<link rel="stylesheet" href="${path}/res/bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"/>-->
<!--<script type="text/javascript" src="${path}/res/bootstrap-3.3.7-dist/js/bootstrap.js"></script>-->
<link href="${path}/res/tools/layui/css/layui.css"  type="text/css"  rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="${path}/res/css/myCss.css"/>
<script type="text/javascript"  src="${path }/res/tools/layui/layui.js"></script>

</head>
<body>
	<table class="layui-table">
		<tr>
			<th>图片</th>
			<th>名称</th>
			<th>数量</th>
			<th>价格</th>
			<th>总价</th>
			<th>操作</th>
		</tr>
		<c:set var="totalPrice"  value="0"></c:set>
		<c:forEach items="${cars}" var="car">
		  <c:set var="allPrice"    value="${car.carMessage.shopp_number *car.shopMessage.price }"></c:set>
			<c:set var="totalPrice"   value="${allPrice+totalPrice}"></c:set>
			<tr>
				<td><img src="${path}${car.shopMessage.img}"  width="100px" height="100px"></img></td>
				<td>${car.shopMessage.name}</td>
				<td>${car.carMessage.shopp_number}</td>
				<td>${car.shopMessage.price}</td>
                 <td>${allPrice}</td>
                 <td>
                   <input type="button" value="一" onclick="subNum(${car.carMessage.shopp_id})">
                   <input type="text"  size="2"  value="${car.carMessage.shopp_number}"  onchange="updateNum(${car.carMessage.shopp_id },$(this))">
                   <input type="button" value="十"  onclick="addNum(${car.carMessage.shopp_id})">
                   <input type="button" value="删除"  onclick="del(${car.carMessage.shopp_id})">
                 </td>
			</tr>
		</c:forEach>
          <tr>
               <td></td><td></td><td></td><td></td><td></td><td colspan="2">总价：${totalPrice}</td>
          
          </tr>
       <tr>
       <td></td><td></td><td></td><td></td><td></td><td colspan="2"><a class="btn btn-default" href="${path }/jsp/user/addOrder.jsp"  role="button">下单
       </a>
       <button type="button" class="btn btn-success">（成功）Success</button>
       </td>
       </tr>



	</table>
</body>
<script type="text/javascript">
//商品数量减少
function subNum(shopId){
	window.location.href="${path}/opera?operation=2&shoppId="+shopId;
}
//添加
function addNum(shopId) {
	window.location.href="${path}/opera?operation=1&shoppId="+shopId;
}

//修改
function updateNum(shopId,obj) {
	window.location.href="${path}/opera?operation=3&shoppId="+shopId+"&newNumber="+obj.val();
}
//删除
function del(shopId) {
	window.location.href="${path}/opera?operation=4&shoppId="+shopId;
}









</script>
</html>