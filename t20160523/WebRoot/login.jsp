<%@ page language="java" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <form action="/testStruts/front/login.action" method="post">
    	���������˺ţ�<input name="account" type="text"><BR>
    	�����������룺<input name="password" type="password">
    	<input type="submit" value="��¼">
	</form>    
	<form action="back/login!testMyjsp.action" method="post">
    	���������˺ţ�<input name="account" type="text"><BR>
    	�����������룺<input name="password" type="password">
    	<input type="submit" value="��¼">
	</form>  
	<form action="back/login.action" method="post">
    	���������˺ţ�<input name="account" type="text"><BR>
    	�����������룺<input name="password" type="password">
    	<input type="submit" value="��¼">
	</form>  
  </body>
</html>
