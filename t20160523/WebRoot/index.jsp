<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <body>
 
 <table border="1">
     <tr>        
         <td>卡号</td>
        <td>姓名</td>
         <td>性别</td>
         <td>办卡日期</td>
     </tr>
     <!-- 使用struts2标签库中的iterator将所有数据遍历循环显示出来 -->
     <s:iterator value="#myBookCardList" status="bcs">
         <tr>    
            <td><s:property value="cid"></s:property></td>
             <td><s:property value="name"></s:property></td>
             <td><s:property value="sex"></s:property></td>
             <td><s:date name="cardDate" format="yyyy年MM月dd日"></s:date></td>
        </tr>
    </s:iterator>
    <!-- 判断查询出来等于0，就显示“没有查找到数据” -->
     <s:if test="myBookCardList.size()==0">
         <tr>                    
             <td colspan="7">没有查找到数据</td>
        </tr>
     </s:if>
 </table>
 </body> <br>
  </body>
</html>
