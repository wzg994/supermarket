<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试</title>
</head>
<body>
 <div id="content"> <!-- Content start -->
      <div class="inner_content">
          <div class="widgets_area">
                <div class="row-fluid">
                    <div class="span12">
                         <div  class="daohanglink"style="">
                           <span class="daohang"></span>
                           <span>首页</span><span>></span>
                           <span>订单管理</span><span>></span>
                           <span>修改订单</span>
                         </div>
                         
                          <!--    private String Uid; //订单编号
    private Date orderTime;//订单时间
    private double total;//订单金额
    private int status; //订单状态0:订单完成 1：已付款 2：发货
    private User user;//与下定单的用户管理
	private int  isDelete; //0:不删除 1：删除-->
                        <div class="well brown">
                         <form action="order_exUpdate.do"  method="post">
                              <div class="form_list"><label class="lable_title">订单号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input class="form_input" name="uid" type="text" value="${order.uid}" readonly="readonly"/></div>
                                    <input type="hidden" name="id"  value="${order.id}"/>
                            <div class="form_list"><label class="lable_title">订单时间&nbsp;&nbsp;</label>
                            <input class="form_input" name="orderTime" type="text" readonly="readonly" value="<fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></div>
                             <div class="form_list"><label class="lable_title">用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户</label>
                             <input class="form_input" name="user.userName" type="text" value="${order.user.loginName}" readonly="readonly"/></div>
                            <div class="form_list"><label class="lable_title">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
                            <input class="form_input" type="text" name="user.phone" value="${order.user.phone}" readonly="readonly"/></div>
                            <div class="form_list"><label class="lable_title">联系地址&nbsp;&nbsp;</label>
                            <input class="form_input" type="text" name="user.address" value="${order.user.address}" readonly="readonly"/></div>
                            <div class="form_list"><label class="lable_title">订单金额&nbsp;&nbsp;</label>
                            <input class="form_input" type="text" name="total" value="${order.total}"/></div>
                            <div class="form_list"><label class="lable_title">订单状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                           <select name="status" >
		                     <c:if test="${order.status == 0}">
						            <option value="0" selected="selected">未付款</option>
						     </c:if>
		                     <c:if test="${order.status == 1}">
						            <option value="1" selected="selected">已付款</option>
						     </c:if>
		                     <c:if test="${order.status == 2}">
						            <option value="2" selected="selected">交易成功</option>
						     </c:if>
		                     <c:if test="${order.status == 3}">
						            <option value="3" selected="selected">取消订单</option>
						     </c:if>
				            </select> 
<!-- 				             <select name="status" > -->
<!-- 						            <option value="0">未付款</option> -->
<!-- 						            <option value="1">已付款</option> -->
<!-- 						            <option value="2">已收货</option> -->
<!-- 				            </select> -->
                            </div>
                            
                            
                            <div class="form_list"><input type="submit" class="submit" value="&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;"></div>
                         </form>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>